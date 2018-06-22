package emememsy.modes;

public interface Mode {
    public String getModeName();
    public String getModeDescription();
    public void launchMode();
    public void exitMode();
}
