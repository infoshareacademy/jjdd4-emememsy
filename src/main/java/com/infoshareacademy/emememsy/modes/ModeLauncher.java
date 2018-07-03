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
                browserMode.launchMode();
                break;
            case 2:
                clearScreen();
                learnMode.launchMode();
                break;
            case 3:
                clearScreen();
                repeatMode.launchMode();
                break;
            case 4:
                System.exit(0);
            default:
                clearScreen();
                System.out.println("Sprobuj jeszcze raz!");
        }

    }

    public static void launchMainMenu() {
        clearScreen();
        System.out.println("Masz do wyboru:\n1: Przegladanie\n2: Nauka\n3: Utrwalanie\n4: Zakończ\nWybierz tryb:");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            selectMode(Integer.valueOf(s));
        } else {
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)");
            launchMainMenu();
        }

    }

    // funkcja czyszczaca ekran
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

}

