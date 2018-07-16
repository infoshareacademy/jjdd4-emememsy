package com.infoshareacademy.emememsy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ActionsTest {

    @Test
    public void pickRandomBrowserMode() {
        //GIVEN
        List<SingleWord> myBMWordList = new ArrayList<>();


        myBMWordList.add(new SingleWord("dom", "chair", "dom", 0));
        myBMWordList.add(new SingleWord("ziemniak", "JEDZENIE", "something", 23));
        myBMWordList.add(new SingleWord("test", "test", "test-category", 100));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomBrowserMode(myBMWordList);

        //THEN
        assertTrue(myBMWordList.contains(result));
    }

    @Test
    public void pickRandomLearnMode() {
        //GIVEN
        List<SingleWord> myLMWordList = new ArrayList<>();
        myLMWordList.add(new SingleWord())

        //WHEN

        //THEN
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


