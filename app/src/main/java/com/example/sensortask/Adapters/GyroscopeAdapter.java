package com.example.sensortask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensortask.Model.GyroscopeSenModel;
import com.example.sensortask.R;
import com.example.sensortask.databinding.ActivityGyroscopeBinding;
import com.example.sensortask.databinding.GyroscopeDataItemBinding;

public class GyroscopeAdapter extends ListAdapter<GyroscopeSenModel, GyroscopeAdapter.GyroscopeViewModel> {
    public GyroscopeAdapter(){super(CALLBACK);}

    // returning and checking if data is same
    private static final DiffUtil.ItemCallback<GyroscopeSenModel> CALLBACK = new DiffUtil.ItemCallback<GyroscopeSenModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull GyroscopeSenModel oldData, @NonNull GyroscopeSenModel newData) {
            return true;
        }

        @Override
        public boolean areContentsTheSame(@NonNull GyroscopeSenModel oldData, @NonNull GyroscopeSenModel newData) {
            return oldData.getDATETIME().equals(newData.getDATETIME())  && oldData.getGYROSCOPE_X().equals(newData.getGYROSCOPE_X())  && oldData.getGYROSCOPE_Y().equals(newData.getGYROSCOPE_Y())  && oldData.getGYROSCOPE_Z().equals(newData.getGYROSCOPE_Z());
        }
    };
    @NonNull
    @Override
    public GyroscopeAdapter.GyroscopeViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gyroscope_data_item, parent, false);
        return new GyroscopeAdapter.GyroscopeViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GyroscopeAdapter.GyroscopeViewModel holder, int position) {
        GyroscopeSenModel data = getItem(position);
        holder.binding.timeTV.setText(data.getDATETIME());
        holder.binding.gyroscopeDataTV.setText("X: "+data.getGYROSCOPE_X()+" "+" Y: "+data.getGYROSCOPE_Y()+" "+" Z "+data.getGYROSCOPE_Z());

    }

    public class GyroscopeViewModel extends RecyclerView.ViewHolder {
        GyroscopeDataItemBinding binding;
        public GyroscopeViewModel(@NonNull View itemView) {
            super(itemView);
            binding = GyroscopeDataItemBinding.bind(itemView);
        }
    }
}
