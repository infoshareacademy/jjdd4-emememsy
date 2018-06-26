package emememsy.modes;

public abstract class Mode {

    private final String modeName = "";
    private final String modeDescriptopn = "";

    public Mode(String modeName, String modeDescriptopn) {
        this.modeName = modeName;
        this.modeDescriptopn = modeDescriptopn;
    }

    protected Mode() {
    }

    public void launchMode() {
        System.out.println("Witamy w trybie " + this.modeName);
        System.out.println("Opis trybu " + this.modeDescriptopn);

    }
}
