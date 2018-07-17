package servlets;

        import com.infoshareacademy.emememsy.*;
        import com.infoshareacademy.emememsy.SingleWord;
        import dao.SingleWordDao;
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
        import java.util.*;

@WebServlet("/learn-mode")
public class LearnModeServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private ActionsWeb actionsWeb;
    @Inject
    private SingleWordDao singleWordDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String category = req.getParameter("category");
        String mode = req.getParameter("mode");

        if ((category == null || category.isEmpty()) && (mode == null || mode.isEmpty())) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        SingleWord singleWord = selectWord(req, resp);

        Template template = templateProvider.getTemplate(getServletContext(), "learn-mode.ftlh");

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

    private SingleWord selectWord (HttpServletRequest req, HttpServletResponse resp){
        String category = req.getParameter("category");
        String counter = req.getParameter("counter");
        String word = req.getParameter("word");
        SingleWord singleWord = new SingleWord();
        List<SingleWord> listOfWords = singleWordDao.findAll();

        if (counter == null || counter.equalsIgnoreCase("bad")){
            singleWord = actionsWeb.pickRandomLearnMode(listOfWords, category);
            return singleWord;
        } else if (counter.equalsIgnoreCase("good")) {
            SingleWord wordToAssess = listOfWords.stream().filter(s_-> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setCounter(wordToAssess.getCounter()+3);
            singleWordDao.update(wordToAssess);
            singleWord = actionsWeb.pickRandomLearnMode(listOfWords, category);
            return singleWord;
        } else if (counter.equalsIgnoreCase("soso")) {
            SingleWord wordToAssess = listOfWords.stream().filter(s_-> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setCounter(wordToAssess.getCounter()+1);
            singleWordDao.update(wordToAssess);
            singleWord = actionsWeb.pickRandomLearnMode(listOfWords, category);
        }
        return singleWord;
    }
}






