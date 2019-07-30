package com.cookandroid.ss_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_TYPE_INBOX = "1";
    private static final String MESSAGE_TYPE_SENT = "2";
    private static final String MESSAGE_TYPE_CONVERSATIONS = "3";
    private static final String MESSAGE_TYPE_NEW = "new";
    ArrayAdapter<String> adapter;
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = findViewById(R.id.list1);
    }

    public void btnClick(View v) {
        getSmsList();
    }

    public void getSmsList(){
        try {
            Uri allMessage = Uri.parse("content://sms/");
            this.grantUriPermission("com.cookandroid.ss_02", allMessage, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Cursor cur = this.getContentResolver().query(allMessage, null, null, null, null);
            int count = cur.getCount();
            System.out.println(count);

            String row="";
            String msg="";
            String date="";
            String protocol="";
            ArrayList<String> aa = new ArrayList<String>();

            while (cur.moveToNext()){
                row=cur.getString(cur.getColumnIndex("address"));
                msg=cur.getString(cur.getColumnIndex("body"));
                date=cur.getString(cur.getColumnIndex("date"));

                protocol =cur.getString(cur.getColumnIndex("protocol"));
                String type="";
                if(protocol==MESSAGE_TYPE_SENT) type="이미보낸메세지";
                else if(protocol==MESSAGE_TYPE_INBOX) type="받은메세지";
                else if(protocol==MESSAGE_TYPE_CONVERSATIONS) type="conversations";
                else if(protocol==null) type="보낸메세지";
                else type="AVD셀프";

                long ldate = Long.parseLong(date);
                Date date1 = new Date(ldate);
                SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String to = transFormat.format(date1);

                aa.add("타입: " + type +"\n전화번호 :" + row +"\n내용:" + msg + "\n시간:" + to);
                Toast.makeText(this,"타입:"+type+"/전화번호:"+row+"/내용:"+msg+"/시간:"+date,Toast.LENGTH_SHORT).show();
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aa);
            }
            list1.setAdapter(adapter);
            cur.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void SMSDelete(){
         Uri deleteUri=Uri.parse("content://sms");
         int count =0;
         Cursor c =this.getContentResolver().query(deleteUri,null,null,null,null);
         while(c.moveToNext()){
             try {
                 String pid =c.getString(0);
                 String uri ="content://sms/"+pid;
             }catch (Exception e){

             }
        }
    }

}
