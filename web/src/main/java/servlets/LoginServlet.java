package servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            LOG.info("id Token: " + idToken);
            String accessToken = req.getParameter("access_token");
            LOG.info("Access Token: " + accessToken);
            String expiresIn = req.getParameter("expires_in");
            LOG.info("Expires in: " + expiresIn);
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", true);
            resp.sendRedirect("/main");

             } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
