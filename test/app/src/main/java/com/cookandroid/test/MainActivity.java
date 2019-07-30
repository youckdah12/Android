package com.cookandroid.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {
    EditText edt01,edt02,edt03;
    Button btnOk,btnRandom;
    TextView textView1,textView2;
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt01=(EditText) findViewById(R.id.edt01);
        edt02=(EditText) findViewById(R.id.edt02);
        edt03=(EditText) findViewById(R.id.edt03);

        btnOk=(Button) findViewById(R.id.btnOK);
        btnRandom=(Button) findViewById(R.id.btnRandom);

        textView1=(TextView) findViewById(R.id.textView1);
        textView2=(TextView) findViewById(R.id.textView2);
        list1=(ListView) findViewById(R.id.list1);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int rand1 = new Random().nextInt(8)+2;
                int rand2 = new Random().nextInt(8)+2;
                edt01.setText(String.valueOf(rand1));
                edt02.setText(String.valueOf(rand2));

            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str1 = edt01.getText().toString();
                String str2 = edt02.getText().toString();
                String str3 = edt03.getText().toString();

                int a1 =Integer.parseInt(str1);
                int a2 =Integer.parseInt(str2);
                int a3 =Integer.parseInt(str3);

                int a4 =a1 * a2;

                if (a3==a4)
                {
                    Toast.makeText(MainActivity.this,"정답입니다!",Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        Toast.makeText(MainActivity.this,"틀렸습니다!",Toast.LENGTH_SHORT).show();

                        String [] values =new String[9];

                        for (int i=0; i<9; ++i){
                            values[i] =String.valueOf(a1) +"X"+(i+1)+"="+(a1*(i+1));

                    }
                        ArrayAdapter<String> adapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,values);
                        list1.setAdapter(adapter);
                }

            }
        });


    }



}
