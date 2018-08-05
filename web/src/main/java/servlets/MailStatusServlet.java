package servlets;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/mail-status")
public class MailStatusServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(DisplayTranslation.class);

    @Inject
    private TemplateProvider templateProvider;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "mail-status.ftlh");

        //no model data map so only like that...
        Map<String, Object> model = new HashMap<>();
        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
            LOG.info("fthl template loaded sussessfully");
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.error("ftlh template could not be loaded");
        }

    }
}
