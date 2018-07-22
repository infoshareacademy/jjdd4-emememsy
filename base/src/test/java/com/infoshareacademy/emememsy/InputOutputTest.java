package com.infoshareacademy.emememsy;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class InputOutputTest {

    @Test
    public void ifCreatedListOfObjFromCSVAccordingToPropertiesConfig() {
        //GIVEN
        InputOutput.properties = PropertiesReader.read("../base//src/test/config-test2.properties");

        List<SingleWord> expected = new ArrayList<>();
        expected.add(new SingleWord("WORD1", "TRANS1", "CAT1", 0));
        expected.add(new SingleWord("WORD2", "TRANS2", "CAT2", 0));

        //WHEN
        List<SingleWord> result = InputOutput.createListOfWords();

        //THEN
        assertEquals(result, expected);

    }
}