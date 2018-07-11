package com.infoshareacademy.emememsy.modes;

import com.infoshareacademy.emememsy.*;

import java.util.List;
import java.util.Scanner;

public class LearnMode extends Mode {

    private static Scanner scanner = new Scanner(System.in);

    public LearnMode(String modeName, String modeDescription) {
        super(modeName, modeDescription);
    }

    private List<SingleWord> myList = InputOutput.createListOfWords();
    private SingleWord singleWord = new SingleWord();

    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 1:
                ModeLauncher.clearScreen();
                myList = InputOutput.createListOfWords();
                if ((singleWord = new Actions().pickRandomLearnMode(myList)) != null) {
                } else {
                    ModeLauncher.launchMainMenu();
                    break;
                }
                launchAssessmentMenu();
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

    public void selectAssessment(Integer menuInt) {

        switch (menuInt) {
            case 1:
                ModeLauncher.clearScreen();
                System.out.println("Poprawne tłumaczenie słowa: " + singleWord.getWord() + " to: " + singleWord.getTranslation());
                launchAssessmentMenu();
                break;
            case 2:
                ModeLauncher.clearScreen();
                singleWord.good();
                InputOutput.writeToCSV(myList);
                System.out.println("Zapisaliśmy Twój postęp w nauce");
                launchMode();
                break;
            case 3:
                ModeLauncher.clearScreen();
                singleWord.soso();
                InputOutput.writeToCSV(myList);
                System.out.println("Zapisaliśmy Twój postęp w nauce");
                launchMode();
                break;
            case 4:
                ModeLauncher.clearScreen();
                singleWord.bad();
                InputOutput.writeToCSV(myList);
                System.out.println("Zapisaliśmy Twój postęp w nauce.");
                launchMode();
                break;
            default:
                ModeLauncher.clearScreen();
                System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)");
                launchAssessmentMenu();
        }
    }


    @Override
    public void launchMode() {
        System.out.print("\nMasz do wyboru:\n\n1: Wyswietl słowo\n2: Wyjście do Menu Głównego\n\nWybierz: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMenu(Integer.valueOf(s));
        } else {
            ModeLauncher.clearScreen();
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-2)");
            launchMode();
        }
    }

    public void launchAssessmentMenu() {
        System.out.print("\nMasz do wyboru:\n\n1: Wyświetl tłumaczenie \n2: Dobrze znam tłumaczenie słowa " + singleWord.getWord() + "\n3: Średnio znam tłumaczenie tego słowa \n4: Nie wiem jak przetłumaczyć to słowo\n\nWybierz: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectAssessment(Integer.valueOf(s));
        } else {
            ModeLauncher.clearScreen();
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)");
            launchAssessmentMenu();
        }
    }
}
