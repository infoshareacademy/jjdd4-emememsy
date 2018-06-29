package com.infoshareacademy.emememsy.modes;



import com.infoshareacademy.emememsy.NumberFormatValidator;

import java.util.Scanner;

public class RepeatMode extends Mode {

    private static Scanner scanner = new Scanner(System.in); //skaner do wprowadzenia poz menu


    public RepeatMode(String modeName, String modeDescriptopn) {
        super(modeName, modeDescriptopn);
    }

    //realizacja menu dla objektu tego trybu (tej klasy)
    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 1:
                //TODO replace sout to Monika's function
                System.out.println("\n\n\nTu wywolanie funkcji do wyswietlenia slowa po ang \n\n\n");
                launchMode();
                break;
            case 2:
                //TODO replace sout to Monica's function - incr word counter
                System.out.println("\n\n\nwywołanie funkcji wyswietlenia tłumaczenia\n\n\n");;
                launchMode();
                break;
            case 3:
                //TODO replace sout to Monica's function - incr word counter plus jak nizej sout
                System.out.println("\n\n\nEkran pusty plu Wywoołanie funkcji zwiekszajaca licznik po ktorej wlk nie bedzie utrwalane\n\n\n");
                launchMode();
                break;
            case 4:
                //wyjscie do menu gl
                ModeLauncher.launchMainMenu();
                break;
            default:
                System.out.println("Sprobuj jeszcze raz: ");;
        }
    }

    @Override
    public void launchMode() {
        ModeLauncher.clearScreen();
        super.launchMode();
        //dodatkowe txt spec dla kazdego z trybow

        //dodatkowe txt spec dla kazdego z trybow
        System.out.println("\nMasz do wyboru:\n1: Utrwalaj slowa\n2: Wyswietl tłumaczenie\n3: Usun z utrwalania\n4: Wyjście do Menu Głównego\nWybierz: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMenu(Integer.valueOf(s));
        } else {
            System.out.println("\"Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)\"");
            launchMode();
        }

    }

}
