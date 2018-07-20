package com.infoshareacademy.emememsy;

import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class InputOutputTest {

    @Test
    public void ifCreatedListOfObjFromCSVAccordingToPropertiesConfig() {
        //GIVEN
        String configFilePath = new File("").getAbsolutePath() + "/src/test/config-test2.properties";
        InputOutput.properties = PropertiesReader.read(configFilePath);

        List<SingleWord> expected = new ArrayList<>();
        expected.add(new SingleWord("WORD1", "TRANS1", "CAT1", 0));
        expected.add(new SingleWord("WORD2", "TRANS2", "CAT2", 0));

        //WHEN
        List<SingleWord> result = InputOutput.createListOfWords();

        //THEN
        assertEquals(result, expected);

    }
}