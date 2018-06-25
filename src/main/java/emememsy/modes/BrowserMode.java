package emememsy.modes;

public class BrowserMode implements Mode {

    @Override
    public String getModeName() {
        return "Przegladanie";
    }

    @Override
    public String getModeDescription() {
        return "1-szy etap nauki";
    }

    @Override
    public void launchMode() {
        System.out.println("Uruchamianie modułu - Przegladanie");
        // nakarmic tekstem
    }
}
