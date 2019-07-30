package com.cookandroid.ex15;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
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

        mgr = (SensorManager) getSystemService(SENSOR_SERVICE);

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
