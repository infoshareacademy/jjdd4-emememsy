package com.infoshareacademy.emememsy.modes;


import com.infoshareacademy.emememsy.NumberFormatValidator;

import java.util.Scanner;


//klasa tworzaca obiekt wybranego trybu.
public class ModeLauncher {

    private final Mode browserMode = new BrowserMode("Przeglądanie", "1szy etap nauki");
    private final Mode learnMode = new LearnMode("Nauka", "2gi etap nauki");
    private final Mode repeatMode = new RepeatMode("Utrwalanie", "3ci etap nauki");
    Scanner scanner = new Scanner(System.in);

    public ModeLauncher() {

    }

    public void selectMode(Integer modeInt) {

        switch (modeInt) {
            case 1:
                browserMode.launchMode();
                break;
            case 2:
                learnMode.launchMode();
                break;
            case 3:
                repeatMode.launchMode();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Sprobuj jeszcze raz!");
        }

    }

    public void launchMainMenu() {
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
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

