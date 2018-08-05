package servlets;

import com.infoshareacademy.emememsy.PropertiesReader;
import data.MailSenderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


@WebServlet("/mail-dispatcher")
public class MailDispatcherServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(DisplayTranslation.class);

    @EJB
    private MailSenderBean mailSender;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Boolean isAuthorised = (Boolean)session.getAttribute("userName");
        if(isAuthorised == null|| isAuthorised == false) {
            resp.sendRedirect("/index.jsp");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.setContentType("text/html; charset=UTF-8");

            String toEmail = req.getParameter("email");
            String message = req.getParameter("message");

            Map<String, String> properties = PropertiesReader.read("/tmp/config.properties");

            String subject = properties.get(PropertiesReader.SUBJECT_KEY);
            String fromEmail = properties.get(PropertiesReader.FROMEMAIL_KEY);
            String username = properties.get(PropertiesReader.USERNAME_KEY);
            String password = properties.get(PropertiesReader.PASSWORD_KEY);

            //call to mail sender bean inside this block-----

            mailSender.sendEmail(fromEmail, username, password, toEmail, subject, message);
            LOG.info("send mail thread successfull");

            //-----------------------------------------------

            resp.sendRedirect("/mail-status");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
