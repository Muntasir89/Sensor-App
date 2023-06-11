package com.example.sensortask.Model;

public class SensorDataModel {
    String dateTime, light, proximity, accelerometer_x, accelerometer_y, accelerometer_z, gyroscope_x, gyroscope_y, gyroscope_z;

    public SensorDataModel(String dateTime, String light, String proximity, String accelerometer_x, String accelerometer_y, String accelerometer_z, String gyroscope_x, String gyroscope_y, String gyroscope_z) {
        this.dateTime = dateTime;
        this.light = light;
        this.proximity = proximity;
        this.accelerometer_x = accelerometer_x;
        this.accelerometer_y = accelerometer_y;
        this.accelerometer_z = accelerometer_z;
        this.gyroscope_x = gyroscope_x;
        this.gyroscope_y = gyroscope_y;
        this.gyroscope_z = gyroscope_z;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getProximity() {
        return proximity;
    }

    public void setProximity(String proximity) {
        this.proximity = proximity;
    }

    public String getAccelerometer_x() {
        return accelerometer_x;
    }

    public void setAccelerometer_x(String accelerometer_x) {
        this.accelerometer_x = accelerometer_x;
    }

    public String getAccelerometer_y() {
        return accelerometer_y;
    }

    public void setAccelerometer_y(String accelerometer_y) {
        this.accelerometer_y = accelerometer_y;
    }

    public String getAccelerometer_z() {
        return accelerometer_z;
    }

    public void setAccelerometer_z(String accelerometer_z) {
        this.accelerometer_z = accelerometer_z;
    }

    public String getGyroscope_x() {
        return gyroscope_x;
    }

    public void setGyroscope_x(String gyroscope_x) {
        this.gyroscope_x = gyroscope_x;
    }

    public String getGyroscope_y() {
        return gyroscope_y;
    }

    public void setGyroscope_y(String gyroscope_y) {
        this.gyroscope_y = gyroscope_y;
    }

    public String getGyroscope_z() {
        return gyroscope_z;
    }

    public void setGyroscope_z(String gyroscope_z) {
        this.gyroscope_z = gyroscope_z;
    }
}
