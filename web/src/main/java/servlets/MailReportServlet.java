package servlets;

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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/mail-report")
public class MailReportServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private SingleWordDao singleWordDao;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Boolean isAuthorised = (Boolean)session.getAttribute("userName");
        if(isAuthorised == null|| isAuthorised == false) {
            resp.sendRedirect("/index.jsp");
        }
        String userEmail = (String) session.getAttribute("userEmail");

        Long numberAllDisplayed = singleWordDao.numberAllDisplayed();
        Long numberBrowse = singleWordDao.totalNumberOfWordsBrowseMode();
        Long numberLearn = singleWordDao.totalNumberOfWordsLearnMode();
        Long numberRepeat = singleWordDao.totalNumberOfWordsRepeatMode();
        Long numberExcluded = singleWordDao.totalNumberOfPassedWords();

        Template template = templateProvider.getTemplate(getServletContext(), "mail-report.ftlh");

        Map<String, Object> model = new HashMap<>();

        model.put("numberAllDisplayed", numberAllDisplayed);
        model.put("numberBrowse", numberBrowse);
        model.put("numberLearn", numberLearn);
        model.put("numberRepeat", numberRepeat);
        model.put("numberExcluded", numberExcluded);

        model.put("userEmail", userEmail);

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
