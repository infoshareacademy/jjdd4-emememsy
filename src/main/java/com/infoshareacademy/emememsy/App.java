package com.infoshareacademy.emememsy;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
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
        System.out.println("Witamy w aplikacji do nauki słówek - myWords.");
        System.out.println("Masz do wyboru:\n1: Przegladanie\n2: Nauka\n3: Utrwalanie\n4: Zakończ\nWybierz tryb:");
        modeLauncher.selectMode(scanner.nextInt());
    }
}
