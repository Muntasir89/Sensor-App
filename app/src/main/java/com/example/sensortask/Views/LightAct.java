package com.example.sensortask.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.sensortask.Adapters.LightAdapter;
import com.example.sensortask.Model.LightSenModel;
import com.example.sensortask.R;
import com.example.sensortask.ViewModel.SensorViewModel;
import com.example.sensortask.databinding.ActivityLightBinding;
import com.example.sensortask.databinding.ActivityMainBinding;

import java.util.List;

public class LightAct extends AppCompatActivity {
    ActivityLightBinding binding;
    SensorViewModel sensorViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Creating a SensorViewModel object
        sensorViewModel = new ViewModelProvider(this).get(SensorViewModel.class);

        // Setting Layout to recyclerView
        binding.lightRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.lightRecyclerView.setHasFixedSize(true);

        //Creating Adapter object
        LightAdapter lightAdapter = new LightAdapter();
        binding.lightRecyclerView.setAdapter(lightAdapter);

        sensorViewModel.getLightDataList().observe(this, new Observer<List<LightSenModel>>() {
            @Override
            public void onChanged(List<LightSenModel> lightSenModels) {
                lightAdapter.submitList(lightSenModels);
            }
        });
    }
}