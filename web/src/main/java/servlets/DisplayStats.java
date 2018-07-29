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
import java.util.stream.Collectors;

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
        Map<Object, Object> map = new LinkedHashMap<>();
        for(SingleWord s: statsDisplayed){
            map.put(s.getWord(), s.getDisplayed());
        }

        List<SingleWord> difficultWords = singleWordDao.mostDifficult().stream().limit(10).collect(Collectors.toList());
        Map<Object, Object> titleBad = new HashMap<>();
        titleBad.put("Słowo", "Liczba negatywnych ocen");
        Map<Object, Object> mapBad = new LinkedHashMap<>();
        for(SingleWord s: difficultWords){
            mapBad.put(s.getWord(), s.getBad());
        }

        Long numberAllDisplayed = singleWordDao.numberAllDisplayed();

        Long numberBrowse = singleWordDao.totalNumberOfWordsBrowseMode();
        Long numberLearn = singleWordDao.totalNumberOfWordsLearnMode();
        Long numberRepeat = singleWordDao.totalNumberOfWordsRepeatMode();
        Long numberExcluded = singleWordDao.totalNumberOfPassedWords();


        Template template = templateProvider.getTemplate(getServletContext(), "stats-chart.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("title", title);
        model.put("map", map);
        model.put("titleBad", titleBad);
        model.put("mapBad", mapBad);
        model.put("numberAllDisplayed", numberAllDisplayed);
        model.put("numberBrowse", numberBrowse);
        model.put("numberLearn", numberLearn);
        model.put("numberRepeat", numberRepeat);
        model.put("numberExcluded", numberExcluded);


        resp.setContentType("text/html;charset=UTF-8");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
       }

    }


}
