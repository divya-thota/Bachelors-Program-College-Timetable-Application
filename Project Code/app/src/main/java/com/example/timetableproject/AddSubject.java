package com.example.timetableproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSubject extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject);

        Button b1=(Button)findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText E = (EditText) findViewById(R.id.subject_name);
                String subject = E.getText().toString();
                EditText M1 = (EditText) findViewById(R.id.mod1);
                String mod1=M1.getText().toString();
                EditText M2 = (EditText) findViewById(R.id.mod2);
                String mod2=M2.getText().toString();
                EditText M3 = (EditText) findViewById(R.id.mod3);
                String mod3=M3.getText().toString();
                EditText M4 = (EditText) findViewById(R.id.mod4);
                String mod4=M4.getText().toString();
                EditText M5 = (EditText) findViewById(R.id.mod5);
                String mod5=M5.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("Sub", subject);
                intent.putExtra("mod1", mod1);
                intent.putExtra("mod2", mod2);
                intent.putExtra("mod3", mod3);
                intent.putExtra("mod4", mod4);
                intent.putExtra("mod5", mod5);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
