package com.example.smartagriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CostEstimation extends AppCompatActivity {

    EditText waterCost, waterAmount, pestisideCost, pesticideAmount, fertilizerCost, fertilizerAmount;
    TextView result;
    Button calculate;
    ImageView backCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_estimation);

        waterCost = findViewById(R.id.waterCost);
        waterAmount = findViewById(R.id.waterAmount);
        pestisideCost = findViewById(R.id.pestisideCost);
        pesticideAmount = findViewById(R.id.pesticideAmount);
        fertilizerCost = findViewById(R.id.fertilizerCost);
        fertilizerAmount = findViewById(R.id.fertilizerAmount);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);
        backCost = findViewById(R.id.backCost);

        backCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CostEstimation.this, Dashboard.class);
                startActivity(intent);
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String costWater = waterCost.getText().toString();
                String amountWater = waterAmount.getText().toString();
                String costPesticide = pestisideCost.getText().toString();
                String amountPesticide = pesticideAmount.getText().toString();
                String costFertilizer = fertilizerCost.getText().toString();
                String amountFertilizer = fertilizerAmount.getText().toString();

                if(costWater.isEmpty())
                {
                    waterCost.setError("Enter Cost of Water Purchased");
                }
                if(amountWater.isEmpty())
                {
                    waterAmount.setError("Enter Amount of Water Used");
                }
                if(costPesticide.isEmpty())
                {
                    pestisideCost.setError("Enter Amount of Pesticide Purchased");
                }
                if(amountPesticide.isEmpty())
                {
                    pesticideAmount.setError("Enter Amount of Pesticide Used");
                }
                if(costFertilizer.isEmpty())
                {
                    fertilizerCost.setError("Enter Amount of Fertilizer Purchased");
                }
                if(amountFertilizer.isEmpty())
                {
                    fertilizerAmount.setError("Enter Amount of Fertilizer Used");
                }

                int count = 0, changeWaterCost=0, changeWaterAmount=0, changePesticideCost=0,changePesticideAmount=0, changeFertilizerCost=0, changeFertilizerAmount=0 ;

                try{  changeWaterCost = Integer.parseInt(costWater); }catch (NumberFormatException e){ waterCost.setError("Enter a Valid Price"); count++;}
                try{ changeWaterAmount = Integer.parseInt(amountWater);}catch (NumberFormatException e){waterAmount.setError("Enter a Valid Amount"); count++;}
                try{ changePesticideCost = Integer.parseInt(costPesticide);}catch (NumberFormatException e){pestisideCost.setError("Enter a Valid Price"); count++;}
                try{ changePesticideAmount = Integer.parseInt(amountPesticide);}catch (NumberFormatException e){pesticideAmount.setError("Enter a Valid Amount"); count++;}
                try{ changeFertilizerCost = Integer.parseInt(costFertilizer);}catch (NumberFormatException e){fertilizerCost.setError("Enter a Valid Price"); count++;}
                try{ changeFertilizerAmount = Integer.parseInt(amountFertilizer);}catch (NumberFormatException e){fertilizerAmount.setError("Enter a Valid Amount"); count++;}

                int finalResult = (changeWaterCost*changeWaterAmount)+(changePesticideCost*changePesticideAmount)+(changeFertilizerCost*changeFertilizerAmount);

                result.setText(""+finalResult);


            }
        });
    }
}