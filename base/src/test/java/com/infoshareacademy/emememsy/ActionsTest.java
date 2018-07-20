package com.infoshareacademy.emememsy;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class ActionsTest {

    @Test
    public void testIfWordQualifyForBrowserModeWitchCounterExpected0() {
        //GIVEN
        List<SingleWord> testList = new ArrayList<>();

        testList.add(new SingleWord("dom", "chair", "dom", 0));
        testList.add(new SingleWord("ziemniak", "JEDZENIE", "something", 0));
        testList.add(new SingleWord("test", "test", "test-category", 0));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomBrowserMode(testList);

        //THEN
        assertTrue(testList.contains(result));
    }

    @Test
    public void testIfWordQualifyForLearnModeWitchCounterExpected1to3() {
        //GIVEN
        List<SingleWord> testList = new ArrayList<>();

        testList.add(new SingleWord("test1", "test1", "test1", 1));
        testList.add(new SingleWord("test2", "test2", "test2", 2));
        testList.add(new SingleWord("test3", "test3", "test3", 3));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomLearnMode(testList);

        //THEN
        assertTrue(testList.contains(result));
    }

    @Test
    public void ifWordQualifyForRepeatModeWitchCounterExpected4to99() {
        //GIVEN
        List<SingleWord> testList = new ArrayList<>();

        testList.add(new SingleWord("test1", "test1", "test1", 4));
        testList.add(new SingleWord("test2", "test2", "test2", 50));
        testList.add(new SingleWord("test3", "test3", "test3", 99));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomRepeatMode(testList);

        //THEN
        assertTrue(testList.contains(result));
    }

    @Test
    public void ifCorrectTranslation() {
        //GIVEN
        SingleWord singleWord = new SingleWord("word", "translation", "category", 3);
        String expected = "Poprawne tłumaczenie to: " + singleWord.getTranslation();

        //WHEN
        Actions actions = new Actions();
        String result = actions.showCorrectTranslation(singleWord);

        //THEN
        assertTrue(result.equals(expected));
    }
}


