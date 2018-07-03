package com.infoshareacademy.emememsy.modes;


import com.infoshareacademy.emememsy.*;

import java.util.List;
import java.util.Scanner;

public class BrowserMode extends Mode {

    private static Scanner scanner = new Scanner(System.in); //skaner do wprowadzenia poz menu
    //konstruktor objektu trybu "ustawiający" jego nazwe i opis ktore z automatu sa wypisywane przez .lounchMode (rodzica)
    public BrowserMode(String modeName, String modeDescriptopn) {
        super(modeName, modeDescriptopn);
    }
    private List<SingleWord> myList = InputOutput.createListOfWords();
    private SingleWord singleWord = new SingleWord();

    //realizacja menu dla objektu tego trybu (tej klasy)
    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 1:
                //TODO replace sout by Monika's function
                ModeLauncher.clearScreen();
                SingleWord singleWord = new SingleWord();
                if ((singleWord = new Actions().pickRandomBrowserMode(myList)) != null) {
                    singleWord.increaseCounterByOne();
                    String output = "Słowo: " + singleWord.getWord() + ", Tłumaczenie: " + singleWord.getTranslation();
                    System.out.println(output);
                    InputOutput.writeToCSV(myList);
                } else {
                    System.out.println("Nie ma więcej słów do nauki. Przejdź do trybu testu.");
                }

                //System.out.println("\n\n\nTu wywolanie funkcji wwywolania pary slowo-tlumaczenie \n\n\n");
                launchMode();
                break;
            case 2:
                ModeLauncher.clearScreen();
                ModeLauncher.launchMainMenu();
                break;
            default:
                ModeLauncher.clearScreen();
                System.out.println("Sprobuj jeszcze raz: ");
                launchMode();
        }
    }

    // "uruchomienie" trybu - ekran powitalny plus pobranie nr menu od usera
    @Override
    public void launchMode() {
        //ModeLauncher.clearScreen();
        super.launchMode(); //wywolanie ciala metody klasy-rodzica - wspolnej dla wszystkich obiektow od typu Mode
        // ponizej specyficzne display dla kazdego z trybow tutaj takie:
        System.out.println("\nMasz do wyboru:\n1: Wyswietl slowo-tłumaczenie\n2: Wyjście do Menu Głównego\nWybierz: ");
        //selectMenu(scanner.nextInt()); //wprowadzenie usera jako arg bezp do metody selectMenu()
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMenu(Integer.valueOf(s));
        } else {
            System.out.println("\"Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-2)\"");
            launchMode();
        }
    }
}



