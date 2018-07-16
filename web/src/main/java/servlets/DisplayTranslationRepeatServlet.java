package servlets;

import com.infoshareacademy.emememsy.Actions;
import com.infoshareacademy.emememsy.PropertiesReader;
import com.infoshareacademy.emememsy.SingleWord;
import data.DataProvider;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/translation-repeat")
public class DisplayTranslationRepeatServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DataProvider dataProvider;

    private Actions actions;
    private PropertiesReader propertiesReader;
    private SingleWord singleWord;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mode = req.getParameter("mode");
        String category = req.getParameter("category");
        String word = req.getParameter("word");
        String translation = req.getParameter("translation");

        if (mode == null || mode.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
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
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
