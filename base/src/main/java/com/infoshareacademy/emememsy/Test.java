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
            myList = InputOutput.createListOfWords();

        SingleWord singleWord1 = new Actions().pickRandomLearnMode(myList);

        myList.stream().forEach(System.out::println);
        }
    }



