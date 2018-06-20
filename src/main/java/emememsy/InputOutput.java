package emememsy;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class InputOutput {

    static void checkReader() throws IOException {

    CSVReader reader = new CSVReader(new FileReader("src/main/resources/input_words.csv"));
    String [] nextLine;
    while ((nextLine = reader.readNext()) != null) {
    // nextLine[] is an array of values from the line
    System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2]);

}
    }
}
