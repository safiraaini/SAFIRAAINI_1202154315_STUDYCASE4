package com.example.safiraaini.safira_1202154315_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("AsyncTask"); //set judul tampilan
    }

    //intent yang menghubungkan dengan class StudentActivity
    public void student(View view) {
        Intent i = new Intent(this, StudentActivity.class);
        startActivity(i);

    }

//intent yang menghubungkan dengan class ImageActivity
    public void image(View view) {
        Intent i = new Intent(this, ImageActivity.class);
        startActivity(i);
    }
}
