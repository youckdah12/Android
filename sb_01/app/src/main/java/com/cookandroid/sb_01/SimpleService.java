package com.cookandroid.sb_01;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class SimpleService extends Service implements SensorEventListener {
    final static String MY_ACTION ="com.cookandroid.sb_01.SimpleServer.MY_ACTOIN";
    private TextView output;
    private String reading;
    private SensorManager mgr;
    private List<Sensor> sensorList;
    static final String LOG_TAG ="SimpleService";
    Intent intent =new Intent("com.cookandroid.sb_01.SimpleServer.MY_ACTOIN");


    @Override
    public void onCreate() {
        Log.d(LOG_TAG,"onStartCommand");
        mgr= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = mgr.getSensorList(Sensor.TYPE_ACCELEROMETER);
        for (Sensor sensor: sensorList){
            mgr.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG,"onDestroy");
        mgr.unregisterListener(this);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(LOG_TAG,"onSensorChanged");
        StringBuilder builder =new StringBuilder();

        for (int i =0;i<sensorEvent.values.length; i++){
            builder.append(" [");
            builder.append(i);
            builder.append("] = ");
            builder.append(sensorEvent.values[i]);
            builder.append("\n");
        }

        reading=builder.toString();

        intent.putExtra("measurement",reading);
        sendBroadcast(intent);
    }
}
