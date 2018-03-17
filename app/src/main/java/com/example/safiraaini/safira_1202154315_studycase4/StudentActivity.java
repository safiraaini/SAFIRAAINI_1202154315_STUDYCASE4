package com.example.safiraaini.safira_1202154315_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

//membuat variabel pada class StudentActivity
public class StudentActivity extends AppCompatActivity {
    ListView listStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        setTitle("AsyncTask"); //set judul pada tampilan
        listStd = (ListView) findViewById(R.id.listStudent); //menghubungkan variabel dengan yang ada di layout
    }

    //memulai loading data dan mengeksekusi listview dengan menggunakan adapter
    public void start(View view) {new getData(listStd).execute();}
        class getData extends AsyncTask<String, Integer, String> {
            ListView listStd;
            ArrayAdapter adapter;
            ArrayList<String> listNm;
            ProgressDialog dialog;

            //menginisiasi constructor saat asynctask
            public getData(ListView listMhs) {
                this.listStd = listMhs;
                dialog = new ProgressDialog(StudentActivity.this);
                listNm = new ArrayList<>();
            }

            //method ketika proses asynctask belum dimulai atau belum dieksekusi
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //menampilkan proses dialog
                dialog.setTitle("Data Loading");
                dialog.setIndeterminate(true);
                dialog.setProgress(0); //nilai minimum loading dalam bentuk persentase
                dialog.setMax(100); //nilai maksimum loading dalam bentuk persentase
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setCancelable(true); //untuk membatalkan proses
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                        getData.this.cancel(true);
                    }
                });

                dialog.show();
            }

            //method yang digunakan saat menjalankan proses asynctask
            @Override
            protected String doInBackground(String... strings) {
                adapter = new ArrayAdapter<>(StudentActivity.this, android.R.layout.simple_list_item_1, listNm); //membuat adapter

                //menyimpan array pada sebuah variabel
                String[] std = getResources().getStringArray(R.array.namaStd);
                //perulangan untuk melakukan penyimpanan array
                for (int a = 0; a < std.length; a++) {
                    final long persen = 100L * a / std.length;
                    final String nama = std[a];
                    try {
                        Runnable change = new Runnable() {
                            @Override
                            public void run() {
                                dialog.setMessage((int) persen + "% - Adding " + nama);
                            }
                        };
                        runOnUiThread(change);
                        Thread.sleep(300);
                        listNm.add(std[a]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            //method setelah asynctask dijalankan
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                listStd.setAdapter(adapter);
                dialog.dismiss();
            }
        }

}