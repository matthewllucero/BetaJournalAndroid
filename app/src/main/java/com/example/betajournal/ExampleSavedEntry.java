package com.example.betajournal;


public class ExampleSavedEntry {

    private String location;
    private String date;
    private String onsightGrades;
    private String flashGrades;
    private String redpointGrades;
    private String noSendGrades;

    public ExampleSavedEntry(String mLocation, String mDate, String mOnsightGrades,
                             String mFlashGrades, String mRedPointGrades, String mNoSendGrades) {

        location = mLocation;
        date = mDate;
        onsightGrades = mOnsightGrades;
        flashGrades = mFlashGrades;
        redpointGrades = mRedPointGrades;
        noSendGrades = mNoSendGrades;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOnsightGrades() {
        return onsightGrades;
    }

    public void setOnsightGrades(String onsightGrades) {
        this.onsightGrades = onsightGrades;
    }

    public String getFlashGrades() {
        return flashGrades;
    }

    public void setFlashGrades(String flashGrades) {
        this.flashGrades = flashGrades;
    }

    public String getRedpointGrades() {
        return redpointGrades;
    }

    public void setRedpointGrades(String redpointGrades) {
        this.redpointGrades = redpointGrades;
    }

    public String getNoSendGrades() {
        return noSendGrades;
    }

    public void setNoSendGrades(String noSendGrades) {
        this.noSendGrades = noSendGrades;
    }
}
