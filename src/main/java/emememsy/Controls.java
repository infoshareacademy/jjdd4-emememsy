package emememsy;



// Klasa nadrzedna z podstawowymi metodami sterujacymi jak Start, Stop czy tryb pracy
public class Controls {

    //pola dot stanow App
    private boolean startAppState;
    private boolean stopAppState;

    //pola dot tryby pracy
    private boolean browserModeState;
    private boolean learnModeState;
    private boolean reminderModeState;


    // Gettery i Settery do stanow App
    public boolean isStartAppState() {
        return startAppState;
    }

    public void setStartAppState(boolean startAppState) {
        this.startAppState = startAppState;
    }



    // Getery i setery do stanow trybow pracy
    public boolean isStopAppState() {
        return stopAppState;
    }

    public void setStopAppState(boolean stopAppState) {
        this.stopAppState = stopAppState;
    }

    public boolean isBrowserModeState() {
        return browserModeState;
    }

    public void setBrowserModeState(boolean browserModeState) {
        this.browserModeState = browserModeState;
    }

    public boolean isLearnModeState() {
        return learnModeState;
    }

    public void setLearnModeState(boolean learnModeState) {
        this.learnModeState = learnModeState;
    }

    public boolean isReminderModeState() {
        return reminderModeState;
    }

    public void setReminderModeState(boolean reminderModeState) {
        this.reminderModeState = reminderModeState;
    }



}
