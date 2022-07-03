package com.example.timetableproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Syllabus extends Fragment {
    String mod1,mod2,mod3,mod4,mod5;
    View myView;
    int REC_CODE=1;
    ArrayAdapter<String> listViewAdapter;
    ArrayList<String> Subjects= new ArrayList<String>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.syllabus,container,false);

        FloatingActionButton fab = myView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myView.getContext(), AddSubject.class);
                startActivityForResult(intent,REC_CODE);
            }
        });

        ListView lv=myView.findViewById(R.id.sub_list);
        registerForContextMenu(lv);
        listViewAdapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Subjects);
        lv.setAdapter(listViewAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent5=new Intent(myView.getContext(),Displaysyllabus.class);
                startActivity(intent5);
            }
        });
        return myView;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.delete_subject,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch(item.getItemId()) {
            case R.id.delsub: Subjects.remove(info.position);
                listViewAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String subjectname=data.getStringExtra("Sub");
        if(Subjects.contains(subjectname)){
            Toast.makeText(getContext(),"Subject already exists",Toast.LENGTH_LONG).show();
        }
        else{
            Subjects.add(subjectname);
        }
    }
}