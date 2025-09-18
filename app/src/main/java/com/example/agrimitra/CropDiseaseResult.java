package com.example.agrimitra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CropDiseaseResult extends AppCompatActivity {

    private TextView tDiseaseName, tDescription, tCauses, tSymptoms,
            tPrecautions, tPesticides, tCultural, tCostLoss, tHelpline;

    ImageView imageView;

    CardView callButton;

    public String helplineNumber="8103222607";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crop_disease_result);


        imageView=findViewById(R.id.imgDisease);



        CardView button1=findViewById(R.id.button1);
        CardView button2=findViewById(R.id.button2);
        CardView button3=findViewById(R.id.button3);
        CardView button4=findViewById(R.id.button4);


        button1.setOnClickListener(v -> openUrl("https://www.amazon.in/Generic-cvt4-Tagmycin-Streptomycin-Sulphate/dp/B0BZLBPBZS?utm_source=chatgpt.com"));
        button2.setOnClickListener(v -> openUrl("http://amazon.in/Syngenta-Amistar-Fungicide-100ml-Pack/dp/B09R34T27Q?utm_source=chatgpt.com"));
        button3.setOnClickListener(v -> openUrl("https://www.amazon.in/biosciences-Organic-Pesticide-Trichoderma-Pseudomonas/dp/B07VYZ6M22?utm_source=chatgpt.com"));
        button4.setOnClickListener(v -> openUrl("https://www.amazon.in/500GMS-HEXACONZOLE4-Contact-Fungicide-Systemic/dp/B07D2H917W?utm_source=chatgpt.com"));








        tDiseaseName = findViewById(R.id.tDiseaseName);
        tDescription = findViewById(R.id.tDescription);
        tCauses = findViewById(R.id.tCauses);
        tSymptoms = findViewById(R.id.tSymptoms);
        tPrecautions = findViewById(R.id.tPrecautions);
        tPesticides = findViewById(R.id.tPesticides);
        tCultural = findViewById(R.id.tCultural);
        tCostLoss = findViewById(R.id.tCostLoss);
        tHelpline = findViewById(R.id.tHelpline);


        callButton=findViewById(R.id.callButton);


        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + helplineNumber));
                startActivity(intent);
            }
        });


        String predictedClass = getIntent().getStringExtra("crop");

        if (predictedClass != null) {
            showDiseaseInfo(predictedClass);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showDiseaseInfo(String disease) {
        switch (disease) {

            // ---------- Cotton ----------
            case "Cotton_Bacterial_Blight":
                imageView.setImageResource(R.drawable.cotton_blight);
                setInfo(
                        "Cotton Bacterial Blight",
                        "A bacterial disease causing angular leaf spots and boll rot.",
                        "Caused by Xanthomonas campestris pv. malvacearum.",
                        "Angular black spots on leaves, stem cankers, boll rot.",
                        "Use resistant varieties, avoid overhead irrigation.",
                        "Spray Copper oxychloride or Streptomycin formulations.",
                        "Crop rotation, remove crop debris.",
                        "May reduce yield by 10–30%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Cotton_Curl_Virus":
                imageView.setImageResource(R.drawable.cotton_curl);
                setInfo(
                        "Cotton Curl Virus",
                        "A viral disease spread by whiteflies.",
                        "Caused by Cotton Leaf Curl Virus transmitted via Bemisia tabaci.",
                        "Upward curling of leaves, vein thickening, stunted growth.",
                        "Control whitefly population.",
                        "Use Imidacloprid, Thiamethoxam (follow dose guidelines).",
                        "Remove alternate host plants.",
                        "Severe infection can cause >50% yield loss.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Cotton_Fusarium_Wilt":
                imageView.setImageResource(R.drawable.cotton_fusari);
                setInfo(
                        "Cotton Fusarium Wilt",
                        "Fungal disease leading to wilting of cotton plants.",
                        "Caused by Fusarium oxysporum f.sp. vasinfectum.",
                        "Yellowing, wilting, brown vascular tissues.",
                        "Use disease-free seeds, resistant varieties.",
                        "Apply Carbendazim or Triazole fungicides.",
                        "Crop rotation with cereals.",
                        "Can reduce yield up to 40%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Cotton_Healthy":
                imageView.setImageResource(R.drawable.cotton_healthy);
                setInfo(
                        "Healthy Cotton Plant",
                        "No disease detected.",
                        "-",
                        "-",
                        "Continue regular monitoring and good practices.",
                        "-",
                        "Maintain proper spacing and irrigation.",
                        "No yield loss.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            // ---------- Sugarcane ----------
            case "Sugarcane_Bacterial_Blight":
                imageView.setImageResource(R.drawable.sugarcane_blight);
                setInfo(
                        "Sugarcane Bacterial Blight",
                        "Serious bacterial disease in sugarcane.",
                        "Caused by Xanthomonas albilineans.",
                        "Leaf scalding, white streaks, plant death.",
                        "Use resistant varieties.",
                        "Spray Copper compounds as preventive.",
                        "Destroy diseased clumps.",
                        "Can cause up to 30% yield loss.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Sugarcane_Mosaic":
                imageView.setImageResource(R.drawable.sugarcane_mosaic);
                setInfo(
                        "Sugarcane Mosaic Virus",
                        "Viral disease affecting sugarcane leaves.",
                        "Caused by Sugarcane mosaic virus.",
                        "Mosaic yellow-green patterns on leaves.",
                        "Plant resistant varieties.",
                        "No direct chemical control (vector control needed).",
                        "Remove infected plants.",
                        "Losses up to 20–30%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Sugarcane_Red_Rot":
                imageView.setImageResource(R.drawable.sugarcane_red);
                setInfo(
                        "Sugarcane Red Rot",
                        "One of the most destructive fungal diseases.",
                        "Caused by Colletotrichum falcatum.",
                        "Reddish discoloration inside stalk, foul smell.",
                        "Use resistant varieties.",
                        "Apply Carbendazim or Propiconazole (recommended dose).",
                        "Crop rotation and field sanitation.",
                        "Yield losses up to 70%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Sugarcane_Rust":
                imageView.setImageResource(R.drawable.sugarcane_rust);
                setInfo(
                        "Sugarcane Rust",
                        "Fungal disease forming pustules on leaves.",
                        "Caused by Puccinia melanocephala.",
                        "Rusty brown pustules on lower leaf surfaces.",
                        "Plant resistant cultivars.",
                        "Use fungicides like Mancozeb or Triazoles.",
                        "Remove severely infected leaves.",
                        "Losses 10–40%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Sugarcane_Yellow":
                imageView.setImageResource(R.drawable.sugarcane_yellow);
                setInfo(
                        "Sugarcane Yellow Leaf Disease",
                        "Viral disease transmitted by aphids.",
                        "Caused by Sugarcane yellow leaf virus.",
                        "Midrib yellowing progressing to whole leaf.",
                        "Control aphid population.",
                        "No direct cure, manage with insecticides.",
                        "Use virus-free planting material.",
                        "Moderate yield loss.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Sugarcane_Healthy":
                imageView.setImageResource(R.drawable.sugarcane_healthy );
                setInfo(
                        "Healthy Sugarcane",
                        "No disease detected.",
                        "-",
                        "-",
                        "Continue good practices.",
                        "-",
                        "Maintain crop hygiene.",
                        "No yield loss.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;


            case "Rice_Tungro":
                imageView.setImageResource(R.drawable.rice_tungro); // Add image in drawable
                setInfo(
                        "Rice Tungro",
                        "Viral disease causing stunted growth and yellow-orange discoloration.",
                        "Caused by Rice tungro bacilliform virus and Rice tungro spherical virus transmitted by leafhoppers.",
                        "Yellowing of leaves, stunted plant growth.",
                        "Use resistant varieties and control leafhopper population.",
                        "No direct chemical treatment; manage vector population.",
                        "Remove infected plants.",
                        "May reduce yield by 50-70%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Rice_Sheath_Blight":
                imageView.setImageResource(R.drawable.rice_blight);
                setInfo(
                        "Rice Sheath Blight",
                        "Fungal disease affecting rice sheath and leaves.",
                        "Caused by Rhizoctonia solani.",
                        "Lesions on leaf sheaths, spreading to leaves, reduced tillering.",
                        "Ensure proper spacing and water management.",
                        "Use valid fungicides (e.g., Hexaconazole, Propiconazole).",
                        "Crop rotation with non-host crops.",
                        "Yield loss may reach 20-50%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Rice_Leaf_Scald":
                imageView.setImageResource(R.drawable.rice_scar);
                setInfo(
                        "Rice Leaf Scald",
                        "Fungal disease causing white to grey lesions on leaves.",
                        "Caused by Microdochium oryzae.",
                        "White-grey streaks on leaves with yellow borders.",
                        "Maintain proper water and nutrient management.",
                        "Apply appropriate fungicides.",
                        "Remove affected plant debris.",
                        "May reduce yield moderately.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Rice_Healthy":
                imageView.setImageResource(R.drawable.rice_healthy);
                setInfo(
                        "Healthy Rice Plant",
                        "No disease detected.",
                        "-",
                        "-",
                        "Continue good agronomic practices.",
                        "-",
                        "Maintain proper irrigation and fertilization.",
                        "No yield loss.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Rice_Brown_Spot":
                imageView.setImageResource(R.drawable.rice_brown);
                setInfo(
                        "Rice Brown Spot",
                        "Fungal disease causing brown lesions on leaves and grains.",
                        "Caused by Bipolaris oryzae.",
                        "Brown spots on leaves, can reduce grain quality.",
                        "Ensure balanced fertilization, proper spacing.",
                        "Apply recommended fungicides.",
                        "Remove infected residues.",
                        "Moderate yield reduction.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Rice_Blast":
                imageView.setImageResource(R.drawable.rice_blast);
                setInfo(
                        "Rice Blast",
                        "Serious fungal disease affecting leaves, nodes, and panicles.",
                        "Caused by Magnaporthe oryzae.",
                        "Diamond-shaped lesions on leaves, neck rot, grain sterility.",
                        "Use resistant varieties and avoid excessive nitrogen.",
                        "Fungicides like Tricyclazole may be used.",
                        "Crop rotation and remove infected debris.",
                        "Yield loss can be 50-70%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            case "Rice_Bacterial_Leaf_Blight":
                imageView.setImageResource(R.drawable.rice_leaf);
                setInfo(
                        "Rice Bacterial Leaf Blight",
                        "Bacterial disease causing yellowing and drying of leaf margins.",
                        "Caused by Xanthomonas oryzae pv. oryzae.",
                        "Yellowing of leaf edges, wilting, reduced tillers.",
                        "Use resistant varieties, avoid high nitrogen application.",
                        "Apply Copper-based bactericides.",
                        "Remove infected plant debris.",
                        "Yield loss may reach 20-50%.",
                        "Call Kisan Helpline 1800-180-1551"
                );
                break;

            // ---------- Default ----------
            default:
                setInfo("Unknown Disease", "No data available.", "-", "-", "-", "-", "-", "-", "-");
                break;
        }
    }

    private void setInfo(String name, String desc, String causes, String symptoms,
                         String precautions, String pesticides, String cultural,
                         String costLoss, String helpline) {

        tDiseaseName.setText(name);
        tDescription.setText(desc);
        tCauses.setText(causes);
        tSymptoms.setText(symptoms);
        tPrecautions.setText(precautions);
        tPesticides.setText(pesticides);
        tCultural.setText(cultural);
        tCostLoss.setText(costLoss);
        tHelpline.setText(helpline);
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }



}