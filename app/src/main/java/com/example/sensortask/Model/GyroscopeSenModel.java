package com.example.sensortask.Model;

public class GyroscopeSenModel {
    private String DATETIME;
    private String GYROSCOPE_X, GYROSCOPE_Y, GYROSCOPE_Z;

    public GyroscopeSenModel(String DATETIME, String GYROSCOPE_X, String GYROSCOPE_Y, String GYROSCOPE_Z) {
        this.DATETIME = DATETIME;
        this.GYROSCOPE_X = GYROSCOPE_X;
        this.GYROSCOPE_Y = GYROSCOPE_Y;
        this.GYROSCOPE_Z = GYROSCOPE_Z;
    }

    public String getDATETIME() {
        return DATETIME;
    }

    public String getGYROSCOPE_X() {
        return GYROSCOPE_X;
    }

    public String getGYROSCOPE_Y() {
        return GYROSCOPE_Y;
    }

    public String getGYROSCOPE_Z() {
        return GYROSCOPE_Z;
    }

    public void setDATETIME(String DATETIME) {
        this.DATETIME = DATETIME;
    }

    public void setGYROSCOPE_X(String GYROSCOPE_X) {
        this.GYROSCOPE_X = GYROSCOPE_X;
    }

    public void setGYROSCOPE_Y(String GYROSCOPE_Y) {
        this.GYROSCOPE_Y = GYROSCOPE_Y;
    }

    public void setGYROSCOPE_Z(String GYROSCOPE_Z) {
        this.GYROSCOPE_Z = GYROSCOPE_Z;
    }
}
