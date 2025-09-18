package com.example.agrimitra;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;



public class CropRecommendation extends AppCompatActivity {


    EditText nitrogenInput, phosphorusInput, potassiumInput, tempInput, humidityInput, phInput, rainfallInput;
    CardView submitBtn;
    ProgressDialog progressDialog;

    private static final String PREDICT_URL = "https://crop-detection-model.onrender.com/predict";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crop_recommendation);


        nitrogenInput = findViewById(R.id.nitrogenInput);
        phosphorusInput = findViewById(R.id.phosphorusInput);
        potassiumInput = findViewById(R.id.potassiumInput);
        tempInput = findViewById(R.id.tempInput);
        humidityInput = findViewById(R.id.humidityInput);
        phInput = findViewById(R.id.phInput);
        rainfallInput = findViewById(R.id.rainfallInput);
        submitBtn = findViewById(R.id.submitBtn);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Predicting crop...");
        progressDialog.setCancelable(false);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPredictionRequest();
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void sendPredictionRequest() {
        String N = nitrogenInput.getText().toString().trim();
        String P = phosphorusInput.getText().toString().trim();
        String K = potassiumInput.getText().toString().trim();
        String temperature = tempInput.getText().toString().trim();
        String humidity = humidityInput.getText().toString().trim();
        String ph = phInput.getText().toString().trim();
        String rainfall = rainfallInput.getText().toString().trim();

        if (N.isEmpty() || P.isEmpty() || K.isEmpty() || temperature.isEmpty() ||
                humidity.isEmpty() || ph.isEmpty() || rainfall.isEmpty()) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.show();

        try {
            JSONObject jsonRequest = new JSONObject();
            jsonRequest.put("N", Integer.parseInt(N));
            jsonRequest.put("P", Integer.parseInt(P));
            jsonRequest.put("K", Integer.parseInt(K));
            jsonRequest.put("temperature", Double.parseDouble(temperature));
            jsonRequest.put("humidity", Double.parseDouble(humidity));
            jsonRequest.put("ph", Double.parseDouble(ph));
            jsonRequest.put("rainfall", Double.parseDouble(rainfall));

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, PREDICT_URL, jsonRequest,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            progressDialog.dismiss();
                            try {
                                String crop = response.getString("predicted_crop");
                                Intent intent=new Intent(CropRecommendation.this,CropRecommendationResultPage.class);
                                intent.putExtra("crop",crop);
                                startActivity(intent);

                                Toast.makeText(CropRecommendation.this, "Predicted Crop: " + crop, Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                Toast.makeText(CropRecommendation.this, "Response parsing error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(CropRecommendation.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(request);

        } catch (JSONException e) {
            progressDialog.dismiss();
            e.printStackTrace();
            Log.d("error",e.getMessage().toString());
        }
    }





}