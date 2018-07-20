package servlets;

import ch.qos.logback.classic.Logger;
import com.infoshareacademy.emememsy.ActionsWeb;
import com.infoshareacademy.emememsy.InputOutput;
import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.LoggerFactory;

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

@WebServlet("/test")
public class Test extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private SingleWordDao singleWordDao;
    @Inject
    private ActionsWeb actionsWeb;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        selectWord(req, resp);

    }

    private void selectWord (HttpServletRequest req, HttpServletResponse resp){
        List<SingleWord> listOfWords = singleWordDao.findAll();
        SingleWord singleWord = actionsWeb.pickRandomBrowserMode(listOfWords, req.getParameter("category"));
        try {
            resp.getWriter().write(singleWord.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
