package com.example.smartagriculture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCrop extends AppCompatActivity implements View.OnClickListener {

    ImageView backCrop;
    CardView rice, wheat, maize, carrots, eggplant, tomato;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop);

        backCrop = findViewById(R.id.backCrop);
        rice = findViewById(R.id.rice);
        wheat = findViewById(R.id.wheat);
        maize = findViewById(R.id.maize);
        carrots = findViewById(R.id.carrots);
        eggplant = findViewById(R.id.eggplant);
        tomato = findViewById(R.id.tomato);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("crops");


        backCrop.setOnClickListener(this);
        rice.setOnClickListener(this);
        wheat.setOnClickListener(this);
        maize.setOnClickListener(this);
        carrots.setOnClickListener(this);
        eggplant.setOnClickListener(this);
        tomato.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.backCrop)
        {
            Intent intent = new Intent(AddCrop.this, Dashboard.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.rice)
        {
            reference.child("Name").setValue("Rice");
            reference.child("HumidHigh").setValue("80");
            reference.child("HumidLow").setValue("35");
            reference.child("HumidOptimum").setValue("60");
            reference.child("MoistureLow").setValue("0");
            reference.child("MoistureHigh").setValue("700");
            reference.child("MoistureOptimum").setValue("300");
            reference.child("TempHigh").setValue("35");
            reference.child("TempLow").setValue("8");
            reference.child("TempOptimum").setValue("27");

            Toast.makeText(AddCrop.this,"Rice Added to Database",Toast.LENGTH_SHORT).show();
            backIntent();
        }
        else if (v.getId() == R.id.wheat)
        {
            reference.child("Name").setValue("Wheat");
            reference.child("HumidHigh").setValue("80");
            reference.child("HumidLow").setValue("35");
            reference.child("HumidOptimum").setValue("60");
            reference.child("MoistureLow").setValue("0");
            reference.child("MoistureHigh").setValue("700");
            reference.child("MoistureOptimum").setValue("300");
            reference.child("TempHigh").setValue("26");
            reference.child("TempLow").setValue("5");
            reference.child("TempOptimum").setValue("20");
            Toast.makeText(AddCrop.this,"Wheat Added to Database",Toast.LENGTH_SHORT).show();
            backIntent();
        }
        else if (v.getId() == R.id.maize)
        {
            reference.child("Name").setValue("Maize");
            reference.child("HumidHigh").setValue("70");
            reference.child("HumidLow").setValue("35");
            reference.child("HumidOptimum").setValue("60");
            reference.child("MoistureLow").setValue("0");
            reference.child("MoistureHigh").setValue("700");
            reference.child("MoistureOptimum").setValue("300");
            reference.child("TempHigh").setValue("30");
            reference.child("TempLow").setValue("5");
            reference.child("TempOptimum").setValue("15");
            Toast.makeText(AddCrop.this,"Maize Added to Database",Toast.LENGTH_SHORT).show();
            backIntent();
        }
        else if (v.getId() == R.id.carrots)
        {
            reference.child("Name").setValue("Carrots");
            reference.child("HumidHigh").setValue("80");
            reference.child("HumidLow").setValue("35");
            reference.child("HumidOptimum").setValue("60");
            reference.child("MoistureLow").setValue("0");
            reference.child("MoistureHigh").setValue("700");
            reference.child("MoistureOptimum").setValue("300");
            reference.child("TempHigh").setValue("35");
            reference.child("TempLow").setValue("8");
            reference.child("TempOptimum").setValue("27");
            Toast.makeText(AddCrop.this,"Carrots Added to Database",Toast.LENGTH_SHORT).show();
            backIntent();
        }

        else if (v.getId() == R.id.eggplant)
        {
            reference.child("Name").setValue("Eggplant");
            reference.child("HumidHigh").setValue("85");
            reference.child("HumidLow").setValue("35");
            reference.child("HumidOptimum").setValue("65");
            reference.child("MoistureLow").setValue("0");
            reference.child("MoistureHigh").setValue("700");
            reference.child("MoistureOptimum").setValue("300");
            reference.child("TempHigh").setValue("29");
            reference.child("TempLow").setValue("10");
            reference.child("TempOptimum").setValue("26");
            Toast.makeText(AddCrop.this,"Eggplant Added to Database",Toast.LENGTH_SHORT).show();
            backIntent();
        }
        else if (v.getId() == R.id.tomato)
        {
            reference.child("Name").setValue("Tomato");
            reference.child("HumidHigh").setValue("85");
            reference.child("HumidLow").setValue("35");
            reference.child("HumidOptimum").setValue("65");
            reference.child("MoistureLow").setValue("0");
            reference.child("MoistureHigh").setValue("700");
            reference.child("MoistureOptimum").setValue("300");
            reference.child("TempHigh").setValue("29");
            reference.child("TempLow").setValue("10");
            reference.child("TempOptimum").setValue("26");
            Toast.makeText(AddCrop.this,"Tomato Added to Database",Toast.LENGTH_SHORT).show();
            backIntent();
        }

    }

    private void backIntent()
    {
        Handler h = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                Intent i = new Intent().setClass(AddCrop.this, Dashboard.class);
                startActivity(i);
            }
        };

        h.sendEmptyMessageDelayed(0, 1500); // 1500 is time in miliseconds

    }
}