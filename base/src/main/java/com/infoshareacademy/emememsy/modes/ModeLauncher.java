package com.infoshareacademy.emememsy.modes;

import com.infoshareacademy.emememsy.NumberFormatValidator;
import java.util.Scanner;

//class witch creates mode objects, contains main menu and launch them. There are some static common methods also here
public class ModeLauncher {

    //There are created object of each mode here. Args in constructors responds to their name and description
    private static final Mode browserMode = new BrowserMode("Przeglądanie", "1szy etap nauki");
    private static final Mode learnMode = new LearnMode("Nauka", "2gi etap nauki");
    private static final Mode repeatMode = new RepeatMode("Utrwalanie", "3ci etap nauki");
    static Scanner scanner = new Scanner(System.in);

    public ModeLauncher() {
    }

    //choosing mode here
    public static void selectMode(Integer modeInt) {

        switch (modeInt) {
            case 1:
                clearScreen();
                browserMode.headerMode();
                browserMode.launchMode();
                break;
            case 2:
                clearScreen();
                learnMode.headerMode();
                learnMode.launchMode();
                break;
            case 3:
                clearScreen();
                repeatMode.headerMode();
                repeatMode.launchMode();
                break;
            case 4:
                System.exit(0);
            default:
                clearScreen();
                System.out.println("Nie zrozumiałem. Podaj jeszcze raz pozycję z menu (1-4)\n");
                launchMainMenu();
        }
    }

    //main menu display
    public static void launchMainMenu() {
        System.out.print("Masz do wyboru:\n \n1: Przeglądanie\n2: Nauka\n3: Utrwalanie\n4: Zakończ\n \nWybierz tryb: ");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMode(Integer.valueOf(s));
        } else {
            clearScreen();
            System.out.println("Nie zrozumiałem. Podaj jeszcze raz pozycję z menu (1-4)\n");
            launchMainMenu();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}

