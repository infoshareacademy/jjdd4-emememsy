package com.infoshareacademy.emememsy;

public class NumberFormatValidator {

    public static boolean isNumber(String input) {
        return (input.matches("[0-9]"));
    }
}