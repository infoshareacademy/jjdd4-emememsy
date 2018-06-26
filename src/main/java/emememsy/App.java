package emememsy;

import java.util.Scanner;

/**
 * Main class application
 */

public class App {
    private static ModeLauncher modeLauncher = new ModeLauncher();
    private static Scanner scanner = new Scanner(System.in);

    // funkcja czyszczaca ekran
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // start - główne menu prg
    public static void mainMenu() {
        clearScreen();
        System.out.println("Masz do wyboru:\n1: Przegladanie\n2: Nauka\n3: Utrwalanie\n4: Zakończ\nWybierz tryb:");
        modeLauncher.selectMode(scanner.nextInt());
    }

    public static void main(String[] args) {
        System.out.println("Witamy w aplikacji do nauki słówek - myWords.");
        mainMenu();
    }
}

