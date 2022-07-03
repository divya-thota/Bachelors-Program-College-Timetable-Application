package com.example.timetableproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Displaysyllabus extends AppCompatActivity {

    TextView mod1,mod2,mod3,mod4,mod5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_syllabus);
        mod1=(TextView)findViewById(R.id.module1);
        mod2=(TextView)findViewById(R.id.module2);
        mod3=(TextView)findViewById(R.id.module3);
        mod4=(TextView)findViewById(R.id.module4);
        mod5=(TextView)findViewById(R.id.module5);
    }
    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String data1,data2,data3,data4,data5;
        data1=data.getStringExtra("mod1");
        data2=data.getStringExtra("mod2");
        data3=data.getStringExtra("mod3");
        data4=data.getStringExtra("mod4");
        data5=data.getStringExtra("mod5");
        mod1.setText(data1);
        mod2.setText(data2);
        mod3.setText(data3);
        mod4.setText(data4);
        mod5.setText(data5);
    }*/
}
