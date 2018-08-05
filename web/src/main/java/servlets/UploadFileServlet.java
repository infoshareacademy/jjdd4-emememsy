package servlets;

import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import data.DataProvider;
import data.FileNotFound;
import data.FileUploadProcessor;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@WebServlet("/management")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(RepeatModeServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private FileUploadProcessor fileUploadProcessor;

    @Inject
    private SingleWordDao singleWordDao;

    @Inject
    private DataProvider dataProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Boolean isAuthorised = (Boolean)session.getAttribute("userName");
        if(isAuthorised == null|| isAuthorised == false) {
            resp.sendRedirect("/index.jsp");
        }

        String userName = (String)session.getAttribute("userNameStr");

        String action = req.getParameter("action");

        if("delete".equals(action)){
            deleteWords(req, resp, userName);
        } else if ("initialize".equals(action)){
            uploadWords(req, resp, userName);
        }

        Template template = templateProvider.getTemplate(getServletContext(), "upload-file.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("action", action);

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
            LOG.info("fthl template was loaded sussessfully");
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.error("ftlh template could not be loaded");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("dataFile");

        String userName = (String)req.getSession().getAttribute("userNameStr");

        try {
            File file = fileUploadProcessor.uploadFile(filePart, userName);
            file.getName();

        } catch (FileNotFound fileNotFound) {
            fileNotFound.printStackTrace();
        }

        Template template = templateProvider.getTemplate(getServletContext(), "upload-file-success.ftlh");

        Map<String, Object> model = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
            LOG.info("fthl template was loaded sussessfully");
        } catch (TemplateException e) {
            e.printStackTrace();
            LOG.error("ftlh template could not be loaded");
        }
    }

    private void deleteWords (HttpServletRequest req, HttpServletResponse resp, String userName) {

        List<SingleWord> listOfWords = singleWordDao.findAllByUser(userName);
        listOfWords.stream().forEach(o-> singleWordDao.deleteWord(o));
    }

    private void uploadWords (HttpServletRequest req, HttpServletResponse resp, String userName) {

        try {
            List<SingleWord> listOfWords = dataProvider.getListOfWords();
            for (SingleWord s : listOfWords) {
                s.setUserName(userName);
                singleWordDao.save(s);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
