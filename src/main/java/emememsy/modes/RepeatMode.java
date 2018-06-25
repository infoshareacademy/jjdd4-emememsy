package emememsy.modes;


public class RepeatMode implements Mode {

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
        System.out.println("Uruchamianie trybu - Utrwalanie");
        // nakarmic tekstem
    }
}
