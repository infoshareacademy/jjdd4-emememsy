package servlets;

import com.infoshareacademy.emememsy.*;
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
import java.io.IOException;
import java.util.*;

@WebServlet("/browse-mode")
public class BrowseModeServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(BrowseModeServlet.class);
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
            LOG.error("Problem with loading the correct module");
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "browse-mode.ftlh");

        SingleWord singleWord = selectWord(req, resp);

        Map<String, Object> model = new HashMap<>();
        model.put("category", category);
        model.put("singleWord", singleWord);
        model.put("mode", mode);

        resp.setContentType("text/html;charset=UTF-8");
        LOG.info("The file was load corectly");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.error("Problems with template", e.getMessage());
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






