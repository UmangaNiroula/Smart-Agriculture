package com.example.smartagriculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Analysis extends AppCompatActivity {

    ProgressBar myprogressBar;
    ImageView backCrops;
    TextView progressingTextView;

    Button weekBtn, monthBtn,yearBtn;
    TextView tempDigit,tempStatus, moisDigit, moisStatus,humiDigit, humiStatus ;

    FirebaseDatabase db;
    DatabaseReference ref;


    Handler progressHandler = new Handler();
    int i = 0;

    int totalTemp = 0, avgTemp, greatTemp;
    float totalMois = 0, avgMois, greatMois;
    int totalHumi = 0, avgHumi, greatHumi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        myprogressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressingTextView = (TextView) findViewById(R.id.progress_circle_text);
        weekBtn = findViewById(R.id.weekBtn);
        monthBtn = findViewById(R.id.monthBtn);
        yearBtn = findViewById(R.id.yearBtn);
        tempDigit = findViewById(R.id.tempDigit);
        tempStatus = findViewById(R.id.tempStatus);
        moisDigit = findViewById(R.id.moisDigit);
        moisStatus = findViewById(R.id.moisStatus);
        humiDigit = findViewById(R.id.humiDigit);
        humiStatus = findViewById(R.id.humiStatus);
        backCrops = findViewById(R.id.backCrops);

        backCrops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Analysis.this, Dashboard.class));
            }
        });

        db = FirebaseDatabase.getInstance();
        ref = db.getReference("sensor");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long count = snapshot.getChildrenCount();

                for (int i = 0; i<7; i++)
                {
                    DatabaseReference newRef = ref.child("data"+(count-i)).child("Temperature");
                    newRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);
                            int change = Integer.parseInt(value);

                            totalTemp = totalTemp +change;
                            avgTemp = totalTemp/6;
                            tempDigit.setText(""+avgTemp);

                            if (avgTemp>=25 && avgTemp<29)
                            {
                                tempStatus.setText("Optimum");
                                greatTemp=1;
                            }
                            else if(avgTemp>=29)
                            {
                                tempStatus.setText("Danger, use more water");
                                greatTemp=2;
                            }
                            else if(avgTemp>=10 & avgTemp<25)
                            {
                                tempStatus.setText("Low, crop may be damaged");
                                greatTemp=0;
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    DatabaseReference newRef1 = ref.child("data"+(count-i)).child("Humidity");

                    newRef1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {//overriding an implemented method
                            //reading live data from firebase real-time database through data snapshots
                                String value = snapshot.getValue(String.class);

                            int change = Integer.parseInt(value);

                            totalHumi = totalHumi +change;
                            avgHumi = totalHumi/6;
                            humiDigit.setText(""+avgHumi);

                            if (avgHumi>=65 && avgHumi<85)
                            {
                                humiStatus.setText("Optimum");
                                greatHumi= 1;
                            }
                            else if(avgHumi>=85)
                            {
                                humiStatus.setText("Danger, reduce water useage");
                                greatHumi= 2;
                            }
                            else if(avgHumi>=35 & avgHumi<85)
                            {
                                humiStatus.setText("Low, increase water useage");
                                greatHumi = 0;
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    DatabaseReference newRef2 = ref.child("data"+(count-i)).child("Moisture");
                    newRef2.addValueEventListener(new ValueEventListener()
                    {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);
                            float change = Float.parseFloat(value);

                            //Log.d("txxz", value);
                            totalMois = totalMois +change;
                            //Log.d("jjxw", ""+totalHumi);
                            avgMois = totalMois/6;

                            int changeAgain = (int) avgMois;
                            // Log.d("zzxe", ""+avgHumi);
                            moisDigit.setText(""+changeAgain+".00");


                            if (changeAgain>=300 && changeAgain<700)
                            {
                                moisStatus.setText("Optimum");
                                greatMois =1;
                            }
                            else if(changeAgain>=700)
                            {
                                moisStatus.setText("Danger, reduce irrigation");
                                greatMois=2;
                            }
                            else if(changeAgain>=0 & changeAgain<300)
                            {
                                moisStatus.setText("Low, increase irrigation");
                                greatMois=0;
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        new Thread(new Runnable() {
            public void run() {
                int value =98;

                while (i < value) {
                    i += 2;
                    progressHandler.post(new Runnable() {
                        public void run() {
                            myprogressBar.setProgress(i);
                            progressingTextView.setText("" + i + " %");
                        }
                    });
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}