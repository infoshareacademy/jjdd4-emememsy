package data;

import com.sendgrid.*;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class EmailReport {

    public static void sendEmail(String[] args) throws IOException {

        Email from = new Email("emememsy2018@sendgrid.com");
        String subject = "Report from myWords";
        Email to = new Email("emememsy2018@gmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            //?  request.setBody(sendEmail().build);
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }


    }
}

//API Key
//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