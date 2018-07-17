package com.infoshareacademy.emememsy;

import com.infoshareacademy.emememsy.model.SingleWord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ActionsTest {

    //testing if SingleWord obj is for BrowserMode (counter == 0)
    @Test
    public void pickRandomBrowserMode() {
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

    //testing if SingleWord obj is for LearnMode (counter is between 1 and 3 including)
    @Test
    public void pickRandomLearnMode() {
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

    //testing if SingleWord obj is for RepeatMode (counter is between 4 and 98 including)
    @Test
    public void pickRandomRepeatMode() {
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
    public void showCorrectTranslation() {
        //GIVEN
        SingleWord singleWord = new SingleWord("word", "translation", "category", 3);

        //WHEN
        Actions actions = new Actions();
        String result = actions.showCorrectTranslation(singleWord);

        //THEN
        assertTrue(result.equals("Poprawne tłumaczenie to: translation"));
    }
}


