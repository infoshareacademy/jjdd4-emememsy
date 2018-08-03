package servlets;

import com.infoshareacademy.emememsy.SingleWord;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/error")
public class ErrorHandlerServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(BrowseModeServlet.class);
    @Inject
    private TemplateProvider templateProvider;
//    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request,
                              HttpServletResponse response) throws IOException, ServletException {
//        customize error message
        LOG.error("ERROR1");
        Throwable throwable = (Throwable) request
                .getAttribute("javax.servlet.error.exception");
        LOG.error("Throable", throwable);
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        LOG.error("Throable1", statusCode);
        String servletName = (String) request
                .getAttribute("javax.servlet.error.servlet_name");
        LOG.error("Throable2", servletName);
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request
                .getAttribute("javax.servlet.error.request_uri");
        LOG.error("Throable3", requestUri);
//        if (requestUri == null) {
//            requestUri = "Unknown";
//          request.getRequestDispatcher("error-page.ftlh").forward(request, response);
            Template template = templateProvider.getTemplate(getServletContext(), "error-page.ftlh");
            LOG.error("Agter get template");

//            SingleWord singleWord = selectWord(req, resp);

            Map<String, Object> model = new HashMap<>();

            model.put("statusCode", statusCode);
            model.put("servletName", servletName);
//          model.put("exception", exception);

//            resp.setContentType("text/html;charset=UTF-8");
//            LOG.info("The file was load corectly");
//            request.setAttribute("error", "Servlet " + servletName +
//                    " has thrown an exception " + throwable.getClass().getName() +
//                    " : " + throwable.getMessage());
            try {
                LOG.error("Before processing ");
                template.process(model, response.getWriter());
                LOG.error("Finished processing ");
            } catch (TemplateException e) {
                LOG.error("Problems with template Before", e);
             request.getRequestDispatcher("error-page.ftlh").forward(request, response);
                e.printStackTrace();
                LOG.error("Problems with template", e);
            }
        }

             }
//        request.setAttribute("error", "Servlet " + servletName +
//                " has thrown an exception " + throwable.getClass().getName() +
//                " : " + throwable.getMessage());
//
//            response.sendRedirect("errorpage");
//         request.getRequestDispatcher("error-page.ftlh").forward(request, response);


