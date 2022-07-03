package com.example.timetableproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Saturday extends AppCompatActivity{
    ArrayList<String> Saturdaysubjects= new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int R_CODE=3;
        setContentView(R.layout.saturday);
        ArrayAdapter<String> listViewAdapter;

        FloatingActionButton fab = findViewById(R.id.fabsaturday);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Saturday.this, AddSubjectTime.class);
                startActivityForResult(intent,R_CODE);
            }
        });
        ListView lv=findViewById(R.id.saturday_list);
        registerForContextMenu(lv);
        listViewAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Saturdaysubjects);
        lv.setAdapter(listViewAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String Data1=data.getStringExtra("Sub");
        String Data2=data.getStringExtra("time");
        String Data=Data1+"                                                         "+Data2;
        Saturdaysubjects.add(Data);
    }
}
