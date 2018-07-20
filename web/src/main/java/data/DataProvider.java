package data;

import com.infoshareacademy.emememsy.SingleWord;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DataProvider {
    static Logger logger = LoggerFactory.getLogger(DataProvider.class);
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

    public List<SingleWord> getListofWords() throws MalformedURLException {
        String filePath = servletContext.getResource("/WEB-INF/input_words.csv").getPath();

        List<SingleWord> listOfWords = new ArrayList<>();
        boolean isUppercase = true;
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            CsvToBean<SingleWord> csvToBean = new CsvToBean<>();
            listOfWords.addAll(csvToBean.parse(strategy, reader));
            if (isUppercase == true) {
                listOfWords.stream().forEach(SingleWord::toUpperCase);
            } else {
                listOfWords.stream().forEach(SingleWord::toLowerCase);
            }
        } catch (IOException | NumberFormatException e) {
            logger.info("The file has not been read correctl");

            System.out.println("Wystąpił problem z wczytaniem pliku CSV. Skontaktuj się z administratorem Emememsów. ");
        }
        return listOfWords;
    }

    public void writeToFile(List<SingleWord> listOfWords) throws MalformedURLException {
        String filePath = servletContext.getResource("/WEB-INF/input_words.csv").getPath();
        try {
            Writer writer = new FileWriter(filePath);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(listOfWords);
            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            logger.warn("Changes have not been saved");
            System.out.println("Wystąpił problem z zapisaniem zmian. Skontaktuj się z administratorem.");
        }
    }
}
