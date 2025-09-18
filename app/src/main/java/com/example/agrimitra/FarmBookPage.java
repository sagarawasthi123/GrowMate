package com.example.agrimitra;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FarmBookPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_farm_book_page);

        Spinner spinner = findViewById(R.id.spinnerPestType);

        String[] crops = {"Rice", "Wheat", "Corn", "Potato", "Tomato"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                crops
        );
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

        CardView submit=findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=spinner.getSelectedItem().toString().toLowerCase();
                makeChanges(text);
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void makeChanges(String crop)
    {

        ImageView imageView=findViewById(R.id.img1);
        TextView title=findViewById(R.id.t1);
        TextView description=findViewById(R.id.t3);
        TextView landPreparation=findViewById(R.id.t5);
        TextView plantingMethod=findViewById(R.id.t11);
        TextView waterManagement=findViewById(R.id.t13);
        TextView pest=findViewById(R.id.t17);


        if (crop.equals("wheat")) {
            imageView.setImageResource(R.drawable.wheat);
            title.setText("Wheat");
            description.setText("Wheat is a staple cereal crop grown worldwide for its grain, which is milled into flour for bread, pasta, and other foods. It thrives in temperate climates with moderate rainfall and well-drained soil. Wheat is rich in carbohydrates and protein, making it vital for human nutrition.");
            landPreparation.setText("Plough the land to a fine tilth, remove weeds, and level the field. Add organic manure and fertilizers based on soil testing.");
            plantingMethod.setText("Sow seeds using a seed drill for uniform spacing or broadcast manually, then lightly cover with soil.");
            waterManagement.setText("Requires moderate irrigation, especially at tillering, flowering, and grain filling stages.");
            pest.setText("Use resistant varieties, timely fungicide sprays, and crop rotation to manage pests like aphids and rust.");

        } else if (crop.equals("rice")) {
            imageView.setImageResource(R.drawable.rice);
            title.setText("Rice");
            description.setText("Rice is a major food crop grown primarily in flooded fields called paddies. It requires warm temperatures and abundant water. Rice is a carbohydrate-rich staple feeding over half the world’s population, especially in Asia.");
            landPreparation.setText("Plough the field and puddle the soil by flooding and mixing to create a soft, muddy bed for transplantation.");
            plantingMethod.setText("Raise seedlings in nurseries; transplant 20-30 days old seedlings into flooded fields.");
            waterManagement.setText("Maintain continuous shallow flooding until grain filling, then gradually drain water before harvest.");
            pest.setText("Use integrated pest management (IPM) including resistant varieties, natural predators, and safe insecticides for pests like stem borers and leafhoppers.");

        } else if (crop.equals("corn")) {
            imageView.setImageResource(R.drawable.corn);
            title.setText("Corn");
            description.setText("Corn is a versatile cereal grown for food, fodder, and industrial uses. It grows well in warm climates with well-drained fertile soils. Corn is rich in carbohydrates and widely used for human consumption and livestock feed.");
            landPreparation.setText("Plough and harrow the soil to a fine tilth, ensuring good drainage and aeration.");
            plantingMethod.setText("Sow seeds directly in rows using seed drills or manual planting, spacing 60-90 cm apart.");
            waterManagement.setText("Requires regular watering, especially during tasseling and silking stages; avoid waterlogging.");
            pest.setText("Use resistant hybrids, crop rotation, and pesticides for pests like corn borers and armyworms.");

        } else if (crop.equals("potato")) {
            imageView.setImageResource(R.drawable.potato);
            title.setText("Potato");
            description.setText("Potato is a tuber crop grown for its nutritious edible tubers rich in carbohydrates, vitamins, and minerals. It grows best in cool climates and well-drained, loose soils.");
            landPreparation.setText("Plough and add organic matter; create ridges or mounds to improve drainage and tuber development.");
            plantingMethod.setText("Plant seed tubers or cut pieces with eyes spaced 20-30 cm apart on ridges.");
            waterManagement.setText("Keep soil moist but not waterlogged; frequent watering during tuber formation is critical.");
            pest.setText("Control pests like potato beetles and aphids using insecticides and crop rotation.");

        } else if (crop.equals("tomato")) {
            imageView.setImageResource(R.drawable.tomato);
            title.setText("Tomato");
            description.setText("Tomato is a widely cultivated vegetable crop used fresh or processed. It requires warm temperatures, plenty of sunlight, and well-drained fertile soil.");
            landPreparation.setText("Prepare well-tilled, fertile soil enriched with organic matter. Beds or rows should be leveled.");
            plantingMethod.setText("Start seeds in nurseries; transplant seedlings to the field after 4-6 weeks with spacing of 45-60 cm.");
            waterManagement.setText("Water regularly to keep soil moist; avoid wetting leaves to prevent fungal diseases.");
            pest.setText("Manage pests like aphids and tomato fruit worms using insecticides, traps, and resistant varieties.");
        }












    }


}