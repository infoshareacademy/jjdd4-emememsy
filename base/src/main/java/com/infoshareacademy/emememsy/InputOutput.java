package com.infoshareacademy.emememsy;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import javax.enterprise.context.RequestScoped;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestScoped
public class InputOutput {

    public static Map<String, String> properties = PropertiesReader.read("config.properties");

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


    public static void checkReader() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(PropertiesReader.read("config.properties").get(PropertiesReader.PATH_KEY)));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2] + " " + nextLine[3]);
        }
    }

    private static boolean isUppercase(Map<String, String> properties) {
        return properties.get(PropertiesReader.FORMATTING_KEY).equals("toUpperCase");
    }

    public static List<SingleWord> createListOfWordsOmmitProperties(){
        List<SingleWord> listOfWords = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader("input_words.csv"));
            CsvToBean<SingleWord> csvToBean = new CsvToBean<>();
            listOfWords.addAll(csvToBean.parse(strategy, reader));

        } catch (IOException | NumberFormatException e) {
            System.out.println("Wystąpił problem z wczytaniem pliku CSV. Skontaktuj się z administratorem Emememsów. ");
        }
        return listOfWords;
    }

    public static List<SingleWord> createListOfWords() {

        List<SingleWord> listOfWords = new ArrayList<>();
        boolean isUppercase = isUppercase(properties);
        try {
            CSVReader reader = new CSVReader(new FileReader(properties.get(PropertiesReader.PATH_KEY)));
            CsvToBean<SingleWord> csvToBean = new CsvToBean<>();
            listOfWords.addAll(csvToBean.parse(strategy, reader));
            if (isUppercase == true) {
                listOfWords.stream().forEach(SingleWord::toUpperCase);
            } else {
                listOfWords.stream().forEach(SingleWord::toLowerCase);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Wystąpił problem z wczytaniem pliku CSV. Skontaktuj się z administratorem Emememsów. ");
        }
        return listOfWords;
    }

    public static void writeToCSV(List<SingleWord> listOfWords) {
        try {
            Writer writer = new FileWriter(PropertiesReader.read("config.properties").get(PropertiesReader.PATH_KEY));
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(listOfWords);
            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("Wystąpił problem z zapisaniem zmian. Skontaktuj się z administratorem.");
        }
    }
}
