package servlets;

import com.infoshareacademy.emememsy.InputOutput;
import com.infoshareacademy.emememsy.SingleWord;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "choose-mode.ftlh");

        List<SingleWord> tempList = new ArrayList<>();
        tempList = InputOutput.createListOfWords();
        InputOutput.writeToCSV(tempList);
        List<String> categories = tempList.stream()
                .map(o -> o.getCategory())
                .distinct()
                .collect(Collectors.toList());

        Map<String, Object> model = new HashMap<>();
        model.put("category", categories);

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
