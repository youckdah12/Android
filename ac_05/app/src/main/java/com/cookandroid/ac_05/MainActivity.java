package com.cookandroid.ac_05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("임시적 인텐트 예제");

        Button btnDial=(Button) findViewById(R.id.btnDial);
        Button btnWeb=(Button) findViewById(R.id.btnWeb);
        Button btnGoogle=(Button) findViewById(R.id.btnGoogle);
        Button btnSearch=(Button) findViewById(R.id.btnSearch);
        Button btnSms=(Button) findViewById(R.id.btnSms);
        Button btnPhoto=(Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("tel:010-1234-5678");
                Intent intent =new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("http://www.hanb.co.kr");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("geo:37.5543,126.9135");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"안드로이드");
                startActivity(intent);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.putExtra("sms_body","안녕하세요?");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);

                Uri uri= Uri.fromFile(new File("/sdcard/jeju13.jpg"));
                intent.setDataAndType(uri,"image/jpeg");
                startActivity(intent);
            }
        });
    }
}
