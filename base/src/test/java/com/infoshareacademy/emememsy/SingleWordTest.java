package com.infoshareacademy.emememsy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleWordTest {

    @Test
    public void toLowerCase() {
        // given
        SingleWord subject = new SingleWord("Dupa", "Ass", "Niezwykle", 1);

        // when
        subject.toLowerCase();

        // then
        assertTrue(subject.getWord().equals("dupa"));
        assertTrue(subject.getTranslation().equals("ass"));
        assertTrue(subject.getCategory().equals("niezwykle"));

    }
}