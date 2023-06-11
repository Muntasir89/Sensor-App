package com.example.sensortask.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.sensortask.Adapters.AccelerometerAdapter;
import com.example.sensortask.Adapters.ProximityAdapter;
import com.example.sensortask.Model.AccelerometerSenModel;
import com.example.sensortask.Model.ProximitySenModel;
import com.example.sensortask.R;
import com.example.sensortask.ViewModel.SensorViewModel;
import com.example.sensortask.databinding.ActivityAccelerometerBinding;
import com.example.sensortask.databinding.ActivityMainBinding;

import java.util.List;

public class AccelerometerAct extends AppCompatActivity {
    ActivityAccelerometerBinding binding;
    SensorViewModel sensorViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccelerometerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Creating a SensorViewModel object
        sensorViewModel = new ViewModelProvider(this).get(SensorViewModel.class);

        // Setting Layout to recyclerView
        binding.accelerometerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.accelerometerRecyclerView.setHasFixedSize(true);

        //Creating Adapter object
        AccelerometerAdapter accelerometerAdapter = new AccelerometerAdapter();
        binding.accelerometerRecyclerView.setAdapter(accelerometerAdapter);

        sensorViewModel.getAccelerometerDataList().observe(this, new Observer<List<AccelerometerSenModel>>() {
            @Override
            public void onChanged(List<AccelerometerSenModel> accelerometerSenModels) {
                accelerometerAdapter.submitList(accelerometerSenModels);
            }
        });
    }
}