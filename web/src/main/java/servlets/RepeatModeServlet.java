package servlets;

import com.infoshareacademy.emememsy.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/repeat-mode")
public class RepeatModeServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private DataProvider dataProvider;
    @Inject
    private ActionsWeb actionsWeb;
    @Inject
    private SingleWord singleWord;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String category = req.getParameter("category");
        String mode = req.getParameter("mode");
        String counter = req.getParameter("counter");
        String word = req.getParameter("word");

        List<SingleWord> listOfWords = dataProvider.getListofWords();

        if ((category == null || category.isEmpty()) && (mode == null || mode.isEmpty())) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (counter == null || counter.equalsIgnoreCase("remain")){
            singleWord = actionsWeb.pickRandomRepeatMode(listOfWords, category);
        } else if (counter.equalsIgnoreCase("remove")) {
            SingleWord wordToAssess = listOfWords.stream().filter(s_-> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setCounter(wordToAssess.getCounter()+100);
            dataProvider.writeToFile(listOfWords);
            singleWord = actionsWeb.pickRandomRepeatMode(listOfWords, category);
        }

        Template template = templateProvider.getTemplate(getServletContext(), "repeat-mode.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("category", category);
        model.put("singleWord", singleWord);
        model.put("mode", mode);

        resp.setContentType("text/html;charset=UTF-8");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}






