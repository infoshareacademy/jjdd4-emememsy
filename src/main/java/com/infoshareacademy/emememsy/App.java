package com.infoshareacademy.emememsy;


import com.infoshareacademy.emememsy.modes.ModeLauncher;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        new App().run();

    }

    private void run() {
        System.out.println("Witamy w aplikacji do nauki słówek - myWords.");
        List<SingleWord> myList = new ArrayList<>();
        myList = InputOutput.createListOfWords();
        SingleWord singleWord = new SingleWord();
        ModeLauncher modeLauncher = new ModeLauncher();
        modeLauncher.launchMainMenu();
    }


}


