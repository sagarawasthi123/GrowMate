package com.example.agrimitra;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Schemes extends AppCompatActivity {

    CardView btnApplyPmKisan, btnApplyPmKusum, btnApplyFpo, btnApplyAif,
            btnApplySoilHealth, btnApplyPkvy, btnApplyMiss, btnApplyDigitalAgri,
            btnApplyNbhm, btnApplyMisPss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_schemes);


        btnApplyPmKisan = findViewById(R.id.btn_apply_pm_kisan);
        btnApplyPmKusum = findViewById(R.id.btn_apply_pm_kusum);
        btnApplyFpo = findViewById(R.id.btn_apply_fpo);
        btnApplyAif = findViewById(R.id.btn_apply_aif);
        btnApplySoilHealth = findViewById(R.id.btn_apply_soil_health);
        btnApplyPkvy = findViewById(R.id.btn_apply_pkvy);
        btnApplyMiss = findViewById(R.id.btn_apply_miss);
        btnApplyDigitalAgri = findViewById(R.id.btn_apply_digital_agriculture);
        btnApplyNbhm = findViewById(R.id.btn_apply_nbhm);
        btnApplyMisPss = findViewById(R.id.btn_apply_mis_pss);

        // Attach click listeners
        btnApplyPmKisan.setOnClickListener(v -> openUrl("https://pmkisan.gov.in/"));
        btnApplyPmKusum.setOnClickListener(v -> openUrl("https://www.india.gov.in/spotlight/pm-kusum-pradhan-mantri-kisan-urja-suraksha-evam-utthaan-mahabhiyan-scheme"));
        btnApplyFpo.setOnClickListener(v -> openUrl("https://www.nabard.org/"));
        btnApplyAif.setOnClickListener(v -> openUrl("https://agriinfra.dac.gov.in/Home"));
        btnApplySoilHealth.setOnClickListener(v -> openUrl("https://soilhealth.dac.gov.in/home"));
        btnApplyPkvy.setOnClickListener(v -> openUrl("https://agri.odisha.gov.in/node/193837"));
        btnApplyMiss.setOnClickListener(v -> openUrl("https://vajiramandravi.com/current-affairs/modified-interest-subvention-scheme/"));
        btnApplyDigitalAgri.setOnClickListener(v -> openUrl("https://agriwelfare.gov.in/en/DigiAgriDiv"));
        btnApplyNbhm.setOnClickListener(v -> openUrl("https://nbb.gov.in/default.html"));
        btnApplyMisPss.setOnClickListener(v -> openUrl("https://www.nafed-india.com/"));



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }


}