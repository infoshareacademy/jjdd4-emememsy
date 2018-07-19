package com.infoshareacademy.emememsy;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InputOutputTest {

    @Test
    public void createListOfWords() {
        //GIVEN
        boolean isUpercase = true;
        try {
            String configFilePath = new File("").getAbsolutePath() + "/src/test/config-test2.properties";

            Map<String, String> properties = PropertiesReader.read(configFilePath);
            CSVReader reader = new CSVReader(new FileReader(properties.get("path")));

            String CSVFilePath = new File("").getAbsolutePath() + "/src/test/input-words-test2.csv";
            //CSVReader reader = new CSVReader(new FileReader(CSVFilePath));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<SingleWord> singleWordList = new ArrayList<>();
        singleWordList.add(new SingleWord("WORD1", "TRANS1","CAT1",0));
        singleWordList.add(new SingleWord("WORD2", "TRANS2","CAT2",0));

//        when(properties.get()).thenReturn("")

        //WHEN
        List<SingleWord> result = InputOutput.createListOfWords();


        //THEN
        assertEquals(singleWordList, result);

    }

    @Test
    public void writeToCSV() {
    }
}