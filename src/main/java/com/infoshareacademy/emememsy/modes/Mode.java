package com.infoshareacademy.emememsy.modes;

public abstract class Mode {

    private String modeName = "";
    private String modeDescription = "";

    public Mode(String modeName, String modeDescription) {
        this.modeName = modeName;
        this.modeDescription = modeDescription;
    }

    protected Mode() {
    }

    public void launchMode() {
        System.out.println("Jestes w trybie: " + this.modeName);
        System.out.println("Opis: " + this.modeDescription);
    }
}
