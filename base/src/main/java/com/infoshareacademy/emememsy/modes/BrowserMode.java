package com.infoshareacademy.emememsy.modes;

import com.infoshareacademy.emememsy.*;
import com.infoshareacademy.emememsy.SingleWord;
import java.util.List;
import java.util.Scanner;

public class BrowserMode extends Mode {

    private Scanner scanner = new Scanner(System.in);
    private List<SingleWord> myList = InputOutput.createListOfWords();
    private SingleWord singleWord = new SingleWord();

    public BrowserMode(String modeName, String modeDescription) {
        super(modeName, modeDescription);
    }

    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 1:
                ModeLauncher.clearScreen();
                headerMode();
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
                headerMode();
                System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-2)");
                headerMode();
                launchMode();
        }
    }

    @Override
    public void launchMode() {
        System.out.print("Masz do wyboru:\n\n1: Wyswietl slowo-tłumaczenie\n2: Wyjście do Menu Głównego\n\nWybierz: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMenu(Integer.valueOf(s));
        } else {
            ModeLauncher.clearScreen();
            headerMode();
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-2)");
            launchMode();
        }
    }

    @Override
    public void headerMode() {
        super.headerMode();
    }
}



