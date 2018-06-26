package emememsy.modes;

import emememsy.App;

public class BrowserMode extends Mode {

    private int menuInt;

    public BrowserMode(String modeName, String modeDescriptopn) {
        super(modeName, modeDescriptopn);
    }

    public void selectMenu(int menuInt) {
        switch (menuInt) {
            case 1:
                System.out.println("Tu wywolanie funkcji wwywolania pary slowo-tlumaczenie");
            case 2:
                App.start();
            default:
                System.out.println("Sprobuj jeszcze raz: ");






        }
    }

    @Override
    public void launchMode() {
        super.launchMode();
        System.out.println("Masz do wyboru: " +
                "\n1: Wyswietl slowo-tłumaczenie " +
                "\n2: Wyjście do Menu Głównego");
        System.out.println("Wybierz: ");
    }
}
