package com.example.timetableproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Friday extends AppCompatActivity{
    ArrayList<String> Fridaysubjects= new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int R_CODE=3;
        setContentView(R.layout.friday);
        ArrayAdapter<String> listViewAdapter;

        FloatingActionButton fab = findViewById(R.id.fabfriday);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friday.this, AddSubjectTime.class);
                startActivityForResult(intent,R_CODE);
            }
        });
        ListView lv=findViewById(R.id.friday_list);
        registerForContextMenu(lv);
        listViewAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Fridaysubjects);
        lv.setAdapter(listViewAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String Data1=data.getStringExtra("Sub");
        String Data2=data.getStringExtra("time");
        String Data=Data1+"                                                         "+Data2;
        Fridaysubjects.add(Data);
    }
}
