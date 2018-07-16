package com.infoshareacademy.emememsy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ActionsTest {

    @Test
    public static void isSingleWordReturnedFromPickRandomBrowserMode() {
        //GIVEN
        List<SingleWord> myList = new ArrayList<>();


        myList.add(new SingleWord("dom", "chair", "dom", 0));
        myList.add(new SingleWord("ziemniak", "JEDZENIE", "something", 23));
        myList.add(new SingleWord("test", "test", "test-category", 100));

        //WHEN
        Actions actions = new Actions();
        SingleWord result = actions.pickRandomBrowserMode(myList);

        //THEN
        assertTrue(myList.contains(result));
    }
}
