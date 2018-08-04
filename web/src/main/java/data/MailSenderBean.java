package data;


import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SessionScoped
@Stateless
public class MailSenderBean {

    public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String message) {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.fallback", "false");

        Session mailSession = Session.getDefaultInstance(properties, null);
        mailSession.setDebug(true);

        Message mailMessage = new MimeMessage(mailSession);

    }

}