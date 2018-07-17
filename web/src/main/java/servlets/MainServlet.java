package servlets;

import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import data.DataProvider;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private DataProvider dataProvider;

    @Inject
    private SingleWordDao singleWordDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            List<SingleWord> listOfWords = dataProvider.getListofWords();
            listOfWords.stream().forEach(o-> singleWordDao.save(o));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "choose-mode.ftlh");

        Map<String, Object> model = new HashMap<>();

        resp.setContentType("text/html;charset=UTF-8");
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
