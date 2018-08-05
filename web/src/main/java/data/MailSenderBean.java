package data;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlets.ChooseCategoryServlet;

import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SessionScoped
@Stateless
public class MailSenderBean {

    private static final Logger LOG = LoggerFactory.getLogger(ChooseCategoryServlet.class);

    public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String message) {

        try {
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

            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessage.setContent(message, "text/html");
            mailMessage.setSubject(subject);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);

            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Could not connect to SMTP server");
        }

    }

}