package emememsy;

import au.com.bytecode.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.*;

public class InputOutput {

    static void checkReader() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_words.csv"));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2]);

        }
    }

    static Set<SingleWord> createSetOfWords() throws IOException {
       /* Set<SingleWord> set = new TreeSet<>(new Comparator<SingleWord>() {
            @Override
            public int compare(SingleWord o1, SingleWord o2) {
                return o1.getWord().compareTo(o2.getWord());
            }
        }); */
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_words.csv"));
        Set<SingleWord> setOfWords = new TreeSet<>();
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            SingleWord singleWord = new SingleWord((nextLine[0]), (nextLine[1]), Integer.parseInt(nextLine[2]));
            setOfWords.add(singleWord);
            //System.out.println(singleWord);
        }
        return setOfWords;
        //setOfWords.stream().forEach(System.out::println);
    }






    static List<SingleWord> createListOfWords() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_words.csv"));
        List<SingleWord> listOfWords = new ArrayList<>();
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            SingleWord singleWord = new SingleWord((nextLine[0]), (nextLine[1]), Integer.parseInt(nextLine[2]));
            listOfWords.add(singleWord);
            //System.out.println(singleWord);

        }
        return listOfWords;
    }

    // List<MyBean> beans comes from somewhere earlier in your code.
   static void writeToCSV (List<SingleWord> listOfWords) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = new FileWriter("src/main/resources/output_words.csv");
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
        beanToCsv.write(listOfWords);
        writer.close();
    }
}
