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
import java.util.stream.Collectors;

@WebServlet("/choose-category")
public class ChooseCategoryServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ChooseCategoryServlet.class);
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


        String mode = req.getParameter("mode");

        if (mode == null || mode.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            LOG.error("The mode was upload uncorectly");

            return;
        }

        if ((!mode.equals("browse-mode")) && (!mode.equals("learn-mode")) && (!mode.equals("repeat-mode"))){
            resp.sendRedirect("/error");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "choose-category.ftlh");
        LOG.info("The correct template was load");


        List<SingleWord> tempList = singleWordDao.findAll();
        List<String> categories = tempList.stream()
                .map(o -> o.getCategory().toUpperCase())
                .distinct()
                .collect(Collectors.toList());
        String size = String.valueOf(categories.size());


        Map<String, Object> model = new HashMap<>();
        model.put("mode", mode);
        model.put("categories", categories);
        model.put("size", size);

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






