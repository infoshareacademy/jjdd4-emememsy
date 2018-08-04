package servlets;

import data.MailSenderBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mail-dispatcher")
public class MailDispatcherServlet extends HttpServlet {


    @EJB
    private MailSenderBean mailSender;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html; charset=UTF-8");

            String toEmail = request.getParameter("email");

            //data for connection - intentional hardcoding solution just for testing
            String fromEmail = "emememsy2018@gmail.com";
            String username = "emememsy2018";
            String password = "summer2018";

            //call to mail sender bean here

            mailSender.sendEmail(fromEmail, username, password, toEmail, );


            //---------------------

            response.sendRedirect("/mail-status");



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }


}
