package com.example.sensortask.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sensortask.Model.AccelerometerSenModel;
import com.example.sensortask.Model.GyroscopeSenModel;
import com.example.sensortask.Model.LightSenModel;
import com.example.sensortask.Model.ProximitySenModel;
import com.example.sensortask.Model.SensorDataModel;
import com.example.sensortask.Repository.SensorDataRepo;

import java.util.List;

public class SensorViewModel extends AndroidViewModel {
    MutableLiveData<List<LightSenModel>> lightDataList;
    MutableLiveData<List<ProximitySenModel>> proximityDataList;
    MutableLiveData<List<AccelerometerSenModel>> accelerometerDataList;
    MutableLiveData<List<GyroscopeSenModel>> gyroscopeDataList;

    SensorDataRepo sensorDataRepo;

    public SensorViewModel(@NonNull Application application) {
        super(application);
        sensorDataRepo = new SensorDataRepo(application);
    }

    public MutableLiveData<List<LightSenModel>> getLightDataList() {
        this.lightDataList = sensorDataRepo.getLightDataList();
        return lightDataList;
    }

    public MutableLiveData<List<ProximitySenModel>> getProximityDataList() {
        this.proximityDataList = sensorDataRepo.getProximityDataList();
        return proximityDataList;
    }

    public MutableLiveData<List<AccelerometerSenModel>> getAccelerometerDataList() {
        this.accelerometerDataList = sensorDataRepo.getAccelerometerDataList();
        return accelerometerDataList;
    }

    public MutableLiveData<List<GyroscopeSenModel>> getGyroscopeDataList() {
        this.gyroscopeDataList = sensorDataRepo.getGyroscopeDataList();
        return gyroscopeDataList;
    }
    // For Inserting Data
    public void insertSensorData(String dateTime,String  light,String  proximity,String  accelerometer_x,String  accelerometer_y,String  accelerometer_z,String  gyroscope_x,String  gyroscope_y,String  gyroscope_z){
        sensorDataRepo.insertSensorData(dateTime, light, proximity, accelerometer_x, accelerometer_y, accelerometer_z, gyroscope_x, gyroscope_y, gyroscope_z);
    }

    public MutableLiveData<SensorDataModel> getRecentSensorData(){
        return sensorDataRepo.getRecentSensorData();
    }
}
