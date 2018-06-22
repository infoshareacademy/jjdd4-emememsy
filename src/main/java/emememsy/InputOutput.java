package emememsy;

import au.com.bytecode.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.*;

import static au.com.bytecode.opencsv.CSVReader.*;

public class InputOutput {

    static void checkReader() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_words.csv"));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2]);

        }
    }


    static List<SingleWord> createListOfWords() throws IOException {
        List<SingleWord> listOfWords = new ArrayList<>();
        //CSVReader reader = new CSVReader(new FileReader("input_words.csv", DEFAULT_SEPARATOR, DEFAULT_QUOTE_CHARACTER, 1));
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_words.csv"));
        String[] nextLine;
        nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            SingleWord singleWord = new SingleWord((nextLine[2]), (nextLine[1]), Integer.parseInt(nextLine[0]));
            listOfWords.add(singleWord);
            //System.out.println(singleWord);
        }
        return listOfWords;
    }


   static void writeToCSV (List<SingleWord> listOfWords) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = new FileWriter("src/main/resources/input_words.csv");
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
        beanToCsv.write(listOfWords);
        writer.close();
    }


}
