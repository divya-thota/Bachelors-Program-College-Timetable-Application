package com.example.timetableproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class COE extends Fragment implements View.OnClickListener{
    View myView;
    ImageView coe;
    private static final int RESULT_LOAD_IMAGE=1;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.coe,container,false);
       coe=(ImageView)myView.findViewById(R.id.coe_image);
       coe.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View view) {
        Intent gallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery,RESULT_LOAD_IMAGE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode== Activity.RESULT_OK && data!=null) {
            Uri selectedImage = data.getData();
            coe.setImageURI(selectedImage);
        }
    }
}
