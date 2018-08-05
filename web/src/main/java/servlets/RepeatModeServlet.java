package servlets;

import com.infoshareacademy.emememsy.*;
import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
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
import java.net.URLDecoder;
import java.util.*;

@WebServlet("/repeat-mode")
public class RepeatModeServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(RepeatModeServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private ActionsWeb actionsWeb;
    @Inject
    private SingleWordDao singleWordDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Boolean isAuthorised = (Boolean)session.getAttribute("userName");
        if(isAuthorised == null|| isAuthorised == false) {
            resp.sendRedirect("/index.jsp");
        }

        String userName = (String)session.getAttribute("userNameStr");

        String category = URLDecoder.decode(req.getParameter("category"), "UTF-8");
        String mode = req.getParameter("mode");

        if ((category == null || category.isEmpty()) && (mode == null || mode.isEmpty())) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            LOG.error("The mode was upload uncorectly");
            return;
        }

        List<String> categories = singleWordDao.findAllCategoriesByUser(userName);
        if ((!categories.contains(category)) && (!category.equalsIgnoreCase("WSZYSTKIE"))){
            resp.sendRedirect("/error");
        }

        if (!mode.equals("repeat-mode")){
            resp.sendRedirect("/error");
        }

        SingleWord singleWord = selectWord(req, resp, userName);

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
            LOG.error("Problems with template");

        }
    }

    private SingleWord selectWord (HttpServletRequest req, HttpServletResponse resp, String userName) {

        SingleWord singleWord = new SingleWord();
        Random randomGenerator = new Random();
        List<SingleWord> listOfWords = new ArrayList<>();

        if (req.getParameter("category").equalsIgnoreCase("wszystkie")) {
            listOfWords = singleWordDao.findByAllCategoriesRepeatModeByUser(userName);
        } else {
            listOfWords = singleWordDao.findByCategoryRepeatModeByUser(req.getParameter("category"), userName);
        }


        if (listOfWords.isEmpty()) {
            return null;
        } else {
            int random = randomGenerator.nextInt(listOfWords.size());
            singleWord = listOfWords.get(random);
            singleWord.setDisplayed(singleWord.getDisplayed() + 1);
            singleWordDao.update(singleWord);
            return singleWord;
        }
    }
}






