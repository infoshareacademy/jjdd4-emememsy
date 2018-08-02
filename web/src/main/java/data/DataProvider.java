package data;

import com.infoshareacademy.emememsy.SingleWord;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class DataProvider {
    private static final  Logger LOG = LoggerFactory.getLogger(DataProvider.class);
    private static HeaderColumnNameTranslateMappingStrategy<SingleWord> strategy;
    private static Map<String, String> columnMapping = new HashMap<>();

    static {
        columnMapping.put("WORD", "word");
        columnMapping.put("TRANSLATION", "translation");
        columnMapping.put("CATEGORY", "category");
        columnMapping.put("COUNTER", "counter");

        strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(SingleWord.class);
        strategy.setColumnMapping(columnMapping);
    }

    @Inject
    private ServletContext servletContext;



    public List<SingleWord> getListOfWords() throws MalformedURLException {
        return getListOfWords(servletContext.getResource("/WEB-INF/input_words.csv").getPath());

    }

    public List<SingleWord> getListOfWords(String filePath) {
        List<SingleWord> result = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            CsvToBean<SingleWord> csvToBean = new CsvToBean<>();
            List<SingleWord> lines = csvToBean.parse(strategy, reader);
            if (lines.stream().anyMatch(s -> !s.isValid())) {
                throw new IllegalArgumentException("Bledny plik CSV");
            }
            result.addAll(lines);
            processListOfWords(result);
        } catch (IOException | NumberFormatException e) {
           LOG.error("The file has not been read correctly");

            System.out.println("Wystąpił problem z wczytaniem pliku CSV. Skontaktuj się z administratorem Emememsów. ");
        }
        return result;
    }

    private void processListOfWords(List<SingleWord> wordsList) {
        boolean isUppercase = readUppercaseProperty();

        if (isUppercase == true) {
            wordsList.stream().forEach(SingleWord::toUpperCase);
        } else {
            wordsList.stream().forEach(SingleWord::toLowerCase);
        }
    }

    private boolean readUppercaseProperty() {
        // TODO: implement proper property reading
        return true;
    }





    public void writeToFile(List<SingleWord> listOfWords) throws MalformedURLException {
        String filePath = servletContext.getResource("/WEB-INF/input_words.csv").getPath();
        try {
            Writer writer = new FileWriter(filePath);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(listOfWords);
            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            LOG.warn("Changes have not been saved");
            System.out.println("Wystąpił problem z zapisaniem zmian. Skontaktuj się z administratorem.");
        }
    }
}
