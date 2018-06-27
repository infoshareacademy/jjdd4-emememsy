package com.infoshareacademy.emememsy.modes;


import com.infoshareacademy.emememsy.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LearnMode extends Mode {

    private static Scanner scanner = new Scanner(System.in); //skaner do wprowadzenia poz menu


    public LearnMode(String modeName, String modeDescriptopn) {
        super(modeName, modeDescriptopn);
    }

    //realizacja menu dla objektu tego trybu (tej klasy)
    public void selectMenu(Integer menuInt) {

        switch (menuInt) {
            case 0:
                System.out.println("\n\n\nTu wywolanie funkcji do wyswietlenia slowa po ang \n\n\n");
                launchMode();
                break;
            case 1:
                //TODO replace sout to Monica's function - incr word counter
                System.out.println("\n\n\nNastepuje ocena - ZLE\n\n\n");;
                launchMode();
                break;
            case 2:
                //TODO replace sout to Monica's function - incr word counter
                System.out.println("\n\n\nNastepuje ocena - TAK-SOBIE\n\n\n");
                launchMode();
                break;
            case 3:
                //TODO replace sout to Monica's function - incr word counter
                System.out.println("\n\n\nNastepuje ocena - DOBRZE\n\n\n");;
                launchMode();
                break;
            case 4:
                App.mainMenu();
                break;
            default:
                System.out.println("Sprobuj jeszcze raz: ");;
        }
    }


    @Override
    public void launchMode() {
        super.launchMode();

        //dodatkowe txt spec dla kazdego z trybow
        System.out.println("\nMasz do wyboru:\n0: Wyswietl słowo\n1: Ocen na ŹLE\n2: Oceń na TAK-SOBIE\n 3: Oceń na DOBRZE\n4: Wyjście do Menu Głównego\nWybierz: ");
        selectMenu(scanner.nextInt());
    }
}
