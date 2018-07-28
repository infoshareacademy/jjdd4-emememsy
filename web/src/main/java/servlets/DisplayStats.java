package servlets;

import com.infoshareacademy.emememsy.SingleWord;
import dao.SingleWordDao;
import data.DataProvider;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/progress")
public class DisplayStats extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private SingleWordDao singleWordDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<SingleWord> statsDisplayed = singleWordDao.allDisplayed();

        Map<Object, Object> title = new HashMap<>();
        title.put("Słowo", "Liczba wyświetleń");
        Map<Object, Object> map = new HashMap<>();
        //map.put("Słowo", "Liczba wyświetleń");
        for(SingleWord s: statsDisplayed){
            map.put(s.getWord(), s.getDisplayed());
        }


        /*
        String output = "['Słowo', 'Liczba wyświetleń',]";
        StringBuilder sb = new StringBuilder(output);

        for(SingleWord s: statsDisplayed){
            if (sb.length() > 1) sb.append( "," );
            sb.append("['" + s.getWord() + "', " + s.getDisplayed() + "]");
        }
        output = sb.toString();
        */


        Template template = templateProvider.getTemplate(getServletContext(), "stats-chart.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("title", title);
        model.put("map", map);


        resp.setContentType("text/html;charset=UTF-8");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
       }

    }


}
