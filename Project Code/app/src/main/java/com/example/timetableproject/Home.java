package com.example.timetableproject;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class Home extends Fragment {
    View myView;

    ArrayAdapter<String> listViewAdapter;
    ArrayList<String> Days= new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.home,container,false);
        Days.add("Monday");
        Days.add("Tuesday");
        Days.add("Wednesday");
        Days.add("Thursday");
        Days.add("Friday");
        Days.add("Saturday");
        Days.add("Sunday");
        ListView lv=myView.findViewById(R.id.day_list);
        registerForContextMenu(lv);
        listViewAdapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Days);
        lv.setAdapter(listViewAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0: Intent monday=new Intent(myView.getContext(),Monday.class);
                            startActivity(monday);
                            break;
                    case 1: Intent tuesday=new Intent(myView.getContext(),Tuesday.class);
                            startActivity(tuesday);
                            break;
                    case 2: Intent Wednesday=new Intent(myView.getContext(),Wednesday.class);
                            startActivity(Wednesday);
                            break;
                    case 3: Intent Thursday=new Intent(myView.getContext(),Thursday.class);
                            startActivity(Thursday);
                            break;
                    case 4: Intent Friday=new Intent(myView.getContext(),Friday.class);
                            startActivity(Friday);
                            break;
                    case 5: Intent Saturday=new Intent(myView.getContext(),Saturday.class);
                            startActivity(Saturday);
                            break;
                }
            }
        });
        super.onCreate(savedInstanceState);
        return myView;
    }

}

