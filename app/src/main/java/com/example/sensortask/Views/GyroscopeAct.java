package com.example.sensortask.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.sensortask.Adapters.AccelerometerAdapter;
import com.example.sensortask.Adapters.GyroscopeAdapter;
import com.example.sensortask.Model.AccelerometerSenModel;
import com.example.sensortask.Model.GyroscopeSenModel;
import com.example.sensortask.R;
import com.example.sensortask.ViewModel.SensorViewModel;
import com.example.sensortask.databinding.ActivityGyroscopeBinding;

import java.util.List;

public class GyroscopeAct extends AppCompatActivity {
    ActivityGyroscopeBinding binding;
    SensorViewModel sensorViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGyroscopeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Creating a SensorViewModel object
        sensorViewModel = new ViewModelProvider(this).get(SensorViewModel.class);

        // Setting Layout to recyclerView
        binding.gyroscopeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.gyroscopeRecyclerView.setHasFixedSize(true);

        //Creating Adapter object
        GyroscopeAdapter gyroscopeAdapter = new GyroscopeAdapter();
        binding.gyroscopeRecyclerView.setAdapter(gyroscopeAdapter);

        sensorViewModel.getGyroscopeDataList().observe(this, new Observer<List<GyroscopeSenModel>>() {
            @Override
            public void onChanged(List<GyroscopeSenModel> gyroscopeSenModels) {
                gyroscopeAdapter.submitList(gyroscopeSenModels);
            }
        });
    }
}