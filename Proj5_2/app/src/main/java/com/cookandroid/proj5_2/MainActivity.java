package com.cookandroid.proj5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /*EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    int i;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex05_19);
    }
}
/*
        setTitle("테이블 아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과:" + result.toString());
                return false;
            }

        });
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과:" + result.toString());
                return false;
            }

        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과:" + result.toString());
                return false;
            }

        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과:" + result.toString());
                return false;
            }

        });
        for (i = 0; i < numBtnIDs.length; i++){
            numButtons[i] =(Button) findViewById(numBtnIDs[i]);
        }
        for (i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;



            numButtons[index].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}*/

    /*    LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        final LinearLayout baseLayout =new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout,params);

        final EditText edt =new EditText(this);
        final TextView tex =new TextView(this);
        Button btn =new Button(this);

        btn.setText("버튼입니다.");
        btn.setBackgroundColor(Color.YELLOW);

        baseLayout.addView(edt);
        baseLayout.addView(btn);
        baseLayout.addView(tex);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"코드로 생성한 버튼입니다",Toast.LENGTH_SHORT).show();
                tex.setText(edt.getText());
            }

        });*/

        //   setContentView(R.layout.activity_main);

        //setContentView(R.layout.ex05_01);
      /*  setContentView(R.layout.ex05_02);
        setContentView(R.layout.ex05_03);
        setContentView(R.layout.ex05_04);
        setContentView(R.layout.ex05_05);
        setContentView(R.layout.ex05_06);
        setContentView(R.layout.ex05_07);
        setContentView(R.layout.ex05_10);
        setContentView(R.layout.ex05_11);
        setContentView(R.layout.ex05_12);
        setContentView(R.layout.ex05_13);

        setContentView(R.layout.ex05_18);
        */
        //setContentView(R.layout.ex05_19);

      // setContentView(R.layout.ex05_14);
       // setContentView(R.layout.ex05_20);
      //  setContentView(R.layout.ex05_22);



