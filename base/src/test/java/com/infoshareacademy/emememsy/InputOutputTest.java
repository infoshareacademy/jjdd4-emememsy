package com.infoshareacademy.emememsy;

import com.opencsv.CSVReader;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InputOutputTest {

    @Test
    public void createListOfWords() {
        //GIVEN
        boolean isUppercase = true;
        try {

            String CSVfilePath = new File("").getAbsolutePath() + "/src/test/input-words-test.csv";
            CSVReader reader = new CSVReader(new FileReader(CSVfilePath));
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
        assertTrue(singleWordList.equals(result));

    }

    @Test
    public void writeToCSV() {
    }
}