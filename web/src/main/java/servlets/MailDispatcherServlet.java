package servlets;

import data.MailSenderBean;
import freemarker.TemplateProvider;
import freemarker.template.Template;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mail-dispatcher")
public class MailDispatcherServlet extends HttpServlet {




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
            String subject = "Raport z aplikacji myWords";
            String message = "To jest raport wygenerowany z aplikacji myWord...";


            //data for connection - intentional hardcoding solution just for testing
            String fromEmail = "emememsy2018@gmail.com";
            String username = "emememsy2018";
            String password = "summer2018";

            //call to mail sender bean inside this block-----

            mailSender.sendEmail(fromEmail, username, password, toEmail, subject, message);

            //-----------------------------------------------

            resp.sendRedirect("/mail-status");



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



}
