package com.infoshareacademy.emememsy.modes;

import com.infoshareacademy.emememsy.Actions;
import com.infoshareacademy.emememsy.InputOutput;
import com.infoshareacademy.emememsy.NumberFormatValidator;
import com.infoshareacademy.emememsy.SingleWord;

import java.util.List;
import java.util.Scanner;

public class RepeatMode extends Mode {

    private static Scanner scanner = new Scanner(System.in);

    public RepeatMode(String modeName, String modeDescription) {
        super(modeName, modeDescription);
    }

    private List<SingleWord> myList = InputOutput.createListOfWords();
    private SingleWord singleWord = new SingleWord();

    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 1:
                ModeLauncher.clearScreen();
                myList = InputOutput.createListOfWords();
                if ((singleWord = new Actions().pickRandomRepeatMode(myList)) != null) {
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
                System.out.println("To słowo będzie nadal wyświetlane w trybie powtórek");
                launchMode();
                break;
            case 3:
                ModeLauncher.clearScreen();
                singleWord.exclude();
                InputOutput.writeToCSV(myList);
                System.out.println("To słowo nie będzie już dostępne w żadnym z trybów nauki.");
                launchMode();
                break;
            default:
                ModeLauncher.clearScreen();
                System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-3)");
                launchAssessmentMenu();
        }
    }

    @Override
    public void launchMode() {
        System.out.print("\nMasz do wyboru: \n\n1: Utrwalaj slowa\n2: Wyjście do Menu Głównego\n\nWybierz: ");
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
        System.out.print("\nMasz do wyboru:\n\n1: Wyświetl tłumaczenie \n2: Pozostaw słowo " + singleWord.getWord() + " w trybie powtórek\n3: Trwale usuń słowo z trynu powtórek\n\nWybierz: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectAssessment(Integer.valueOf(s));
        } else {
            ModeLauncher.clearScreen();
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-3)");
            launchAssessmentMenu();
        }
    }
}
