package com.example.sensortask.Utility;

public class SensorDataServices{
    /*private SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor proximitySensor;
    private Sensor accelerometerSensor;
    private Sensor gyroscopeSensor;

    private SensorSQLiteHelper sensorSQLiteHelper;
    private SensorViewModel sensorViewModel;

    private Handler handler;
    private Runnable dataCollectionRunnable;

    private static final long DATA_COLLECTION_INTERVAL = 5 * 60 * 1000;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Initialize sensors
        if(sensorManager != null){
            lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }else{
            Toast.makeText(this, "Sensor not available", Toast.LENGTH_SHORT).show();
        }

        // Initialize database helper
        sensorSQLiteHelper = new SensorSQLiteHelper(this);

        //Creating a SensorViewModel object
        sensorViewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(SensorViewModel.class);

        // Initialize Handler and Runnable for data collection
        handler = new Handler();
        dataCollectionRunnable = new Runnable() {
            @Override
            public void run() {
                collectSensorData();
                handler.postDelayed(this, DATA_COLLECTION_INTERVAL);
              }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startDataCollection();
        startForegroundService();
        return START_STICKY;
    }

    private void startForegroundService() {
        // Creating notification channel if targeting Android Oreo (API 26) or above
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = "sensor_data_channel";
            String channelName = "Sensor Data Service";
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            // Configuring the channel (e.g., description, sound, vibration, etc.)
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
        // Create a notification
        // Create a notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "sensor_data_channel")
                .setContentTitle("Sensor Data Service")
                .setContentText("Collecting sensor data...")
                .setSmallIcon(R.drawable.ic_notification);

        // Setting the notification as ongoing (it cannot be dismissed)
        //notificationBuilder.setOngoing(true);

        // Start the foreground service with the notification
        startForeground(1, notificationBuilder.build());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopDataCollection();
        // Cleaning up resources here
    }

    private void startDataCollection(){
        handler.postDelayed(dataCollectionRunnable, DATA_COLLECTION_INTERVAL);
    }

    private void stopDataCollection(){
        handler.removeCallbacks(dataCollectionRunnable);
    }

    private void collectSensorData(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }*/
}
