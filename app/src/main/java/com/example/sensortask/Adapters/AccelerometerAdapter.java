package com.example.sensortask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensortask.Model.AccelerometerSenModel;
import com.example.sensortask.Model.AccelerometerSenModel;
import com.example.sensortask.R;
import com.example.sensortask.databinding.AccelerometerDataItemBinding;

public class AccelerometerAdapter extends ListAdapter<AccelerometerSenModel, AccelerometerAdapter.AccelerometerViewModel> {
    public AccelerometerAdapter(){super(CALLBACK);}

    // returning and checking if data is same
    private static final DiffUtil.ItemCallback<AccelerometerSenModel> CALLBACK = new DiffUtil.ItemCallback<AccelerometerSenModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull AccelerometerSenModel oldData, @NonNull AccelerometerSenModel newData) {
            return true;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AccelerometerSenModel oldData, @NonNull AccelerometerSenModel newData) {
            return oldData.getDATETIME().equals(newData.getDATETIME())  && oldData.getACCELEROMETER_X().equals(newData.getACCELEROMETER_X())  && oldData.getACCELEROMETER_Y().equals(newData.getACCELEROMETER_Y())  && oldData.getACCELEROMETER_Z().equals(newData.getACCELEROMETER_Z());
        }
    };
    @NonNull
    @Override
    public AccelerometerAdapter.AccelerometerViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accelerometer_data_item, parent, false);
        return new AccelerometerAdapter.AccelerometerViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccelerometerAdapter.AccelerometerViewModel holder, int position) {
        AccelerometerSenModel data = getItem(position);
        holder.binding.timeTV.setText(data.getDATETIME());
        holder.binding.accelerometerDataTV.setText("X: "+data.getACCELEROMETER_X()+" "+" Y: "+data.getACCELEROMETER_Y()+" "+" Z "+data.getACCELEROMETER_Z());

    }

    public class AccelerometerViewModel extends RecyclerView.ViewHolder {
        AccelerometerDataItemBinding binding;
        public AccelerometerViewModel(@NonNull View itemView) {
            super(itemView);
            binding = AccelerometerDataItemBinding.bind(itemView);
        }
    }
}
