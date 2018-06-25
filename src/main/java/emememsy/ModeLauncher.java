package emememsy;


import emememsy.modes.*;

import java.util.*;


//klasa tworzaca oiekt wybranego trybu - "uruchomienie" (...?)
public class ModeLauncher {

    private int modeInt;
    private final BrowserMode browserMode = new BrowserMode();
    private final LearnMode learnMode = new LearnMode();
    private final RepeatMode repeatMode = new RepeatMode();

    public ModeLauncher() {


//        Map<Integer, Mode> modeMap = new HashMap<Integer, Mode>();
//        modeMap.put(1, browserMode);
//        modeMap.put(2, learnMode);
//        modeMap.put(3, repeatMode);
//
//        for (Map.Entry<String, Mode> entry : modeMap.entrySet()) {
//            //akcja dla iteracji ww mapy

//        entry.getValue();
    }

    public void selectMode(int modeInt) {

        switch (modeInt) {
            case 1:
                System.out.println("Witamy w trybie: " + browserMode.getModeName());
                System.out.println("Opis trybu: " + browserMode.getModeDescription());
                browserMode.launchMode();
                break;
            case 2:
                System.out.println("Witamy w trybie: " + learnMode.getModeName());
                System.out.println("Opisb trybu: " + learnMode.getModeDescription());
                break;
            case 3:
                System.out.println("Witamy w trybie: " + repeatMode.getModeName());
                System.out.println("Opis trybu : " + repeatMode.getModeDescription());
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Sprobuj jeszcze raz!");
        }

    }


    public int getModeInt() {
        return modeInt;
    }

    public void setModeInt(int modeInt) {
        this.modeInt = modeInt;
    }
}

