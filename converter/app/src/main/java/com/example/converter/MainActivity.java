package com.example.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edt;
TextView textView;
Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 =(Button) findViewById(R.id.button1);
        btn2 =(Button) findViewById(R.id.button2);
        btn3=(Button) findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        edt=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float tmp,res;
                tmp = Float.parseFloat(edt.getText().toString());
                res= tmp*9/5+32;
                textView.setText(res+"");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float tmp,res;
                tmp =Float.parseFloat(edt.getText().toString());
                res =(tmp-32)*5/9;
                textView.setText(res+"");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float tem,res;
                tem=Float.parseFloat(edt.getText().toString());
                res=tem*10;
                textView.setText(res+"");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float tmp,res;
                tmp=Float.parseFloat(edt.getText().toString());
                res=tmp/1000;
                textView.setText(res+"");
            }
        });
    }
}
