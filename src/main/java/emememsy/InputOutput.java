package emememsy;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class InputOutput {

    static void checkReader() throws IOException {

    CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_words.csv"));
    String [] nextLine;
    while ((nextLine = reader.readNext()) != null) {
    // nextLine[] is an array of values from the line
    System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2]);

}
    }

    static void createSetOfWords () throws IOException {
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
            SingleWord singleWord = new SingleWord((nextLine[0]), (nextLine[1]),Integer.parseInt(nextLine[2]));
          setOfWords.add(singleWord);
            //System.out.println(singleWord);
            setOfWords.add(singleWord);
        }

        setOfWords.stream().forEach(System.out::println);

    }

}
