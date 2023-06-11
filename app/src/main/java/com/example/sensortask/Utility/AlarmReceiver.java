package com.example.sensortask.Utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.sensortask.Interfaces.AlarmBroadcastListener;

public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";

    //SensorViewModel sensorViewModel;
    private AlarmBroadcastListener alarmBroadcastListener=null;
    public AlarmReceiver(){

    }

    public AlarmReceiver(AlarmBroadcastListener alarmListener){
        this.alarmBroadcastListener = alarmListener;
        //  sensorDataRepo = new SensorDataRepo(new Application());
        //  Log.e(TAG, "AlarmReceiver");
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        //SharedPreferences sharedPreferences = context.getSharedPreferences("", Context.MODE_PRIVATE);
        //Toast.makeText(context, "Sending Request", Toast.LENGTH_SHORT).show();
        //alarmBroadcastListener.notifyInsertData();
    }
}
