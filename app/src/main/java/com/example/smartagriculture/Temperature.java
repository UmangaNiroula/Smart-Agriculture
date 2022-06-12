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

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;


public class Temperature extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    LineChart lineChart;
    LineDataSet lineDataSet;
    ArrayList<ILineDataSet> iLineDataSets;
    LineData lineData;
    ImageView backTemp;

    int temp, date, total =0;
    long avg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("sensor");
        lineChart = findViewById(R.id.graphView);
        lineDataSet = new LineDataSet(null, null);
        iLineDataSets = new ArrayList<>();

        backTemp = findViewById(R.id.backTemp);

        backTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Temperature.this, Dashboard.class));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ArrayList<Entry> dataValues = new ArrayList<Entry>();

                if(snapshot.hasChildren())
                {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                        DataPoint pointValue = dataSnapshot.getValue(DataPoint.class);
                        temp = Integer.parseInt(pointValue.getTemperature());
                        date = Integer.parseInt(pointValue.getDate().replaceAll("[^0-9]", ""));
                        dataValues.add(new Entry(date,temp));

                        total = total+temp;
                        avg = total / snapshot.getChildrenCount();
                    }
                    showChart(dataValues, avg);
                }
                else
                {
                    lineChart.clear();
                    lineChart.invalidate();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void showChart(ArrayList<Entry> dataValues, long avg)
    {
        lineDataSet.setValues(dataValues);
        lineDataSet.setLabel("Temperature");
        lineDataSet.setCircleColor(RED);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setValueTextSize(10f);
        iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData = new LineData(iLineDataSets);
        lineChart.clear();
        lineChart.setData(lineData);
        lineChart.invalidate();

        LimitLine danger_limit = new LimitLine(30, "High");
        danger_limit.setLineWidth(2f);
        danger_limit.enableDashedLine(10f,10f,0f);
        danger_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        danger_limit.setTextSize(12f);
        danger_limit.setLineColor(RED);

        LimitLine upper_limit = new LimitLine(25, "Optimum");
        upper_limit.setLineWidth(2f);
        upper_limit.enableDashedLine(10f,10f,0f);
        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        upper_limit.setTextSize(12f);
        upper_limit.setLineColor(GREEN);

        LimitLine low_limit = new LimitLine(5, "Low");
        low_limit.setLineWidth(2f);
        low_limit.enableDashedLine(10f,10f,0f);
        low_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        low_limit.setTextSize(12f);
        low_limit.setLineColor(RED);

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(upper_limit);
        leftAxis.addLimitLine(danger_limit);
        leftAxis.addLimitLine(low_limit);
        leftAxis.enableGridDashedLine(10f,10f,0);
        leftAxis.setDrawLimitLinesBehindData(true);
        lineChart.getAxisRight().setEnabled(false);



    }

}

