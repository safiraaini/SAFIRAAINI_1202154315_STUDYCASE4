package com.example.safiraaini.safira_1202154315_studycase4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

//membuat variabel yang akan dideklarasikan pada class ImageActivity
public class ImageActivity extends AppCompatActivity {
    ImageView img;
    EditText source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        setTitle("AsyncTask"); //set judul pada tampilan

        //menghubungkan variabel yang ada pada layout
        img = (ImageView)findViewById(R.id.pic);
        source = (EditText)findViewById(R.id.tvurl);
    }


//ketika tombol search ditekan akan mengeksekusi fitue picasso yang terdapat pada gradle build dan manifest
    public void search(View view) {
        Picasso.with(ImageActivity.this).load(source.getText().toString())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(img);
    }
}
