package com.example.sensortask.Utility;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

import com.example.sensortask.Interfaces.SensorEventListenerCallback;

public class SensorDataProcess implements SensorEventListener{
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor proximitySensor;
    private Sensor accelerometerSensor;
    private Sensor gyroscopeSensor;
    Context context;

    //String light, proximity, accelerometer_x, accelerometer_y, accelerometer_z, gyroscope_x, gyroscope_y, gyroscope_z;

    SensorEventListenerCallback sensorDataListener;
    public SensorDataProcess(Context context, SensorEventListenerCallback listener){
        this.sensorDataListener = listener;
        this.context = context;
        // Initialize SensorManager
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        // Initialize sensors
        if(sensorManager != null){
            lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

            if (lightSensor != null) {
                sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
            if (proximitySensor != null) {
                sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
            if (accelerometerSensor != null) {
                sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
            if (gyroscopeSensor != null) {
                sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }else{
            //Toast.makeText(context, "Sensor not available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){
            sensorDataListener.getLightSensorsData(Float.toString(sensorEvent.values[0]));
        }else if(sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY){
            sensorDataListener.getProximitySensorsData(Float.toString(sensorEvent.values[0]));
        }else if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            sensorDataListener.getAccelerometerSensorsData(Float.toString(sensorEvent.values[0]), Float.toString(sensorEvent.values[1]), Float.toString(sensorEvent.values[2]));
        }else if(sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            sensorDataListener.getGyroscopeSensorsData(Float.toString(sensorEvent.values[0]), Float.toString(sensorEvent.values[1]), Float.toString(sensorEvent.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

//    public void showToast(){
//        //Toast.makeText(context, light+" "/*+proximity+" "+accelerometer_x+" "+accelerometer_y+" "+accelerometer_z+" "+gyroscope_x+" "+gyroscope_y+" "+gyroscope_z*/, Toast.LENGTH_SHORT).show();
//    }
}
