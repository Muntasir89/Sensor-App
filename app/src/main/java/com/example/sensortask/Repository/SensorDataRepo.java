package com.example.sensortask.Repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.sensortask.Database.SensorSQLiteHelper;
import com.example.sensortask.Model.AccelerometerSenModel;
import com.example.sensortask.Model.GyroscopeSenModel;
import com.example.sensortask.Model.LightSenModel;
import com.example.sensortask.Model.ProximitySenModel;
import com.example.sensortask.Model.SensorDataModel;
import com.example.sensortask.Utility.SensorDataProcess;

import java.util.List;

public class SensorDataRepo{
    Context context;
    private SensorSQLiteHelper sensorSQLiteHelper;

    MutableLiveData<List<LightSenModel>> lightDataList;
    MutableLiveData<List<ProximitySenModel>> proximityDataList;
    MutableLiveData<List<AccelerometerSenModel>> accelerometerDataList;
    MutableLiveData<List<GyroscopeSenModel>> gyroscopeDataList;

    String dateTime="", light, proximity, accelerometer_x, accelerometer_y, accelerometer_z, gyroscope_x, gyroscope_y, gyroscope_z;
    //SensorEventListenerCallback sensorListener = this;
    SensorDataProcess sensorDataProcess;

    private static final String TAG = "SensorDataRepo";
    public SensorDataRepo(Application application) {
        context = application.getApplicationContext();
        sensorSQLiteHelper = new SensorSQLiteHelper(context);
        //sensorDataProcess = new SensorDataProcess(context, sensorListener);
        // Creating AlarmBroadcast Receiver object to get notify
    }

    public MutableLiveData<List<LightSenModel>> getLightDataList() {
        lightDataList = sensorSQLiteHelper.getAllLightData();
        return lightDataList;
    }

    public MutableLiveData<List<ProximitySenModel>> getProximityDataList() {
        proximityDataList = sensorSQLiteHelper.getAllProximityData();
        return proximityDataList;
    }

    public MutableLiveData<List<AccelerometerSenModel>> getAccelerometerDataList() {
        accelerometerDataList = sensorSQLiteHelper.getAllAccelerometerData();
        return accelerometerDataList;
    }

    public MutableLiveData<List<GyroscopeSenModel>> getGyroscopeDataList() {
        gyroscopeDataList = sensorSQLiteHelper.getAllGyroscopeData();
        return gyroscopeDataList;
    }

    // Inserting Data
 public void insertSensorData(String dateTime,String  light,String  proximity,String  accelerometer_x,String  accelerometer_y,String  accelerometer_z,String  gyroscope_x,String  gyroscope_y,String  gyroscope_z) {
     //Log.e(TAG, "notifyInsertData:");
     sensorSQLiteHelper.insertData(dateTime, light, proximity, accelerometer_x, accelerometer_y, accelerometer_z, gyroscope_x, gyroscope_y, gyroscope_z);
    }
    public MutableLiveData<SensorDataModel> getRecentSensorData(){
        return sensorSQLiteHelper.getSensorData();
    }
}
