package com.infoshareacademy.emememsy;

import org.junit.Test;
import static org.junit.Assert.*;


public class SingleWordTest {

    @Test
    public void ifConversionWordsToLowerCase() {
        // given
        SingleWord subject = new SingleWord("TEST", "TEST", "TEST", 1);

        // when
        subject.toLowerCase();

        // then
        assertTrue(subject.getWord().equals("test"));
        assertTrue(subject.getTranslation().equals("test"));
        assertTrue(subject.getCategory().equals("test"));
    }

    @Test
    public void ifConversionWordsToUpperCase() {
        //GIVEN
        SingleWord subject = new SingleWord("test", "test", "test", 1);

        //WHEN
        subject.toUpperCase();

        //THEN
        assertTrue(subject.getWord().equals("TEST"));
        assertTrue(subject.getTranslation().equals("TEST"));
        assertTrue(subject.getCategory().equals("TEST"));
    }

    @Test
    public void ifGoodGradeWhereExpectedIncreaseCounterBy3() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.good();

        //THEN
        assertTrue(3 == singleWord.getCounter());
    }

    //Testing if counter of singleWord increased by 1
    @Test
    public void ifSosoGradeWhereExpectedIncreaseCounterBy1() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.soso();

        //THEN
        assertTrue(1 == singleWord.getCounter());
    }

    //Testing if counter of singleWord is still the same
    @Test
    public void ifBadGradeWhereExpectedStayCounterAsIs() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.bad();

        //THEN
        assertTrue(0 == singleWord.getCounter());
    }

    @Test
    public void ifIncreaseCounterBy1() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.increaseCounterByOne();

        //THEN
        assertTrue(1 == singleWord.getCounter());
    }

    //Testing if counter of singleWord increased by 100
    @Test
    public void ifExcludeWordActionWhereExpectedIncreaseCounterBy100() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.exclude();

        //THEN
        assertTrue(100 == singleWord.getCounter());
    }
}
