package com.infoshareacademy.emememsy.modes;

import com.infoshareacademy.emememsy.NumberFormatValidator;

import java.util.Scanner;

//klasa tworzaca obiekt wybranego trybu.
public class ModeLauncher {

    private static final Mode browserMode = new BrowserMode("Przeglądanie", "1szy etap nauki");
    private static final Mode learnMode = new LearnMode("Nauka", "2gi etap nauki");
    private static final Mode repeatMode = new RepeatMode("Utrwalanie", "3ci etap nauki");
    static Scanner scanner = new Scanner(System.in);

    public ModeLauncher() {
    }

    public static void selectMode(Integer modeInt) {

        switch (modeInt) {
            case 1:
                clearScreen();
                System.out.println("Jesteś w trybie przeglądania. To pierwszy etap.");
                browserMode.launchMode();
                break;
            case 2:
                clearScreen();
                System.out.println("Jesteś w trybie nauki. To drugi etap.");
                learnMode.launchMode();
                break;
            case 3:
                clearScreen();
                System.out.println("Jesteś w trybie nauki. To trzeci etap.");
                repeatMode.launchMode();
                break;
            case 4:
                System.exit(0);
            default:
                clearScreen();
                System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)\n");
                launchMainMenu();
        }
    }


    public static void launchMainMenu() {
        System.out.print("Masz do wyboru:\n \n1: Przeglądanie\n2: Nauka\n3: Utrwalanie\n4: Zakończ\n \nWybierz tryb:");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMode(Integer.valueOf(s));
        } else {
            clearScreen();
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)\n");
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

