package emememsy;


import emememsy.modes.BrowserMode;
import emememsy.modes.LearnMode;
import emememsy.modes.Mode;
import emememsy.modes.RepeatMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//klasa tworzaca oiekt wybranego trybu - "uruchomienie" (...?)
public class ModeLauncher {

    public ModeLauncher() {

        BrowserMode browserMode = new BrowserMode();
        LearnMode learnMode = new LearnMode();
        RepeatMode repeatMode = new RepeatMode();


        Map<String, Mode> modeMap = new HashMap<String, Mode>();
        modeMap.put("b", browserMode);
        modeMap.put("l", learnMode);
        modeMap.put("r", repeatMode);

        for (Map.Entry<String, Mode> entry : modeMap.entrySet()) {
            //akcja dla iteracji ww mapy
        }




    //konstruktor tworzacy obiekt wybranego trybu
    //public ModeLauncher( argument-okreslajacy-tryb ) {
    }
}

