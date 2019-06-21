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

    @ColumnInfo(name = "v0_count")
    private int v0Count;

    @ColumnInfo(name = "v1_count")
    private int v1Count;

    @ColumnInfo(name = "v2_count")
    private int v2Count;

    @ColumnInfo(name = "v3_count")
    private int v3Count;

    @ColumnInfo(name = "v4_count")
    private int v4Count;

    @ColumnInfo(name = "v5_count")
    private int v5Count;

    @ColumnInfo(name = "v6_count")
    private int v6Count;

    @ColumnInfo(name = "v7_count")
    private int v7Count;

    @ColumnInfo(name = "v8_count")
    private int v8Count;

    @ColumnInfo(name = "v9_count")
    private int v9Count;

    @ColumnInfo(name = "v10_count")
    private int v10Count;

    @ColumnInfo(name = "v11_count")
    private int v11Count;

    @ColumnInfo(name = "v12_count")
    private int v12Count;

    @ColumnInfo(name = "v13_count")
    private int v13count;

    @ColumnInfo(name = "v14_count")
    private int v14Count;

    @ColumnInfo(name = "v15_count")
    private int v15Count;

    @ColumnInfo(name = "v16_count")
    private int v16Count;

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

    public int getV0Count() {
        return v0Count;
    }

    public void setV0Count(int v0Count) {
        this.v0Count = v0Count;
    }

    public int getV1Count() {
        return v1Count;
    }

    public void setV1Count(int v1Count) {
        this.v1Count = v1Count;
    }

    public int getV2Count() {
        return v2Count;
    }

    public void setV2Count(int v2Count) {
        this.v2Count = v2Count;
    }

    public int getV3Count() {
        return v3Count;
    }

    public void setV3Count(int v3Count) {
        this.v3Count = v3Count;
    }

    public int getV4Count() {
        return v4Count;
    }

    public void setV4Count(int v4Count) {
        this.v4Count = v4Count;
    }

    public int getV5Count() {
        return v5Count;
    }

    public void setV5Count(int v5Count) {
        this.v5Count = v5Count;
    }

    public int getV6Count() {
        return v6Count;
    }

    public void setV6Count(int v6Count) {
        this.v6Count = v6Count;
    }

    public int getV7Count() {
        return v7Count;
    }

    public void setV7Count(int v7Count) {
        this.v7Count = v7Count;
    }

    public int getV8Count() {
        return v8Count;
    }

    public void setV8Count(int v8Count) {
        this.v8Count = v8Count;
    }

    public int getV9Count() {
        return v9Count;
    }

    public void setV9Count(int v9Count) {
        this.v9Count = v9Count;
    }

    public int getV10Count() {
        return v10Count;
    }

    public void setV10Count(int v10Count) {
        this.v10Count = v10Count;
    }

    public int getV11Count() {
        return v11Count;
    }

    public void setV11Count(int v11Count) {
        this.v11Count = v11Count;
    }

    public int getV12Count() {
        return v12Count;
    }

    public void setV12Count(int v12Count) {
        this.v12Count = v12Count;
    }

    public int getV13count() {
        return v13count;
    }

    public void setV13count(int v13count) {
        this.v13count = v13count;
    }

    public int getV14Count() {
        return v14Count;
    }

    public void setV14Count(int v14Count) {
        this.v14Count = v14Count;
    }

    public int getV15Count() {
        return v15Count;
    }

    public void setV15Count(int v15Count) {
        this.v15Count = v15Count;
    }

    public int getV16Count() {
        return v16Count;
    }

    public void setV16Count(int v16Count) {
        this.v16Count = v16Count;
    }
}
