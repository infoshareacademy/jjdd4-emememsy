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

@WebServlet("/browse-mode")
public class BrowseModeServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private SingleWordDao singleWordDao;
    @Inject
    private ActionsWeb actionsWeb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String category = req.getParameter("category");
        String mode = req.getParameter("mode");

        if (category == null || category.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "browse-mode.ftlh");

        SingleWord singleWord = selectWord(req, resp);

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

        List<SingleWord> listOfWords = new ArrayList<>();

        if (req.getParameter("category").equalsIgnoreCase("wszystkie")) {
            listOfWords =  singleWordDao.findByAllCategoriesBrowseMode();
        } else {
            listOfWords = singleWordDao.findByCategoryBrowseMode(req.getParameter("category"));
        }

        if(listOfWords.isEmpty()){
            return null;
        } else {
            Random randomGenerator = new Random();
            int random = randomGenerator.nextInt(listOfWords.size());
            SingleWord singleWord = listOfWords.get(random);
            singleWord.setCounter(singleWord.getCounter() + 1);
            singleWordDao.update(singleWord);
            return singleWord;
        }
    }
}






