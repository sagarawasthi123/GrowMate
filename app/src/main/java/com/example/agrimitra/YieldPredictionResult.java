package com.example.agrimitra;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class YieldPredictionResult extends AppCompatActivity {

    TextView stype,ctype,pH,temp,humi,wind,rain,n,p,k,pred,ohum,opH,on,op,ok,opred;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yield_prediction_result);


        stype=findViewById(R.id.t3);
        ctype=findViewById(R.id.t4);
        pH=findViewById(R.id.t9);
        temp=findViewById(R.id.t7);
        humi=findViewById(R.id.t11);
        wind=findViewById(R.id.t13);
        rain=findViewById(R.id.t18);
        n=findViewById(R.id.n_value);
        p=findViewById(R.id.p_value);
        k=findViewById(R.id.k_value);


        String soilPh = getIntent().getStringExtra("soil_ph");
        String soilQuality = getIntent().getStringExtra("soil_quality");
        String soilTemp = getIntent().getStringExtra("soil_temp");
        String soilHumidity = getIntent().getStringExtra("soil_humidity");
        String windSpeed = getIntent().getStringExtra("wind_speed");
        String nitrogen = getIntent().getStringExtra("nitrogen");
        String phosphorus = getIntent().getStringExtra("phosphorus");
        String potassium = getIntent().getStringExtra("potassium");
        String rainfall = getIntent().getStringExtra("rainfall");

// Get the crop and soil type
        String cropType = getIntent().getStringExtra("crop_type");
        String soilType = getIntent().getStringExtra("soil_type");

// Get the prediction value
        String prediction = getIntent().getStringExtra("prediction");

        stype.setText(soilType);
        ctype.setText(cropType);
        pH.setText(soilPh);
        temp.setText(soilTemp);
        humi.setText(soilHumidity);
        wind.setText(windSpeed);
        rain.setText(rainfall);
        n.setText(nitrogen);
        p.setText(phosphorus);
        k.setText(potassium);

        pred.setText(prediction);

        ohum=findViewById(R.id.ot_t3);
        opH=findViewById(R.id.ot_t5);
        on=findViewById(R.id.ot_n_value);
        op=findViewById(R.id.ot_p_value);
        ok=findViewById(R.id.ot_k_value);

        ohum.setText("82.3");
        opH.setText("7.09");
        on.setText("82.5");
        op.setText("67.8");
        ok.setText("59.7");

        Double x=Double.parseDouble(prediction);
        Double y=x+9.6;

        opred.setText(String.valueOf(y));









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}