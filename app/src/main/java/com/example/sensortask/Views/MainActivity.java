package com.example.sensortask.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sensortask.Interfaces.AlarmBroadcastListener;
import com.example.sensortask.Interfaces.SensorEventListenerCallback;
import com.example.sensortask.Model.SensorDataModel;
import com.example.sensortask.R;
import com.example.sensortask.Utility.AlarmReceiver;
import com.example.sensortask.Utility.SensorDataProcess;
import com.example.sensortask.ViewModel.SensorViewModel;
import com.example.sensortask.databinding.ActivityMainBinding;
import com.example.sensortask.databinding.ActivitySplashScreenBinding;

import org.checkerframework.checker.units.qual.A;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListenerCallback{
    ActivityMainBinding binding;
    SensorViewModel sensorViewModel;

    private static final String TAG = "MainActivity";
    String dateTime, light, proximity, accelerometer_x, accelerometer_y, accelerometer_z, gyroscope_x, gyroscope_y, gyroscope_z;
    SensorDataProcess sensorDataProcess;

    MutableLiveData<SensorDataModel> recentData = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sensorViewModel = new ViewModelProvider(this).get(SensorViewModel.class);

        //Setting AlarmReceiverListener
        sensorDataProcess = new SensorDataProcess(MainActivity.this, this);

        //Setting OnClickListener
        binding.lightCard.setOnClickListener(this);
        binding.proximityCard.setOnClickListener(this);
        binding.accelerometerCard.setOnClickListener(this);
        binding.gyroscopeCard.setOnClickListener(this);
        binding.dataBtn.setOnClickListener(this);

        getRecentData();
    }

    private void getRecentData() {
        recentData = sensorViewModel.getRecentSensorData();
        binding.lightValueTV.setText(recentData.getValue().getLight());
        binding.proximityValueTV.setText(recentData.getValue().getProximity());
        binding.accelerometerValueTV.setText("X: "+recentData.getValue().getAccelerometer_x()+" Y: "+recentData.getValue().getAccelerometer_y()+" Z: "+recentData.getValue().getAccelerometer_y());
        binding.gyroscopeValueTV.setText("X: "+recentData.getValue().getGyroscope_x()+" Y: "+recentData.getValue().getGyroscope_y()+" Z: "+recentData.getValue().getGyroscope_z());
    }

    @Override
    public void onClick(View view) {
        if(view != null){
            if(view.getId() == R.id.lightCard){
                startActivity(new Intent(this, LightAct.class));
            }else if(view.getId() == R.id.proximityCard){
                startActivity(new Intent(this, ProximityAct.class));
            }else if(view.getId() == R.id.accelerometerCard){
                startActivity(new Intent(this, AccelerometerAct.class));
            }else if(view.getId() == R.id.gyroscopeCard){
                startActivity(new Intent(this, GyroscopeAct.class));

            }else if(view.getId() == R.id.dataBtn){
                //Toast.makeText(this, dateTime+" "+light+" "+proximity+" "+accelerometer_x+" "+accelerometer_y+" "+accelerometer_z+" "+gyroscope_x+" "+gyroscope_y+" "+gyroscope_z, Toast.LENGTH_SHORT).show();
                insertData();
                updateCurrentData();
            }
        }
    }

    private void updateCurrentData() {
        binding.lightValueTV.setText(light.substring(0, Math.min(light.length(), 10)));
        binding.proximityValueTV.setText(proximity.substring(0, Math.min(proximity.length(), 10)));
        binding.accelerometerValueTV.setText("X: "+accelerometer_x.substring(0, Math.min(accelerometer_x.length(), 10))+" Y: "+accelerometer_y.substring(0, Math.min(accelerometer_y.length(), 10))+" Z: "+accelerometer_z.substring(0, Math.min(accelerometer_z.length(), 10)));
        binding.gyroscopeValueTV.setText("X: "+gyroscope_x.substring(0, Math.min(gyroscope_x.length(), 10))+" Y: "+gyroscope_y.substring(0, Math.min(gyroscope_y.length(), 10))+" Z: "+gyroscope_z.substring(0, Math.min(gyroscope_z.length(), 10)));
    }

    private void insertData() {
        LocalDateTime now = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            now = LocalDateTime.now();
            dateTime = DateTimeFormatter.ISO_INSTANT.format(now.toInstant(ZoneOffset.UTC));
        }
        sensorViewModel.insertSensorData(dateTime, light.substring(0, Math.min(light.length(), 8)), proximity.substring(0, Math.min(proximity.length(), 8)), accelerometer_x.substring(0, Math.min(accelerometer_x.length(), 8)), accelerometer_y.substring(0, Math.min(accelerometer_y.length(), 8)), accelerometer_z.substring(0, Math.min(accelerometer_z.length(), 8)), gyroscope_x.substring(0, Math.min(gyroscope_x.length(), 8)), gyroscope_y.substring(0, Math.min(gyroscope_y.length(), 8)), gyroscope_z.substring(0, Math.min(gyroscope_z.length(), 8)));
    }

    @Override
    public void getLightSensorsData(String lightValue) {
        this.light = lightValue;
    }

    @Override
    public void getProximitySensorsData(String proximity) {
        this.proximity = proximity;
    }

    @Override
    public void getAccelerometerSensorsData(String accelerometer_x, String accelerometer_y, String accelerometer_z) {
        this.accelerometer_x = accelerometer_x;
        this.accelerometer_y = accelerometer_y;
        this.accelerometer_z = accelerometer_z;
    }

    @Override
    public void getGyroscopeSensorsData(String gyroscope_x, String gyroscope_y, String gyroscope_z) {
        this.gyroscope_x = gyroscope_x;
        this.gyroscope_y = gyroscope_y;
        this.gyroscope_z = gyroscope_z;
    }
}
                ////Toast.makeText(this, dateTime+" "+light+" "+proximity+" "+accelerometer_x+" "+accelerometer_y+" "+accelerometer_z+" "+gyroscope_x+" "+gyroscope_y+" "+gyroscope_z, Toast.LENGTH_SHORT).show();
