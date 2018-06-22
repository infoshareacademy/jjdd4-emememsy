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

    private static Map<String, Mode> modeMap = new HashMap<String, Mode>();
    modeMap.put("b", new BrowserMode());
    modeMap.put("l", new LearnMode());
    modeMap.put("r", new RepeatMode());




    //konstruktor tworzacy obiekt wybranego trybu
    //public ModeLauncher( argument-okreslajacy-tryb ) {
    }
}

