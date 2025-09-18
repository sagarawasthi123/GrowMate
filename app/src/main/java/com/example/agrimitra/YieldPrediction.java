package com.example.agrimitra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class YieldPrediction extends AppCompatActivity {

    Spinner spinnerCropType, spinnerSoilType;
    EditText soilPhInput, soilQualityInput, soilTempInput, soilHumidityInput,
            windSpeedInput, nitrogenInput, phosphorusInput, potassiumInput, rainfallInput;

    CardView fetch, submit;

    private final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL = "https://yield-prediction-1-tw5i.onrender.com/predict";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yield_prediction);

        fetch = findViewById(R.id.btnFetchData);
        submit = findViewById(R.id.btnSubmit);

        spinnerCropType = findViewById(R.id.spinnerCropType);
        spinnerSoilType = findViewById(R.id.spinnerSoilType);

        // Set Crop Type Spinner values
        String[] cropTypes = {"Select crop type","Barley","Corn","Cotton","Potato","Rice","Soybean","Sugarcane","Sunflower","Tomato","Wheat"};
        ArrayAdapter<String> cropAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, cropTypes);
        cropAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerCropType.setAdapter(cropAdapter);

        // Set Soil Type Spinner values
        String[] soilTypes = {"Select soil type","Clay","Loamy","Peaty","Sandy","Saline"};
        ArrayAdapter<String> soilAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, soilTypes);
        soilAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerSoilType.setAdapter(soilAdapter);

        // EditTexts
        soilPhInput = findViewById(R.id.soilPhInput);
        soilQualityInput = findViewById(R.id.soilQualityInput);
        soilTempInput = findViewById(R.id.soilTempInput);
        soilHumidityInput = findViewById(R.id.soilHumidityInput);
        windSpeedInput = findViewById(R.id.windSpeedInput);
        nitrogenInput = findViewById(R.id.nitrogenInput);
        phosphorusInput = findViewById(R.id.phosphorusInput);
        potassiumInput = findViewById(R.id.potassiumInput);
        rainfallInput = findViewById(R.id.rainfallInput);

        // Fetch Data button
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(YieldPrediction.this);
                progressDialog.setMessage("Fetching data...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                new Handler().postDelayed(() -> {
                    progressDialog.dismiss();

                    // Static values (only numbers, no units)
                    soilPhInput.setText("6.17");
                    soilQualityInput.setText("72.23");
                    soilTempInput.setText("27.0");
                    soilHumidityInput.setText("78.6");
                    windSpeedInput.setText("10.8");
                    nitrogenInput.setText("78.8");
                    phosphorusInput.setText("63.2");
                    potassiumInput.setText("54.8");
                    rainfallInput.setText("1023.6");
                }, 2000);
            }
        });

        // Submit Button -> Call API
        submit.setOnClickListener(new View.OnClickListener() {
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
        try {
            // Get selected values from spinners
            String cropType = spinnerCropType.getSelectedItem().toString();
            String soilType = spinnerSoilType.getSelectedItem().toString();

            if (cropType.equals("Select crop type") || soilType.equals("Select soil type")) {
                Toast.makeText(this, "Please select valid Crop and Soil type", Toast.LENGTH_SHORT).show();
                return;
            }

            // Build JSON body
            JSONObject json = new JSONObject();
            json.put("crop_type", cropType);
            json.put("soil_type", soilType);
            json.put("soil_ph", Double.parseDouble(soilPhInput.getText().toString()));
            json.put("temperature", Double.parseDouble(soilTempInput.getText().toString()));
            json.put("humidity", Double.parseDouble(soilHumidityInput.getText().toString()));
            json.put("wind_speed", Double.parseDouble(windSpeedInput.getText().toString()));
            json.put("n", Double.parseDouble(nitrogenInput.getText().toString()));
            json.put("p", Double.parseDouble(phosphorusInput.getText().toString()));
            json.put("k", Double.parseDouble(potassiumInput.getText().toString()));
            json.put("soil_quality", Double.parseDouble(soilQualityInput.getText().toString()));
            json.put("avg_rainfall", Double.parseDouble(rainfallInput.getText().toString()));

            RequestBody body = RequestBody.create(json.toString(), JSON);
            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .post(body)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(() ->
                            Toast.makeText(YieldPrediction.this, "API Error: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                    );
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        runOnUiThread(() ->
                                Toast.makeText(YieldPrediction.this, "Server Error: " + response.code(), Toast.LENGTH_SHORT).show()
                        );
                    } else {
                        try {
                            String resBody = response.body().string();
                            JSONObject resJson = new JSONObject(resBody);

                            if (resJson.has("prediction")) {
                                double prediction = resJson.getDouble("prediction");
                                String formattedPrediction = String.format("%.2f", prediction); // format to 2 decimal

                                runOnUiThread(() -> {
                                    Toast.makeText(YieldPrediction.this, "Predicted Yield: " + formattedPrediction, Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(YieldPrediction.this, YieldPredictionResult.class);

                                    // Add all values as StringExtra
                                    intent.putExtra("soil_ph", soilPhInput.getText().toString());
                                    intent.putExtra("soil_quality", soilQualityInput.getText().toString());
                                    intent.putExtra("soil_temp", soilTempInput.getText().toString());
                                    intent.putExtra("soil_humidity", soilHumidityInput.getText().toString());
                                    intent.putExtra("wind_speed", windSpeedInput.getText().toString());
                                    intent.putExtra("nitrogen", nitrogenInput.getText().toString());
                                    intent.putExtra("phosphorus", phosphorusInput.getText().toString());
                                    intent.putExtra("potassium", potassiumInput.getText().toString());
                                    intent.putExtra("rainfall", rainfallInput.getText().toString());

                                    // Also pass crop & soil type
                                    intent.putExtra("crop_type", cropType);
                                    intent.putExtra("soil_type", soilType);

                                    // Pass prediction with 2 decimal places
                                    intent.putExtra("prediction", formattedPrediction);

                                    startActivity(intent);
                                });
                            }



                            else {
                                runOnUiThread(() ->
                                        Toast.makeText(YieldPrediction.this, "Error: " + resJson.optString("error", "Unknown error"), Toast.LENGTH_SHORT).show()
                                );
                            }
                        } catch (Exception e) {
                            runOnUiThread(() ->
                                    Toast.makeText(YieldPrediction.this, "Parsing Error", Toast.LENGTH_SHORT).show()
                            );
                        }
                    }
                }
            });

        } catch (Exception e) {
            Toast.makeText(this, "Input Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
