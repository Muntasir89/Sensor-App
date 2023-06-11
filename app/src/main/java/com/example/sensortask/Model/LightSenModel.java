package com.example.sensortask.Model;

public class LightSenModel {

    private String DATETIME;
    // for light sensor
    private String LIGHT_VALUE;

    public LightSenModel(String DATETIME, String LIGHT_VALUE) {
        this.DATETIME = DATETIME;
        this.LIGHT_VALUE = LIGHT_VALUE;
    }

    //Getting all value
    public String getDATETIME() {
        return DATETIME;
    }
    public String getLIGHT_VALUE() {
        return LIGHT_VALUE;
    }

    //Setting all value
    public void setDateTime(String dateTime) {
        DATETIME = dateTime;
    }
    public void setLIGHT_VALUE(String LIGHT_VALUE) {
        this.LIGHT_VALUE = LIGHT_VALUE;
    }

}
