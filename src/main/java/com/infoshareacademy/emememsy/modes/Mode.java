package com.infoshareacademy.emememsy.modes;

public abstract class Mode {

    private String modeName = "";
    private String modeDescriptopn = "";

    public Mode(String modeName, String modeDescriptopn) {
        this.modeName = modeName;
        this.modeDescriptopn = modeDescriptopn;
    }

    protected Mode() {
    }

    public void launchMode() {
        System.out.println("\nJestes w trybie: " + this.modeName);
        System.out.println("Opis: " + this.modeDescriptopn);

    }

}
