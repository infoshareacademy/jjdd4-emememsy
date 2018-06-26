package emememsy;


import emememsy.modes.*;

import java.util.*;


//klasa tworzaca obiekt wybranego trybu - "uruchomienie" (...?)
public class ModeLauncher {

    private final Mode browserMode = new BrowserMode("Przeglądanie", "1szy etap nauki");
    private final Mode learnMode = new LearnMode("Nauka", "2gi etap nauki");
    private final Mode repeatMode = new RepeatMode("Utrwalanie", "3ci etap nauki");

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

}

