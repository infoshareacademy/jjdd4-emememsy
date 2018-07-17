package com.infoshareacademy.emememsy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleWordTest {

    @Test
    public void equals() {
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
        //WHEN
        //THEN
    }
}