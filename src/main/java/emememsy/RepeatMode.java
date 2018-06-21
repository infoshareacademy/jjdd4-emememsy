package emememsy;


public class RepeatMode implements Modes {

    @Override
    public String getModeName() {
        return "Utrwalanie";
    }

    @Override
    public String getModeDescription() {
        return "3-ci etap nauki";
    }

    @Override
    public void launchMode() {
        System.out.println("Uruchamianie trubu - Utrwalanie");
        RepeatMode repeatMode = new RepeatMode();
        // cd uruch trybu
    }

    @Override
    public void exitMode() {
        System.out.println("Do widzenia");
        // tu ew zapis progresu nauki
        // wyjscie z prog
        System.exit(0);
    }
}
