package com.cookandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트 뷰테스트 ");

        final String[] mid ={"히어로즈","24시","로스트","로스트룸","스몰빌","탐정몽크","빅뱅이론","프렌즈","글리","가수비걸","테이큰","가","나","다"};
        ListView list =(ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mid);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(),mid[arg2],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
