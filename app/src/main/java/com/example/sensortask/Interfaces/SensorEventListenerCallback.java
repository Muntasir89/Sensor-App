package com.example.sensortask.Interfaces;

public interface SensorEventListenerCallback {
    void getLightSensorsData(String lightValue);
    void getProximitySensorsData(String proximity);
    void getAccelerometerSensorsData(String accelerometer_x, String accelerometer_y, String accelerometer_z);
    void getGyroscopeSensorsData(String gyroscope_x, String gyroscope_y, String gyroscope_z) ;
}