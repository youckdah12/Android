package com.cookandroid.project7_03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String[] versionArray = new String[]{"진저브레드", "허니콤보", "아이스크림"
                };
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.drawable.ic_launcher);
                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button1.setText(versionArray[i]);
                    }
                });
                dlg.setPositiveButton("닫기", null);
                dlg.show();

            }
        });
/*

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final Button button1 = (Button) findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    final String[] versionArray=new String[]{"진저브레드","허니콤보","아이스크림"
                    };
                    AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("좋아하는 버전은?");
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setItems(versionArray,0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            button1.setText(versionArray[i]);
                        }
                    });
                    dlg.setPositiveButton("닫기",null);
                    dlg.show();

                }
            });

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                final Button button1 = (Button) findViewById(R.id.button1);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        final String[] versionArray=new String[]{"진저브레드","허니콤보","아이스크림"
                        };
                        final boolean[] checkArry =new boolean[] {true,false ,false};
                        AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("좋아하는 버전은?");
                        dlg.setIcon(R.drawable.ic_launcher);
                        dlg.setItems(versionArray,checkArray, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                button1.setText(versionArray[i]);
                            }
                        });
                        dlg.setPositiveButton("닫기",null);
                        dlg.show();

                    }
                });

*/

    }
}
