package com.example.sensortask.Model;

public class AccelerometerSenModel {
    private String DATETIME;
    private String ACCELEROMETER_X, ACCELEROMETER_Y, ACCELEROMETER_Z;

    public AccelerometerSenModel(String DATETIME, String ACCELEROMETER_X, String ACCELEROMETER_Y, String ACCELEROMETER_Z) {
        this.DATETIME = DATETIME;
        this.ACCELEROMETER_X = ACCELEROMETER_X;
        this.ACCELEROMETER_Y = ACCELEROMETER_Y;
        this.ACCELEROMETER_Z = ACCELEROMETER_Z;
    }

    public String getDATETIME() {
        return DATETIME;
    }

    public String getACCELEROMETER_X() {
        return ACCELEROMETER_X;
    }

    public String getACCELEROMETER_Y() {
        return ACCELEROMETER_Y;
    }

    public String getACCELEROMETER_Z() {
        return ACCELEROMETER_Z;
    }

    public void setDATETIME(String DATETIME) {
        this.DATETIME = DATETIME;
    }

    public void setACCELEROMETER_X(String ACCELEROMETER_X) {
        this.ACCELEROMETER_X = ACCELEROMETER_X;
    }

    public void setACCELEROMETER_Y(String ACCELEROMETER_Y) {
        this.ACCELEROMETER_Y = ACCELEROMETER_Y;
    }

    public void setACCELEROMETER_Z(String ACCELEROMETER_Z) {
        this.ACCELEROMETER_Z = ACCELEROMETER_Z;
    }
}
