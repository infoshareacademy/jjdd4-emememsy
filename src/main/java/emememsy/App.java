package emememsy;

import java.util.Scanner;

/**
 * Main class application
 */

public class App {

    // funkcja czyszczaca ekran
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // start - główne menu prg
    public static void start() {
        System.out.println("Witamy w aplikacji do nauki słówek - myWords.");

        ModeLauncher mL = new ModeLauncher();


        Scanner scanner = new Scanner(System.in);

//        while (true) {
        System.out.println("Masz do wyboru: " +
                "\n1: Przegladanie " +
                "\n2: Nauka " + "" +
                "\n3: Utrwalanie " +
                "\n4: Zakończ ");
        System.out.print("Wybierz tryb: ");
        mL.selectMode(scanner.nextInt());
//        }
    }

    public static void main(String[] args) {
        start();
    }
}

