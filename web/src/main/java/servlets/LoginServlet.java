package servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
    @Inject
    private TemplateProvider templateProvider;


        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            LOG.info("Entered doPost method in Login Servlet");
        try {
            String idToken = req.getParameter("id_token");
            LOG.debug("id Token: " + idToken);
            String accessToken = req.getParameter("access_token");
            LOG.debug("Access Token: " + accessToken);
            String expiresIn = req.getParameter("expires_in");
            LOG.debug("Expires in: " + expiresIn);
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", true);
<<<<<<< HEAD
            session.setAttribute("userNameString", name);
            session.setAttribute("userEmail", email);
=======
            session.setAttribute("userNameStr", name);
            session.setAttribute("userEmail", email);
            LOG.info("Received and validated token from Google. Now redirect to main should happen.");

>>>>>>> ff07f7d9bf0e7cd7404afca8ada73428d58a7ea4
            resp.sendRedirect("/main");

            LOG.info("redirected to main from Login servlet");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        LOG.info("This logger checks what happenes after the whole token validation block is executed. ");

    }
}
