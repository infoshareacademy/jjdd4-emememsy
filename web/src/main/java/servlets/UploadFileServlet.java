package servlets;

import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import data.DataProvider;
import data.FileNotFound;
import data.FileUploadProcessor;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Transactional
@WebServlet("/management")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UploadFileServlet.class);

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

        String action = req.getParameter("action");

        if("delete".equals(action)){
            deleteWords(req, resp);
        } else if ("initialize".equals(action)){
            uploadWords(req, resp);
        }

        Template template = templateProvider.getTemplate(getServletContext(), "upload-file.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("action", action);

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            loadFile(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Blad ladowania", e);
        }
    }

    private void loadFile(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part filePart = req.getPart("dataFile");

        try {
            File file = fileUploadProcessor.uploadFile(filePart);
            file.getName();

        } catch (FileNotFound fileNotFound) {
            fileNotFound.printStackTrace();
        }

        Template template = templateProvider.getTemplate(getServletContext(), "upload-file-success.ftlh");

        Map<String, Object> model = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    private void deleteWords (HttpServletRequest req, HttpServletResponse resp) {

        List<SingleWord> listOfWords = singleWordDao.findAll();
        listOfWords.stream().forEach(o-> singleWordDao.deleteWord(o));
    }

    private void uploadWords (HttpServletRequest req, HttpServletResponse resp) {

        try {
            List<SingleWord> listOfWords = dataProvider.getListOfWords();
            listOfWords.stream().forEach(o-> singleWordDao.save(o));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
