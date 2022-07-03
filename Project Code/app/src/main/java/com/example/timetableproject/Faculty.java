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

public class Faculty extends Fragment {
    View myView;
    int CODE=1;
    ArrayAdapter<String> listViewAdapter;
    ArrayList<String> Faculty= new ArrayList<String>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.faculty,container,false);

        FloatingActionButton fab = myView.findViewById(R.id.fabf);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myView.getContext(), AddFaculty.class);
                startActivityForResult(intent,CODE);
            }
        });

        ListView lv=myView.findViewById(R.id.fac_list);
        registerForContextMenu(lv);
        listViewAdapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Faculty);
        lv.setAdapter(listViewAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent5=new Intent(myView.getContext(),DisplayFaculty.class);
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
            case R.id.delsub: Faculty.remove(info.position);
                listViewAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String Data=data.getStringExtra("fac");
        if(Faculty.contains(Data)){
            Toast.makeText(getContext(),"Faculty already exists",Toast.LENGTH_LONG).show();
        }
        else{
            Faculty.add(Data);
        }
    }
}
