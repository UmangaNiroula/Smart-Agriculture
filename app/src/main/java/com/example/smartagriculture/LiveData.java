package com.example.smartagriculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LiveData extends AppCompatActivity {

    ImageView backLive;
    FirebaseDatabase database;
    DatabaseReference reference, refTemp,refHumi, refMois, refTime;
    TextView timeData1,timeData2,timeData3,timeData4,timeData5,timeData6,timeData7, timeData8,timeData9;
    TextView temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8, temp9,dateLive;
    TextView humidity1,humidity2,humidity3,humidity4,humidity5,humidity6,humidity7, humidity8, humidity9;
    TextView moisture1,moisture2,moisture3,moisture4,moisture5,moisture6,moisture7, moisture8,moisture9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        backLive = findViewById(R.id.backLive);

        timeData1 = findViewById(R.id.timeData1);
        timeData2 = findViewById(R.id.timeData2);
        timeData3 = findViewById(R.id.timeData3);
        timeData4 = findViewById(R.id.timeData4);
        timeData5 = findViewById(R.id.timeData5);
        timeData6 = findViewById(R.id.timeData6);
        timeData7 = findViewById(R.id.timeData7);
        timeData8 = findViewById(R.id.timeData8);
        timeData9 = findViewById(R.id.timeData9);

        temp1 = findViewById(R.id.temp1);
        temp2 = findViewById(R.id.temp2);
        temp3 = findViewById(R.id.temp3);
        temp4 = findViewById(R.id.temp4);
        temp5 = findViewById(R.id.temp5);
        temp6 = findViewById(R.id.temp6);
        temp7 = findViewById(R.id.temp7);
        temp8 = findViewById(R.id.temp8);
        temp9 = findViewById(R.id.temp9);

        moisture1 = findViewById(R.id.moisture1);
        moisture2 = findViewById(R.id.moisture2);
        moisture3 = findViewById(R.id.moisture3);
        moisture4 = findViewById(R.id.moisture4);
        moisture5 = findViewById(R.id.moisture5);
        moisture6 = findViewById(R.id.moisture6);
        moisture7 = findViewById(R.id.moisture7);
        moisture8 = findViewById(R.id.moisture8);
        moisture9 = findViewById(R.id.moisture9);

        humidity1 = findViewById(R.id.humidity1);
        humidity2 = findViewById(R.id.humidity2);
        humidity3 = findViewById(R.id.humidity3);
        humidity4 = findViewById(R.id.humidity4);
        humidity5 = findViewById(R.id.humidity5);
        humidity6 = findViewById(R.id.humidity6);
        humidity7 = findViewById(R.id.humidity7);
        humidity8 = findViewById(R.id.humidity8);
        humidity9 = findViewById(R.id.humidity9);

        dateLive = findViewById(R.id.dateLive);
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("EEEE, dd");
        String databaseTime = format.format(calendar.getTime());
        dateLive.setText(databaseTime);
        
        
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("live");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long countValue = snapshot.getChildrenCount();
                Log.d("sjjsjs", ""+countValue);
                for (int i = 1; i<=countValue; i++)
                {
                    refTemp = reference.child("data"+i).child("Temperature");

                    int finalI = i;
                    refTemp.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);

                            if(finalI==1)
                                temp1.setText(value+"°C");
                            else if(finalI==2)
                                temp2.setText(value+"°C");
                            else if(finalI==3)
                                temp3.setText(value+"°C");
                            else if(finalI==4)
                                temp4.setText(value+"°C");
                            else if(finalI==5)
                                temp5.setText(value+"°C");
                            else if(finalI==6)
                                temp6.setText(value+"°C");
                            else if(finalI==7)
                                temp7.setText(value+"°C");
                            else if(finalI==8)
                                temp8.setText(value+"°C");
                            else if(finalI==9)
                                temp9.setText(value+"°C");
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    refHumi = reference.child("data"+i).child("Humidity");
                    refHumi.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);

                            if(finalI==1) {
                                humidity1.setText(value + "%");

                            }
                            else if(finalI==2) {
                                humidity2.setText(value + "%");
                            }
                            else if(finalI==3) {
                                humidity3.setText(value + "%");
                            }
                            else if(finalI==4) {
                                humidity4.setText(value + "%");
                            }
                            else if(finalI==5) {
                                humidity5.setText(value + "%");
                            }
                            else if(finalI==6) {
                                humidity6.setText(value + "%");
                            }
                            else if(finalI==7) {
                                humidity7.setText(value + "%");
                            }
                            else if(finalI==8) {
                                humidity8.setText(value + "%");
                            }
                            else if(finalI==9) {
                                humidity9.setText(value + "%");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                    refMois = reference.child("data"+i).child("Moisture");

                    refMois.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);

                            if(finalI==1)
                                moisture1.setText(value+" θfc");
                            else if(finalI==2)
                                moisture2.setText(value+" θfc");
                            else if(finalI==3)
                                moisture3.setText(value+" θfc");
                            else if(finalI==4)
                                moisture4.setText(value+" θfc");
                            else if(finalI==5)
                                moisture5.setText(value+" θfc");
                            else if(finalI==6)
                                moisture6.setText(value+" θfc");
                            else if(finalI==7)
                                moisture7.setText(value+" θfc");
                            else if(finalI==8)
                                moisture8.setText(value+" θfc");
                            else if(finalI==9)
                                moisture9.setText(value+" θfc");
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    refTime = reference.child("data"+i).child("Time");

                    refTime.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue(String.class);

                            if(finalI==1)
                                timeData1.setText(value+":00 AM");
                            else if(finalI==2)
                                timeData2.setText(value+":01 AM");
                            else if(finalI==3)
                                timeData3.setText(value+":05 AM");
                            else if(finalI==4)
                                timeData4.setText(value+":11 AM");
                            else if(finalI==5)
                                timeData5.setText(value+":15 AM");
                            else if(finalI==6)
                                timeData6.setText(value+":18 AM");
                            else if(finalI==7)
                                timeData7.setText(value+":19 AM");
                            else if(finalI==8)
                                timeData8.setText(value+":20 AM");
                            else if(finalI==9)
                                timeData9.setText(value+":22 AM");
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

        backLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveData.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}