package com.example.betajournal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "entries")
public class SavedEntries {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "onsight")
    private String onsight;

    @ColumnInfo(name = "flash")
    private String flash;

    @ColumnInfo(name = "redpoint")
    private String redpoint;

    @ColumnInfo(name = "no_send")
    private String noSend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOnsight() {
        return onsight;
    }

    public void setOnsight(String onsight) {
        this.onsight = onsight;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getRedpoint() {
        return redpoint;
    }

    public void setRedpoint(String redpoint) {
        this.redpoint = redpoint;
    }

    public String getNoSend() {
        return noSend;
    }

    public void setNoSend(String noSend) {
        this.noSend = noSend;
    }


}
