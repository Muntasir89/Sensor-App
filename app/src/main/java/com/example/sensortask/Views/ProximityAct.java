package com.example.sensortask.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.sensortask.Adapters.LightAdapter;
import com.example.sensortask.Adapters.ProximityAdapter;
import com.example.sensortask.Model.LightSenModel;
import com.example.sensortask.Model.ProximitySenModel;
import com.example.sensortask.R;
import com.example.sensortask.ViewModel.SensorViewModel;
import com.example.sensortask.databinding.ActivityLightBinding;
import com.example.sensortask.databinding.ActivityProximityBinding;

import java.util.List;

public class ProximityAct extends AppCompatActivity {
    ActivityProximityBinding binding;
    SensorViewModel sensorViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProximityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Creating a SensorViewModel object
        sensorViewModel = new ViewModelProvider(this).get(SensorViewModel.class);

        // Setting Layout to recyclerView
        binding.proximityRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.proximityRecyclerView.setHasFixedSize(true);

        //Creating Adapter object
        ProximityAdapter proximityAdapter = new ProximityAdapter();
        binding.proximityRecyclerView.setAdapter(proximityAdapter);

        sensorViewModel.getProximityDataList().observe(this, new Observer<List<ProximitySenModel>>() {
            @Override
            public void onChanged(List<ProximitySenModel> proximitySenModels) {
                proximityAdapter.submitList(proximitySenModels);
            }
        });
    }
}