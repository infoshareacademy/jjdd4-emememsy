package com.infoshareacademy.emememsy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleWordTest {


}

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

    @Test
    public void good() {
        //GIVEN
        SingleWord singleWord = new SingleWord("test", "test", "test", 0);
        //WHEN
        //THEN

    }

    @Test
    public void soso() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    public void bad() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    public void increaseCounterByOne() {
        //GIVEN
        //WHEN
        //THEN
    }

    @Test
    public void exclude() {
        //GIVEN
        //WHEN
        //THEN
    }
}