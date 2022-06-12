package com.example.smartagriculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Dashboard extends AppCompatActivity {

    private TextView dateDashboard,lastDataTrasnmit;
    private String dateValue;
    private CardView tempLog, moisLog, humiLog, addCrops,costEst, liveData;
    Button startAnalysis;

    FirebaseDatabase db;
    DatabaseReference reference, re;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Initializing views
        dateDashboard = findViewById(R.id.dateDashboard);
        lastDataTrasnmit = findViewById(R.id.lastDataTrasnmit);

        tempLog = findViewById(R.id.tempLog);
        moisLog = findViewById(R.id.moisLog);
        humiLog = findViewById(R.id.humiLog);
        addCrops = findViewById(R.id.addCrops);
        costEst = findViewById(R.id.costEst);
        liveData = findViewById(R.id.liveData);
        startAnalysis = findViewById(R.id.startAnalysis);



        db = FirebaseDatabase.getInstance();
        reference = db.getReference("sensor");
        re = db.getReference().child("start");

        transactionValueFetch();

        setCalendarValue();

        intentActivityRun();
    }

    private void setCalendarValue()
    {
        //Code for showing the current Date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd");
        dateValue = dateFormat.format(calendar.getTime());


        //Adding functionality to View
        dateDashboard.setText(dateValue);
    }

    private void transactionValueFetch()
    {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long index = snapshot.getChildrenCount();

                DatabaseReference lastTransaction = reference.child("data"+index).child("Time");

                lastTransaction.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String time = snapshot.getValue(String.class);
                        lastDataTrasnmit.setText("Last Transaction Time: "+time);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void intentActivityRun()
    {
        addCrops.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, AddCrop.class);
            startActivity(intent);
        });
        tempLog.setOnClickListener(view ->
        {
            Intent intent = new Intent(Dashboard.this, Temperature.class);
            startActivity(intent);
        });

        humiLog.setOnClickListener(view ->
        {
            Intent intent = new Intent(Dashboard.this, Humidity.class);
            startActivity(intent);
        });

        moisLog.setOnClickListener(view ->
        {
            Intent intent = new Intent(Dashboard.this, Moisture.class);
            startActivity(intent);
        });

        costEst.setOnClickListener(view ->
        {
            Intent intent = new Intent(Dashboard.this, CostEstimation.class);
            startActivity(intent);
        });

        liveData.setOnClickListener(view ->
        {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));

            re.setValue(generatedString);
            Intent intent = new Intent(Dashboard.this, LiveData.class);
            startActivity(intent);



        });

        startAnalysis.setOnClickListener(view ->
        {
            Intent intent = new Intent(Dashboard.this, Analysis.class);
            startActivity(intent);
        });
    }


}