package com.example.sensortask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sensortask.Model.LightSenModel;
import com.example.sensortask.Model.ProximitySenModel;
import com.example.sensortask.R;
import com.example.sensortask.databinding.LightDataItemBinding;
import com.example.sensortask.databinding.ProximityDataItemBinding;

public class ProximityAdapter extends ListAdapter<ProximitySenModel, ProximityAdapter.ProximityViewModel> {
    public ProximityAdapter(){super(CALLBACK);}

    // returning and checking if data is same
    private static final DiffUtil.ItemCallback<ProximitySenModel> CALLBACK = new DiffUtil.ItemCallback<ProximitySenModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull ProximitySenModel oldData, @NonNull ProximitySenModel newData) {
            return true;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ProximitySenModel oldData, @NonNull ProximitySenModel newData) {
            return oldData.getDATETIME().equals(newData.getDATETIME())  && oldData.getPROXIMITY_VALUE().equals(newData.getPROXIMITY_VALUE());
        }
    };
    @NonNull
    @Override
    public ProximityAdapter.ProximityViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.proximity_data_item, parent, false);
        return new ProximityAdapter.ProximityViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProximityAdapter.ProximityViewModel holder, int position) {
        ProximitySenModel data = getItem(position);
        holder.binding.timeTV.setText(data.getDATETIME());
        holder.binding.proximityDataTV.setText(data.getPROXIMITY_VALUE());

    }

    public class ProximityViewModel extends RecyclerView.ViewHolder {
        ProximityDataItemBinding binding;
        public ProximityViewModel(@NonNull View itemView) {
            super(itemView);
            binding = ProximityDataItemBinding.bind(itemView);
        }
    }
}
