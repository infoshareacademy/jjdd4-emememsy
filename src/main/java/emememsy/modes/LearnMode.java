package emememsy.modes;

public class LearnMode implements Mode {

    @Override
    public String getModeName() {
        return "Nauka";
    }

    @Override
    public String getModeDescription() {
        return "2-gi etap nauki";
    }

    @Override
    public void launchMode() {
        System.out.println("Uruchamianie trybu - Nauka");
        // nakarmic tekstem
    }
}
