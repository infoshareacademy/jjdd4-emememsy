package com.infoshareacademy.emememsy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleWordTest {

    @Test
    public void toLowerCase() {
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
    public void toUpperCase() {
        //GIVEN
        SingleWord subject = new SingleWord("test", "test", "test", 1);

        //WHEN
        subject.toUpperCase();

        //THEN
        assertTrue(subject.getWord().equals("TEST"));
        assertTrue(subject.getTranslation().equals("TEST"));
        assertTrue(subject.getCategory().equals("TEST"));
    }

    //Testing if counter of singleWord increased by 3
    @Test
    public void good() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.good();

        //THEN
        assertTrue(3 == singleWord.getCounter());
    }

    //Testing if counter of singleWord increased by 1
    @Test
    public void soso() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.soso();

        //THEN
        assertTrue(1 == singleWord.getCounter());
    }

    //Testing if counter of singleWord is still the same
    @Test
    public void bad() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.bad();

        //THEN
        assertTrue(0 == singleWord.getCounter());
    }

    //Testing if counter of singleWord increased by 1
    @Test
    public void increaseCounterByOne() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.increaseCounterByOne();

        //THEN
        assertTrue(1 == singleWord.getCounter());
    }

    //Testing if counter of singleWord increased by 100
    @Test
    public void exclude() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);

        //WHEN
        singleWord.exclude();

        //THEN
        assertTrue(100 == singleWord.getCounter());
    }
}
