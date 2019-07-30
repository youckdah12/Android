package com.cookandroid.sb_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;



public class MyReceiver extends BroadcastReceiver {
    static  final String LOG_TAG="MyReceiver";
    private TextView tvText;

    public MyReceiver(TextView tvText) {
        this.tvText = tvText;
    }

    @Override
    public void onReceive(Context arg0, Intent arg1) {

        String measurement = arg1.getStringExtra("measurement");
        Log.d(LOG_TAG,"onReceive"+measurement);
        Toast.makeText(arg0,""+measurement, Toast.LENGTH_SHORT).show();

        tvText.setText(""+measurement);
    }
}
