package com.example.sensortask.Model;

public class ProximitySenModel {
    private String DATETIME;
    private String PROXIMITY_VALUE;

    public ProximitySenModel(String DATETIME, String PROXIMITY_VALUE) {
        this.DATETIME = DATETIME;
        this.PROXIMITY_VALUE = PROXIMITY_VALUE;
    }

    public String getDATETIME() {
        return DATETIME;
    }

    public void setDATETIME(String DATETIME) {
        this.DATETIME = DATETIME;
    }

    public String getPROXIMITY_VALUE() {
        return PROXIMITY_VALUE;
    }

    public void setPROXIMITY_VALUE(String PROXIMITY_VALUE) {
        this.PROXIMITY_VALUE = PROXIMITY_VALUE;
    }
}
