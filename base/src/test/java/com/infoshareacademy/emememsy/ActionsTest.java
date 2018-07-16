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
        List<SingleWord> myBMWordList = new ArrayList<>();

        myBMWordList.add(new SingleWord("dom", "chair", "dom", 0));
        myBMWordList.add(new SingleWord("ziemniak", "JEDZENIE", "something", 0));
        myBMWordList.add(new SingleWord("test", "test", "test-category", 0));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomBrowserMode(myBMWordList);

        //THEN
        assertTrue(myBMWordList.contains(result));
    }

    //testing if SingleWord obj is for LearnMode (counter is between 1 and 4)
    @Test
    public void pickRandomLearnMode() {
        //GIVEN
        List<SingleWord> myLMWordList = new ArrayList<>();

        myLMWordList.add(new SingleWord("test1", "test1", "test1", 1));
        myLMWordList.add(new SingleWord("test2", "test2", "test2", 2));
        myLMWordList.add(new SingleWord("test3", "test3", "test3", 3));
        myLMWordList.add(new SingleWord("test4", "test4", "test4", 4));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomLearnMode(myLMWordList);

        //THEN
        assertTrue(myLMWordList.contains(result));
    }

    @Test
    public void pickRandomRepeatMode() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    public void showCorrectTranslation() {
        //GIVEN

        //WHEN

        //THEN
    }
}


