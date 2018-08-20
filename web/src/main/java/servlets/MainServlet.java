package servlets;

import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import data.DataProvider;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MainServlet.class);
    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DataProvider dataProvider;

    @Inject
    private SingleWordDao singleWordDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Entered MAIN servlet.");

        LOG.info("Verification if the user has been logged");

        HttpSession session = req.getSession(true);
        Boolean isAuthorised = (Boolean) session.getAttribute("userName");
        if (isAuthorised == null || isAuthorised == false) {
            resp.sendRedirect("/index.jsp");
            LOG.error("User was not validated in Main servlet. User will be redirected to login page");
        }

        String userName = (String) session.getAttribute("userNameStr");

        List<String> users = singleWordDao.findAllUsers();
        if (!users.contains(userName)) {

            LOG.info("New user - creating list of words from file.");
            List<SingleWord> listOfWords = dataProvider.getListOfWords();
            for (SingleWord s : listOfWords) {
                s.setUserName(userName);
                singleWordDao.save(s);
            }
        }

        LOG.info("User already exists in the data base. Using existing words to keep progress");

        Template template = templateProvider.getTemplate(getServletContext(), "choose-mode.ftlh");

        Map<String, Object> model = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");

        try {
            template.process(model, resp.getWriter());
            LOG.info("fthl template was loaded sussessfully");
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.error("ftlh template could not be loaded");
        }
    }
}

