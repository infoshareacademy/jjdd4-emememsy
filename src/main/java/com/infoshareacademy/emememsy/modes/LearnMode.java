package com.infoshareacademy.emememsy.modes;


import com.infoshareacademy.emememsy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LearnMode extends Mode {

    private static Scanner scanner = new Scanner(System.in); //skaner do wprowadzenia poz menu
    public LearnMode(String modeName, String modeDescriptopn) {
        super(modeName, modeDescriptopn);
    }
    private List<SingleWord> myList = InputOutput.createListOfWords();
    private SingleWord singleWord = new SingleWord();
    private ModeLauncher modeLauncher = new ModeLauncher();


    //realizacja menu dla objektu tego trybu (tej klasy)
    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 0:
                singleWord = new Actions().pickRandomLearnMode(myList);
                InputOutput.writeToCSV(myList);
                //System.out.println("\n\n\nTu wywolanie funkcji do wyswietlenia slowa po ang \n\n\n");
                launchMode();
                break;
            case 1:
                //TODO replace sout to Monica's function - incr word counter
                singleWord.bad();
                InputOutput.writeToCSV(myList);
                System.out.println("\n\n\nZapisaliśmy ocenę. Wybierz 0 aby wyświetlić kolejne słowo.\n\n\n");;
                launchMode();
                break;
            case 2:
                //TODO replace sout to Monica's function - incr word counter
                singleWord.soso();
                InputOutput.writeToCSV(myList);
                System.out.println("\n\n\nMusisz jeszcze poćwiczyć. Wybierz 0 aby wyświetlić kolejne słowo.\n\n\n");;                launchMode();
                break;
            case 3:
                //TODO replace sout to Monica's function - incr word counter
                singleWord.good();
                InputOutput.writeToCSV(myList);
                System.out.println("\n\n\nGratulacje! To słowo będzie nadal dostępne w trybie powtórek. Wybierz 0 aby wyświetlić kolejne słowo.\n\n\n");;                launchMode();
                break;
            case 4:
                modeLauncher.launchMainMenu();
                break;
            default:
                System.out.println("Sprobuj jeszcze raz: ");;
        }
    }


    @Override
    public void launchMode() {
        super.launchMode();
        //dodatkowe txt spec dla kazdego z trybow
        modeLauncher.clearScreen();
        System.out.println("\nMasz do wyboru:\n0: Wyswietl słowo\n1: Ocen na ŹLE\n2: Oceń na TAK-SOBIE\n3: Oceń na DOBRZE\n4: Wyjście do Menu Głównego\nWybierz: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMenu(Integer.valueOf(s));
        } else {
            System.out.println("\"Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)\"");
            launchMode();
        }
    }
}
