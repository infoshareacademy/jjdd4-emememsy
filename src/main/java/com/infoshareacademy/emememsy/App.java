package com.infoshareacademy.emememsy;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        new App().run();

    }

    private void run() {
        System.out.println("Witamy w aplikacji do nauki słówek - myWords.");
        mainMenu();
    }

    // funkcja czyszczaca ekran
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // start - główne menu prg
    public static void mainMenu() {
        ModeLauncher modeLauncher = new ModeLauncher();
        Scanner scanner = new Scanner(System.in);
        clearScreen();
        System.out.println("Masz do wyboru:\n1: Przegladanie\n2: Nauka\n3: Utrwalanie\n4: Zakończ\nWybierz tryb:");
        String s = scanner.nextLine();
        if (NumberFormatValidator.isNumber(s)) {
            modeLauncher.selectMode(Integer.valueOf(s));
        } else {
            System.out.println("Nie zrozumiałem Cię. Podaj jeszcze raz pozycję z menu (1-4)");
            mainMenu();
            //launchMode();
        }

    }
}
