package com.infoshareacademy.emememsy.modes;

import com.infoshareacademy.emememsy.*;

import java.util.List;
import java.util.Scanner;

public class BrowserMode extends Mode {

    private static Scanner scanner = new Scanner(System.in);

    public BrowserMode(String modeName, String modeDescription) {
        super(modeName, modeDescription);
    }

    private List<SingleWord> myList = InputOutput.createListOfWords();
    private SingleWord singleWord = new SingleWord();

    //realizacja menu dla objektu tego trybu (tej klasy)
    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 1:
                //TODO replace sout by Monika's function
                ModeLauncher.clearScreen();
                if ((singleWord = new Actions().pickRandomBrowserMode(myList)) != null) {
                    singleWord.increaseCounterByOne();
                    InputOutput.writeToCSV(myList);
                } else {
                    System.out.println("Nie ma więcej słów do nauki. Przejdź do trybu testu.");
                    ModeLauncher.launchMainMenu();
                    break;
                }
                launchMode();
                break;
            case 2:
                ModeLauncher.clearScreen();
                ModeLauncher.launchMainMenu();
                break;
            default:
                ModeLauncher.clearScreen();
                System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-2)");
                launchMode();
        }
    }

    // "uruchomienie" trybu - ekran powitalny plus pobranie nr menu od usera
    @Override
    public void launchMode() {
        System.out.print("\nMasz do wyboru:\n\n1: Wyswietl slowo-tłumaczenie\n2: Wyjście do Menu Głównego\n\nWybierz: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMenu(Integer.valueOf(s));
        } else {
            ModeLauncher.clearScreen();
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-2)");
            launchMode();
        }
    }
}



