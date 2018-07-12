package com.infoshareacademy.emememsy;

import java.util.ArrayList;
import java.util.List;

public class Test {

    //this is another main fot testing purposes - please don't assess - WILL BE REMOVED after merging all modules and adding proper tests

    public static void main(String[] args) {
        new Test().run();
    }

    private void run() {

        List<SingleWord> myList = new ArrayList<>();
        //test wczytania pliku i stworenia tablicy
            myList = InputOutput.createListOfWords();

        //symulacja trybu nauki
        //String singleWord = new Actions().pickRandomLearnMode(myList);

        //SingleWord singleWord1 = new Actions().pickRandomLearnMode(myList);

        //Actions.setAllCountersToZero(myList);

         InputOutput.writeToCSV(myList);


        //weryfikacja stanu listy
        myList.stream().forEach(System.out::println);

        //NumberFormatValidator numberFormatValidator = new NumberFormatValidator();
        //System.out.println( numberFormatValidator.isNumber("1"));

    }
    }



