package servlets;

import data.FileNotFound;
import data.FileUploadProcessor;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/management")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private FileUploadProcessor fileUploadProcessor;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "upload-file.ftlh");

        Map<String, Object> model = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("dataFile");

        try {
            File file = fileUploadProcessor.uploadFile(filePart);
            file.getName();

        } catch (FileNotFound fileNotFound) {
            fileNotFound.printStackTrace();
        }

        Template template = templateProvider.getTemplate(getServletContext(), "choose-mode.ftlh");

        Map<String, Object> model = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }



    }
}
