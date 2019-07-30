package com.cookandroid.sb_01;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    MyReceiver myReceiver = null;
    TextView tvText;

    Intent i;
    static final String LOG_TAG ="ServiceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText = findViewById(R.id.tvText);

        i = new Intent(this,SimpleService.class);
        Log.d(LOG_TAG,"onCreate/startService");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume/registering receiver");
        myReceiver = new MyReceiver(tvText);
        IntentFilter filter =new IntentFilter();
        filter.addAction(SimpleService.MY_ACTION);
        registerReceiver(myReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause/unregistering receiver");
        stopService(i);

        if (myReceiver !=null){
            unregisterReceiver(myReceiver);
            myReceiver =null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
        if (myReceiver !=null){
            unregisterReceiver(myReceiver);
            myReceiver =null;
        }
        stopService(i);
    }

    public void btnClick(View v) {
        if (v.getId() == R.id.btnPrint) {
            startService(i);
        }
        else if (v.getId() == R.id.btnClose) {
            stopService(i);
        }
    }
}
