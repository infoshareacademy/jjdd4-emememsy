package servlets;

import com.infoshareacademy.emememsy.SingleWord;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/choose-category")
public class ChooseCategoryServlet extends HttpServlet {
    static Logger logger = LoggerFactory.getLogger(ChooseCategoryServlet.class);
    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DataProvider dataProvider;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mode = req.getParameter("mode");

        if (mode == null || mode.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            logger.error("The mode was upload uncorectly");

            return;
        }
        Template template = templateProvider.getTemplate(getServletContext(), "choose-category.ftlh");
        logger.info("The correct template was load");


        List<SingleWord> tempList = dataProvider.getListofWords();
        //tempList = InputOutput.createListOfWordsOmmitProperties();
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
        logger.debug("The file was load corectly");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.error("Problems with template", e.getMessage());

        }
    }
}






