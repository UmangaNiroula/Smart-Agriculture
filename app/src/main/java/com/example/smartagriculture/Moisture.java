package com.example.smartagriculture;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Moisture extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    com.github.mikephil.charting.charts.BarChart BarChart;
    com.github.mikephil.charting.data.BarDataSet BarDataSet;
    com.github.mikephil.charting.data.BarData BarData;
    ImageView backMois;
    float mois, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moisture);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("sensor");
        BarChart = findViewById(R.id.graphView1);
        backMois = findViewById(R.id.backMois1);

        backMois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Moisture.this, Dashboard.class));
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ArrayList<BarEntry> dataValues = new ArrayList<BarEntry>();

                if(snapshot.hasChildren())
                {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                        DataPoint pointValue = dataSnapshot.getValue(DataPoint.class);
                        mois = Float.parseFloat(pointValue.getMoisture());
                        date = Float.parseFloat(pointValue.getDate().replaceAll("[^0-9]", ""));
                        dataValues.add(new BarEntry(date,mois));

                    }
                    showChart(dataValues);
                }
                else
                {
                    BarChart.clear();
                    BarChart.invalidate();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    private void showChart(ArrayList<BarEntry> dataValues)
    {

        BarDataSet = new BarDataSet(dataValues, "Moisture");
        BarDataSet.setValueTextSize(10f);
        BarDataSet.setValueTextColor(Color.BLACK);
        BarDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        BarData = new BarData(BarDataSet);
        BarChart.clear();
        BarChart.setData(BarData);
        BarChart.invalidate();

        LimitLine danger_limit = new LimitLine(700, "High");
        danger_limit.setLineWidth(2f);
        danger_limit.enableDashedLine(10f,10f,0f);
        danger_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        danger_limit.setTextSize(12f);
        danger_limit.setLineColor(RED);

        LimitLine opt_limit = new LimitLine(300, "Optimum");
        opt_limit.setLineWidth(2f);
        opt_limit.enableDashedLine(10f,10f,0f);
        opt_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        opt_limit.setTextSize(12f);
        opt_limit.setLineColor(GREEN);

        LimitLine low_limit = new LimitLine(0, "Low");
        low_limit.setLineWidth(2f);
        low_limit.enableDashedLine(10f,10f,0f);
        low_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        low_limit.setTextSize(12f);
        low_limit.setLineColor(RED);

        YAxis leftAxis = BarChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(danger_limit);
        leftAxis.addLimitLine(opt_limit);
        leftAxis.addLimitLine(low_limit);
        leftAxis.enableGridDashedLine(10f,10f,0);


    }
}