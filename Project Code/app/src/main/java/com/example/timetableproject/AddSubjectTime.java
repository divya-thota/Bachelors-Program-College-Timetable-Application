package com.example.timetableproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSubjectTime extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject_time);

        Button b1=(Button)findViewById(R.id.submit1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText E = (EditText) findViewById(R.id.subjects_name);
                String subject = E.getText().toString();
                EditText M1 = (EditText) findViewById(R.id.time);
                String time=M1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("Sub", subject);
                intent.putExtra("time", time);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
