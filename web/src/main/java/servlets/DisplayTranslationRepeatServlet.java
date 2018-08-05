package servlets;

import com.infoshareacademy.emememsy.Actions;
import com.infoshareacademy.emememsy.PropertiesReader;
import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import data.DataProvider;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/translation-repeat")
public class DisplayTranslationRepeatServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(DisplayTranslationRepeatServlet.class);
    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DataProvider dataProvider;

    @Inject
    private SingleWordDao singleWordDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Boolean isAuthorised = (Boolean)session.getAttribute("userName");
        if(isAuthorised == null|| isAuthorised == false) {
            resp.sendRedirect("/index.jsp");
        }

        String userName = (String)session.getAttribute("userNameStr");
        String mode = req.getParameter("mode");
        String category = req.getParameter("category");
        String word = req.getParameter("word");
        String translation = req.getParameter("translation");

        if (mode == null || mode.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            LOG.error("Problem with loading the correct module");

            return;
        }

        List<String> words =  singleWordDao.findAllWordsByUser(userName);
        List<String> translations = singleWordDao.findAllTranslationsByUser(userName);
        List<String> categories = singleWordDao.findAllCategoriesByUser(userName);

        if ((!words.contains(word)) || (!translations.contains(translation)) || (!categories.contains(category)) && (!category.equalsIgnoreCase("WSZYSTKIE"))){
            resp.sendRedirect("/error");
        }

        if (!mode.equals("repeat-mode")){
            resp.sendRedirect("/error");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "display-translation-repeat.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("mode", mode);
        model.put("category", category);
        model.put("word", word);
        model.put("translation", translation);

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
