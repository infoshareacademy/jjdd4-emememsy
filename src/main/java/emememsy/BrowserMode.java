package emememsy;

public class BrowserMode implements Modes {

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
        BrowserMode browserMode = new BrowserMode();
        // cd kodu trybu przegladania
    }

    @Override
    public void exitMode() {
        System.out.println("Do widzenia");
        // tu ew zapis progresu nauki
        // wyjscie z prog
        System.exit(0);

    }
}
