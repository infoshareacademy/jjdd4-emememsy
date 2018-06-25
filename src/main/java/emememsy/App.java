package emememsy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class application
 */

public class App {
    public static void main(String[] args) {
        ModeLauncher mL = new ModeLauncher();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witamy w myWords.");
            System.out.println("Masz do wyboru: " +
                    "\n1: Przegladanie " +
                    "\n2: Nauka " + "" +
                    "\n3: Utrwalanie " +
                    "\n4: Zakończ ");
            System.out.print("Wybierz tryb: ");
            mL.selectMode(scanner.nextInt());
        }


    }
}
