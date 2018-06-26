package com.infoshareacademy.emememsy;

import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class InputOutput {

    public static Map<String, String> properties = PropertiesReader.read("config.properties");

    public static void checkReader() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(PropertiesReader.read("config.properties").get(PropertiesReader.PATH_KEY)));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2]);
        }
    }

    private static boolean isUppercase (Map<String, String> properties) {
        return properties.get(PropertiesReader.FORMATTING_KEY).equals("toUpperCase");
    }

    public static List<SingleWord> createListOfWords() throws IOException {

        List<SingleWord> listOfWords = new ArrayList<>();
        boolean isUppercase = isUppercase(properties);
        CSVReader reader = new CSVReader(new FileReader(properties.get(PropertiesReader.PATH_KEY)));
        String[] nextLine;
        nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            if (isUppercase == true) {
                SingleWord singleWord = new SingleWord(nextLine[2].toUpperCase(), nextLine[1].toUpperCase(), Integer.parseInt(nextLine[0]));
                listOfWords.add(singleWord);
            } else {
                SingleWord singleWord = new SingleWord(nextLine[2].toLowerCase(), nextLine[1].toLowerCase(), Integer.parseInt(nextLine[0]));
                listOfWords.add(singleWord);
            }
        }
        return listOfWords;
    }


    public static void writeToCSV(List<SingleWord> listOfWords) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = new FileWriter(PropertiesReader.read("config.properties").get(PropertiesReader.PATH_KEY));
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
        beanToCsv.write(listOfWords);
        writer.close();
    }
}
