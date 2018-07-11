/*
package servlets;


import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersRepositoryDao;

    @Inject
    private MaxPulseBean maxPulseBean;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Integer id = Integer.parseInt(idParam);
        User userById = usersRepositoryDao.getUserById(id);

        Template template = templateProvider.getTemplate(getServletContext(), "find-user-by-id.ftlh");
        Map<String, Object> model = new HashMap<>();

        PrintWriter writer = resp.getWriter();

        if (userById != null) {
            model.put("user", userById);

            double pulse = 0D;

            if (userById.getGender().equals(Gender.MAN)) {
                pulse = maxPulseBean.getManMaxPulse(userById.getAge());
            } else if (userById.getGender().equals(Gender.WOMAN)) {
                pulse = maxPulseBean.getWomanPulse(userById.getAge());
            }

            if (pulse != 0D) {
                model.put("pulse", pulse);
            }
        }else {
            String errorMessage = "User not found";
            model.put("errorMessage", errorMessage);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}*/
