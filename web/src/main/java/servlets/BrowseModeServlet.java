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
import javax.servlet.http.HttpSession;
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

        HttpSession session = req.getSession(true);
        Boolean isAuthorised = (Boolean)session.getAttribute("userName");
        if(isAuthorised == null|| isAuthorised == false) {
            resp.sendRedirect("/index.jsp");
        }

        String userName = (String)session.getAttribute("userNameStr");

        String category = req.getParameter("category");
        String mode = req.getParameter("mode");

        if (category == null || category.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            LOG.error("Problem with loading the correct module");
            return;
        }

        List<String> categories = singleWordDao.findAllCategoriesByUser(userName);
        if ((!categories.contains(category)) && (!category.equalsIgnoreCase("WSZYSTKIE"))){
            resp.sendRedirect("/error");
        }

        if (!mode.equals("browse-mode")){
            resp.sendRedirect("/error");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "browse-mode.ftlh");

        SingleWord singleWord = selectWord(req, resp, userName);

        Map<String, Object> model = new HashMap<>();
        model.put("category", category);
        model.put("singleWord", singleWord);
        model.put("mode", mode);

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
            LOG.info("fthl template was loaded sussessfully");
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.error("ftlh template could not be loaded");
        }
    }

    private SingleWord selectWord (HttpServletRequest req, HttpServletResponse resp, String userName){

        List<SingleWord> listOfWords = new ArrayList<>();

        if (req.getParameter("category").equalsIgnoreCase("wszystkie")) {
            listOfWords =  singleWordDao.findByAllCategoriesBrowseModeByUser(userName);
        } else {
            listOfWords = singleWordDao.findByCategoryBrowseModeByUser(req.getParameter("category"), userName);
        }

        if(listOfWords.isEmpty()){
            return null;
        } else {
            Random randomGenerator = new Random();
            int random = randomGenerator.nextInt(listOfWords.size());
            SingleWord singleWord = listOfWords.get(random);
            singleWord.setCounter(singleWord.getCounter() + 1);
            singleWord.setDisplayed(singleWord.getDisplayed() + 1);
            singleWordDao.update(singleWord);
            return singleWord;
        }
    }
}






