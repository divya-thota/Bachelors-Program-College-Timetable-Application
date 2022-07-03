package com.example.timetableproject;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddFaculty extends AppCompatActivity {
    ImageView faculty;
    private static final int RESULT_IMAGE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_faculty);

        faculty = (ImageView) findViewById(R.id.fac_image);
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, RESULT_IMAGE);
            }
        });

        Button b2 = (Button) findViewById(R.id.submitfac);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText E = (EditText) findViewById(R.id.fname);
                String fname = E.getText().toString();
                EditText M1 = (EditText) findViewById(R.id.mname);
                String mname= M1.getText().toString();
                EditText M2 = (EditText) findViewById(R.id.lname);
                String lname= M2.getText().toString();
                String faculty=fname+" "+mname+" "+lname;
                EditText M3 = (EditText) findViewById(R.id.phno);
                String phno = M3.getText().toString();
                EditText M4 = (EditText) findViewById(R.id.email);
                String email = M4.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("fac", faculty);
                intent.putExtra("phno", phno);
                intent.putExtra("email", email);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            faculty.setImageURI(selectedImage);
        }
    }
}

