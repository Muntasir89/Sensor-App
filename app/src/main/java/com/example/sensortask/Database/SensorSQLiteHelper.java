package com.example.sensortask.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.sensortask.Model.AccelerometerSenModel;
import com.example.sensortask.Model.GyroscopeSenModel;
import com.example.sensortask.Model.LightSenModel;
import com.example.sensortask.Model.ProximitySenModel;
import com.example.sensortask.Model.SensorDataModel;

import java.util.ArrayList;
import java.util.List;

public class SensorSQLiteHelper extends SQLiteOpenHelper {
    MutableLiveData<List<LightSenModel>>lightDataList;
    MutableLiveData<List<ProximitySenModel>>proximityDataList;
    MutableLiveData<List<AccelerometerSenModel>>accelerometerDataList;
    MutableLiveData<List<GyroscopeSenModel>>gyroscopeDataList;
    MutableLiveData<SensorDataModel> sensorData;

    public static final String DATABASE_NAME = "Sensor.db";
    public static final String TABLE_NAME = "SensorTable";
    public static final String COL_DATE_TIME        = "DATE_TIME";
    public static final String COL_LIGHT_VALUE      = "LIGHT_VALUE";
    public static final String COL_PROXIMITY_VALUE  = "PROXIMITY_VALUE";
    public static final String COL_ACCELEROMETER_X  = "ACCELEROMETER_X";
    public static final String COL_ACCELEROMETER_Y  = "ACCELEROMETER_Y";
    public static final String COL_ACCELEROMETER_Z  = "ACCELEROMETER_Z";
    public static final String COL_GYROSCOPE_X      = "GYROSCOPE_X";
    public static final String COL_GYROSCOPE_Y      = "GYROSCOPE_Y";
    public static final String COL_GYROSCOPE_Z      = "GYROSCOPE_Z";

    Context context;

    // Creating Constructor
    public SensorSQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    // Creating Database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE_TIME TEXT, LIGHT_VALUE TEXT, PROXIMITY_VALUE TEXT, ACCELEROMETER_X TEXT, ACCELEROMETER_Y TEXT, ACCELEROMETER_Z TEXT, GYROSCOPE_X TEXT, GYROSCOPE_Y TEXT, GYROSCOPE_Z TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String DATE_TIME, String LIGHT_VALUE, String PROXIMITY_VALUE, String ACCELEROMETER_X, String ACCELEROMETER_Y, String ACCELEROMETER_Z, String GYROSCOPE_X, String GYROSCOPE_Y, String GYROSCOPE_Z){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contents = new ContentValues();
        //9 column
        contents.put(COL_DATE_TIME      , DATE_TIME      );
        contents.put(COL_LIGHT_VALUE    , LIGHT_VALUE    );
        contents.put(COL_PROXIMITY_VALUE, PROXIMITY_VALUE);
        contents.put(COL_ACCELEROMETER_X, ACCELEROMETER_X);
        contents.put(COL_ACCELEROMETER_Y, ACCELEROMETER_Y);
        contents.put(COL_ACCELEROMETER_Z, ACCELEROMETER_Z);
        contents.put(COL_GYROSCOPE_X    , GYROSCOPE_X    );
        contents.put(COL_GYROSCOPE_Y    , GYROSCOPE_Y    );
        contents.put(COL_GYROSCOPE_Z    , GYROSCOPE_Z    );

        long result = db.insert(TABLE_NAME, null, contents);
        if(result == -1) return false;
        else return true;
    }

    public boolean deleteData(String path){
        SQLiteDatabase db = this.getWritableDatabase();
        //String query = "DELETE FROM Favourite_table WHERE PATH = '"+path+"'";
        Integer numrows = db.delete(TABLE_NAME, "PATH = '"+path+"'", null);
        if(numrows>0)
            return true;
        else
            return false;
    }

    // Passing all Light Data list
    public MutableLiveData<List<LightSenModel>> getAllLightData(){
        List<LightSenModel> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COL_DATE_TIME +", "+COL_LIGHT_VALUE+" FROM SensorTable";
        Cursor cursor = db.rawQuery(query, null);  // Getting the cursor
        cursor.moveToFirst();       // Moving cursor to the first
        if(cursor != null){
            while(cursor.isAfterLast() == false){
                String DateTime = cursor.getString(0);
                String LightValue = cursor.getString(1);

                LightSenModel model = new LightSenModel(DateTime, LightValue);
                dataList.add(model);

                cursor.moveToNext();
            }
        }
        cursor.close(); // Closing cursor for memory leak
        lightDataList = new MutableLiveData<>(dataList);  // Initializing lightDataList
        lightDataList.setValue(dataList); // Setting value
        return lightDataList;
    }

    public MutableLiveData<List<ProximitySenModel>> getAllProximityData(){
        List<ProximitySenModel> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COL_DATE_TIME +", "+COL_PROXIMITY_VALUE+" FROM SensorTable";
        Cursor cursor = db.rawQuery(query, null);  // Getting the cursor
        cursor.moveToFirst();       // Moving cursor to the first
        if(cursor != null){
            while(cursor.isAfterLast() == false){
                String DateTime = cursor.getString(0);
                String ProximityValue = cursor.getString(1);

                ProximitySenModel model = new ProximitySenModel(DateTime, ProximityValue);
                dataList.add(model);

                cursor.moveToNext();
            }
        }
        cursor.close(); // Closing cursor for memory leak
        proximityDataList = new MutableLiveData<>(dataList);  // Initializing proximityDataList
        proximityDataList.setValue(dataList); // Setting value
        return proximityDataList;
    }

    public MutableLiveData<List<AccelerometerSenModel>> getAllAccelerometerData(){
        List<AccelerometerSenModel> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COL_DATE_TIME +", "+COL_ACCELEROMETER_X+", "+COL_ACCELEROMETER_Y+", "+COL_ACCELEROMETER_Z+" FROM SensorTable";
        Cursor cursor = db.rawQuery(query, null);  // Getting the cursor
        cursor.moveToFirst();       // Moving cursor to the first
        if(cursor != null){
            while(cursor.isAfterLast() == false){
                String DateTime = cursor.getString(0);
                String accelerometer_x = cursor.getString(1);
                String accelerometer_y = cursor.getString(2);
                String accelerometer_z = cursor.getString(3);

                AccelerometerSenModel model = new AccelerometerSenModel(DateTime, accelerometer_x, accelerometer_y, accelerometer_z);
                dataList.add(model);

                cursor.moveToNext();
            }
        }
        cursor.close(); // Closing cursor for memory leak
        accelerometerDataList = new MutableLiveData<>(dataList);  // Initializing proximityDataList
        accelerometerDataList.setValue(dataList); // Setting value
        return accelerometerDataList;
    }

    public MutableLiveData<List<GyroscopeSenModel>> getAllGyroscopeData(){
        List<GyroscopeSenModel> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COL_DATE_TIME +", "+COL_GYROSCOPE_X+", "+COL_GYROSCOPE_Y+", "+COL_GYROSCOPE_Z+" FROM SensorTable";
        Cursor cursor = db.rawQuery(query, null);  // Getting the cursor
        cursor.moveToFirst();       // Moving cursor to the first
        if(cursor != null){
            while(cursor.isAfterLast() == false){
                String DateTime = cursor.getString(0);
                String gyroscope_x = cursor.getString(1);
                String gyroscope_y = cursor.getString(2);
                String gyroscope_z = cursor.getString(3);

                GyroscopeSenModel model = new GyroscopeSenModel(DateTime, gyroscope_x, gyroscope_y, gyroscope_z);
                dataList.add(model);

                cursor.moveToNext();
            }
        }
        cursor.close(); // Closing cursor for memory leak
        gyroscopeDataList = new MutableLiveData<>(dataList);  // Initializing proximityDataList
        gyroscopeDataList.setValue(dataList); // Setting value
        return gyroscopeDataList;
    }
    public MutableLiveData<SensorDataModel> getSensorData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" order by ID DESC limit 1";
        Cursor cursor = db.rawQuery(query, null);  // Getting the cursor
        cursor.moveToFirst();       // Moving cursor to the first
        SensorDataModel model = null;
        if(cursor != null && cursor.moveToFirst()){
                String dateTime = cursor.getString(1);
                String light = cursor.getString(2);
                String proximity = cursor.getString(3);
                String accelerometer_x = cursor.getString(4);
                String accelerometer_y = cursor.getString(5);
                String accelerometer_z = cursor.getString(6);
                String gyroscope_x = cursor.getString(7);
                String gyroscope_y = cursor.getString(8);
                String gyroscope_z = cursor.getString(9);

                model = new SensorDataModel(dateTime, light, proximity, accelerometer_x, accelerometer_y, accelerometer_z, gyroscope_x, gyroscope_y, gyroscope_z);
        }else{
            //Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
            cursor.close(); // Closing cursor for memory leak
            return null;
        }
        sensorData = new MutableLiveData<>(model);  // Initializing proximityDataList
        sensorData.setValue(model); // Setting value
        return sensorData;
    }
}
