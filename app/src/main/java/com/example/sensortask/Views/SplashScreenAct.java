package com.example.sensortask.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.sensortask.R;
import com.example.sensortask.Utility.AlarmReceiver;
import com.example.sensortask.databinding.ActivitySplashScreenBinding;

public class SplashScreenAct extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.expand);
        binding.appTitle.startAnimation(animation);

        //alarmMgr = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        //Intent intent = new Intent(this, AlarmReceiver.class);
        //alarmIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT|PendingIntent.FLAG_MUTABLE);
        //alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
        //        1000 * 60, alarmIntent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenAct.this, MainActivity.class));
                finish();
            }
        }, 3500);
    }
}