package com.example.sensortask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensortask.Model.LightSenModel;
import com.example.sensortask.R;
import com.example.sensortask.databinding.LightDataItemBinding;

public class LightAdapter extends ListAdapter<LightSenModel, LightAdapter.LightViewModel> {
    public LightAdapter(){super(CALLBACK);}

    // returning and checking if data is same
    private static final DiffUtil.ItemCallback<LightSenModel> CALLBACK = new DiffUtil.ItemCallback<LightSenModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull LightSenModel oldData, @NonNull LightSenModel newData) {
            return true;
        }

        @Override
        public boolean areContentsTheSame(@NonNull LightSenModel oldData, @NonNull LightSenModel newData) {
            return oldData.getDATETIME().equals(newData.getDATETIME())  && oldData.getLIGHT_VALUE().equals(newData.getLIGHT_VALUE());
        }
    };
    @NonNull
    @Override
    public LightViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.light_data_item, parent, false);
        return new LightViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LightViewModel holder, int position) {
        LightSenModel data = getItem(position);
        holder.binding.timeTV.setText(data.getDATETIME());
        holder.binding.lightDataTV.setText(data.getLIGHT_VALUE());

    }

    public class LightViewModel extends RecyclerView.ViewHolder {
        LightDataItemBinding binding;
        public LightViewModel(@NonNull View itemView) {
            super(itemView);
            binding = LightDataItemBinding.bind(itemView);
        }
    }
}
