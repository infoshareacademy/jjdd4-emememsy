package servlets;

import com.infoshareacademy.emememsy.ActionsWeb;
import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/counter")
public class IncreaseCounterServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
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

        String category = req.getParameter("category");
        String mode = req.getParameter("mode");
        String counter = req.getParameter("counter");
        String word = req.getParameter("word");


        if ((category == null || category.isEmpty()) && (mode == null || mode.isEmpty())) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        increaseCounter(req, resp, userName);

        Template template = templateProvider.getTemplate(getServletContext(), "learn-mode.ftlh");
        if (counter.equals("good") || counter.equals("soso") || counter.equals("bad")) {

            resp.sendRedirect("./learn-mode?category=" + URLEncoder.encode(category, "UTF-8") + "&mode=" + mode);

        } else if (counter.equals("remove") || counter.equals("remain")) {

            resp.sendRedirect("./repeat-mode?category=" + URLEncoder.encode(category, "UTF-8") + "&mode=" + mode);
        }
    }

    private void increaseCounter (HttpServletRequest req, HttpServletResponse resp, String userName){

        String counter = req.getParameter("counter");
        String word = req.getParameter("word");

        List<SingleWord> listOfWords = new ArrayList<>();
        listOfWords = singleWordDao.findAllByUser(userName);

        if(counter.equals("good")){
            SingleWord wordToAssess = listOfWords.stream().filter(s_ -> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setCounter(wordToAssess.getCounter()+3);
            wordToAssess.setGood(wordToAssess.getGood()+1);
            singleWordDao.update(wordToAssess);
        } else if (counter.equals("soso")){
            SingleWord wordToAssess = listOfWords.stream().filter(s_ -> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setCounter(wordToAssess.getCounter()+1);
            wordToAssess.setSoso(wordToAssess.getSoso()+1);
            singleWordDao.update(wordToAssess);
        } else if(counter.equals("remove")){
            SingleWord wordToAssess = listOfWords.stream().filter(s_ -> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setCounter(wordToAssess.getCounter()+100);
            wordToAssess.setRemove(wordToAssess.getRemove()+1);
            singleWordDao.update(wordToAssess);
        } else if(counter.equals("remain")){
            SingleWord wordToAssess = listOfWords.stream().filter(s_ -> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setRemain(wordToAssess.getRemain()+1);
            singleWordDao.update(wordToAssess);
        } else if(counter.equals("bad")){
            SingleWord wordToAssess = listOfWords.stream().filter(s_ -> s_.getWord().equalsIgnoreCase(word)).findFirst().orElse(null);
            wordToAssess.setBad(wordToAssess.getBad()+1);
            singleWordDao.update(wordToAssess);
        }
    }

}

