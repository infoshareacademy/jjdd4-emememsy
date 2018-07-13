package com.infoshareacademy.emememsy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ActionsTest {

    @Test
    public static void isSingleWordInPickRandomBrowserMode() {
        //GIVEN
        List<SingleWord> myList = new ArrayList<>();


        myList.add(new SingleWord("dom", "chair", "dom", 0));
        myList.add(new SingleWord("ziemniak", "JEDZENIE", "", 0));
        myList.add(new SingleWord("", "", "", 0));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomBrowserMode(myList);

        //THEN
        assertTrue(myList.contains(result));
    }
}

// "DOM","4","CHAIR","KRZESŁO"
// "JEDZENIE","0","TOMATO","POMIDOR"
//"JEDZENIE","5","POTATO","ZIEMNIAK"
//"JEDZENIE","4","CUCUMBER","OGÓREK"