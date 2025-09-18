package com.example.agrimitra;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CropRecommendationResultPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crop_recommendation_result_page);


        ImageView imageView=findViewById(R.id.img1);

        TextView title=findViewById(R.id.t1);
        TextView description=findViewById(R.id.t3);
        TextView pricePer=findViewById(R.id.t5);
        TextView avgProducing=findViewById(R.id.t7);
        TextView time=findViewById(R.id.t9);
        TextView profit=findViewById(R.id.t11);
        TextView msp=findViewById(R.id.t13);
        TextView season=findViewById(R.id.t15);
        TextView tools=findViewById(R.id.t17);
        TextView state=findViewById(R.id.t19);




        // Intent

        String crop=getIntent().getStringExtra("crop").toString().toLowerCase();

        if (crop.equals("rice"))
        {
            title.setText("Rice");
            description.setText("Staple cereal for most of India; grown in flooded/puddled fields or upland in some areas. High calorie staple and staple-food market crop.");
            pricePer.setText("₹40–₹60");
            avgProducing.setText("₹50,000 – ₹90,000");
            time.setText("120–150 days");
            profit.setText("₹10,000–₹40,000");
            msp.setText("₹23.69/kg");
            season.setText("Kharif (June–Nov)");
            tools.setText("Tractor, rotavator, puddler/transplanter, threshers, winnowers.");
            state.setText("West Bengal");
        }
        else if (crop.equals("maize"))
        {
            title.setText("Maize");

            description.setText("Versatile cereal used as food, feed and industrial raw material. High returns with hybrid varieties and irrigation.");

            pricePer.setText("₹18–₹30");

            avgProducing.setText("₹30,000 – ₹60,000");

            time.setText("90–120 days");

            profit.setText("₹10,000–₹40,000");

            msp.setText("₹23.69/kg");

            season.setText("Kharif (monsoon)");

            tools.setText("Tractor, seed drill/planter, cultivator, combine (for large farms), sheller.");

            state.setText("Karnataka");


        }
        else if (crop.equals("chickpea"))
        {
            title.setText("Chickpea");

            description.setText("Important pulse (gram) used as protein source; drought tolerant legumes fix some nitrogen.");

            pricePer.setText("₹60–₹110");

            avgProducing.setText("₹25,000 – ₹45,000");

            time.setText("90–120 days");

            profit.setText("₹8,000–₹30,000");

            msp.setText("₹23.69/kg");

            season.setText("Rabi (Oct–Mar)");

            tools.setText("Plough, seed drill, combine harvester for larger farms.");

            state.setText("Madhya Pradesh");


        }
        else if (crop.equals("kidneybeans"))
        {
            title.setText("Kidney beans (Rajma)");

            description.setText("Crop grown in some hill and plain regions; good protein crop.");

            state.setText("Jammu & Kashmir");

            time.setText("90–150 days.");

            avgProducing.setText("₹30,000 – ₹60,000");

            pricePer.setText("₹80–₹140");

            tools.setText("Plough, seed drill, manual harvest or small combine.");

            season.setText("Kharif/Rabi");

            profit.setText("₹5,000–₹30,000");

            msp.setText("₹23.69/kg");



        }

        else if (crop.equals("pigeonpeas"))
        {
            title.setText("Pigeon peas (Tur / Red gram)");

            description.setText("Key pulse crop in semi-arid regions; important protein source and intercrop option.");

            state.setText("Maharashtra");

            time.setText("120–160 days");

            avgProducing.setText("₹20,000 – ₹45,000");

            pricePer.setText("₹70–₹140");

            tools.setText("Plough, seed drill, combine (where mechanized)");

            season.setText("Kharif");

            profit.setText("₹5,000–₹25,000");

            msp.setText("₹23.69/kg");



        }

        // 6. Moth Beans
        else if (crop.equals("mothbeans"))
        {
            title.setText("Moth Beans");
            description.setText("A drought-resistant legume grown mainly in arid regions of India. Provides protein and is used for dal and fodder.");
            state.setText("Rajasthan");
            time.setText("70–90 days");
            avgProducing.setText("₹15,000 – ₹35,000 per hectare");
            pricePer.setText("₹60–₹90 per kg");
            tools.setText("Plough, seed drill, hand weeding tools");
            season.setText("Kharif (July–October)");
            profit.setText("₹8,000 – ₹20,000 per hectare");
            msp.setText("No fixed MSP (market price based)");
        }

// 7. Mung Bean (Green Gram)
        else if (crop.equals("mungbean"))
        {
            title.setText("Mung Bean (Green Gram)");
            description.setText("Short-duration pulse crop, rich in protein and widely used as dal and sprouts. Improves soil fertility.");
            state.setText("Maharashtra");
            time.setText("60–75 days");
            avgProducing.setText("₹20,000 – ₹40,000 per hectare");
            pricePer.setText("₹80–₹120 per kg");
            tools.setText("Seed drill, plough, threshing tools");
            season.setText("Kharif & Summer");
            profit.setText("₹10,000 – ₹25,000 per hectare");
            msp.setText("₹86.82/kg (MSP 2024–25)");
        }

// 8. Black Gram (Urad)
        else if (crop.equals("blackgram"))
        {
            title.setText("Black Gram (Urad)");
            description.setText("Popular pulse crop used in dals, idli/dosa batter, and papads. Improves soil nitrogen.");
            state.setText("Madhya Pradesh");
            time.setText("70–90 days");
            avgProducing.setText("₹18,000 – ₹40,000 per hectare");
            pricePer.setText("₹70–₹100 per kg");
            tools.setText("Plough, seed drill, harvesting sickles");
            season.setText("Kharif & Summer");
            profit.setText("₹8,000 – ₹20,000 per hectare");
            msp.setText("₹74.00/kg (MSP 2025–26)");
        }

// 9. Lentil
        else if (crop.equals("lentil"))
        {
            title.setText("Lentil");
            description.setText("Winter pulse crop rich in protein. Consumed as dal and plays a role in crop rotation systems.");
            state.setText("Uttar Pradesh");
            time.setText("100–120 days");
            avgProducing.setText("₹25,000 – ₹50,000 per hectare");
            pricePer.setText("₹60–₹90 per kg");
            tools.setText("Plough, seed drill, harrow, sickles");
            season.setText("Rabi");
            profit.setText("₹12,000 – ₹25,000 per hectare");
            msp.setText("₹65.00/kg (approx MSP)");
        }

// 10. Pomegranate
        else if (crop.equals("pomegranate"))
        {
            title.setText("Pomegranate");
            description.setText("A high-value fruit crop known for its medicinal and nutritional benefits. Export-oriented crop.");
            state.setText("Maharashtra");
            time.setText("150–180 days (flower to harvest)");
            avgProducing.setText("₹80,000 – ₹1,50,000 per hectare");
            pricePer.setText("₹60–₹120 per kg");
            tools.setText("Pruning tools, drip irrigation, sprayers");
            season.setText("All year (best in winter)");
            profit.setText("₹40,000 – ₹90,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 11. Banana
        else if (crop.equals("banana"))
        {
            title.setText("Banana");
            description.setText("Tropical fruit crop and one of the largest produced fruits in India. Provides quick returns.");
            state.setText("Tamil Nadu");
            time.setText("9–12 months");
            avgProducing.setText("₹1,00,000 – ₹2,00,000 per hectare");
            pricePer.setText("₹10–₹25 per kg");
            tools.setText("Irrigation systems, cutting knives, sprayers");
            season.setText("Year-round");
            profit.setText("₹50,000 – ₹1,00,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 12. Mango
        else if (crop.equals("mango"))
        {
            title.setText("Mango");
            description.setText("National fruit of India, highly profitable with export demand. Popular varieties include Alphonso and Dasheri.");
            state.setText("Uttar Pradesh");
            time.setText("3–5 years (tree maturity)");
            avgProducing.setText("₹80,000 – ₹2,00,000 per hectare");
            pricePer.setText("₹30–₹80 per kg");
            tools.setText("Pruning tools, ladders, harvesting nets");
            season.setText("Summer (April–July)");
            profit.setText("₹50,000 – ₹1,50,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 13. Grapes
        else if (crop.equals("grapes"))
        {
            title.setText("Grapes");
            description.setText("Fruit crop with high market and export value. Requires good vineyard management and irrigation.");
            state.setText("Maharashtra");
            time.setText("4–5 months (fruiting)");
            avgProducing.setText("₹1,50,000 – ₹3,00,000 per hectare");
            pricePer.setText("₹50–₹120 per kg");
            tools.setText("Pruning shears, trellis system, sprayers");
            season.setText("January–March (main harvest)");
            profit.setText("₹70,000 – ₹2,00,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 14. Watermelon
        else if (crop.equals("watermelon"))
        {
            title.setText("Watermelon");
            description.setText("Summer fruit crop with high water content. Quick growing and widely consumed in hot climates.");
            state.setText("Karnataka");
            time.setText("70–90 days");
            avgProducing.setText("₹30,000 – ₹60,000 per hectare");
            pricePer.setText("₹10–₹25 per kg");
            tools.setText("Plough, drip irrigation, knives for harvest");
            season.setText("Summer");
            profit.setText("₹15,000 – ₹35,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 15. Muskmelon
        else if (crop.equals("muskmelon"))
        {
            title.setText("Muskmelon");
            description.setText("Sweet melon fruit crop grown in warm climates. Popular in summer with high consumer demand.");
            state.setText("Uttar Pradesh");
            time.setText("70–80 days");
            avgProducing.setText("₹25,000 – ₹55,000 per hectare");
            pricePer.setText("₹20–₹50 per kg");
            tools.setText("Plough, drip irrigation, hand tools");
            season.setText("Summer");
            profit.setText("₹10,000 – ₹30,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 16. Apple
        else if (crop.equals("apple"))
        {
            title.setText("Apple");
            description.setText("Popular temperate fruit crop, majorly grown in hilly regions. Requires cold climate.");
            state.setText("Himachal Pradesh");
            time.setText("7–8 months (flower to harvest)");
            avgProducing.setText("₹1,50,000 – ₹3,50,000 per hectare");
            pricePer.setText("₹60–₹150 per kg");
            tools.setText("Pruning tools, ladders, harvesting bags");
            season.setText("Autumn (September–October)");
            profit.setText("₹80,000 – ₹2,00,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 17. Orange
        else if (crop.equals("orange"))
        {
            title.setText("Orange");
            description.setText("Citrus fruit rich in Vitamin C. India is among the largest producers, with Nagpur famous for oranges.");
            state.setText("Maharashtra");
            time.setText("7–8 months");
            avgProducing.setText("₹80,000 – ₹1,80,000 per hectare");
            pricePer.setText("₹30–₹80 per kg");
            tools.setText("Pruning shears, sprayers, harvesting bags");
            season.setText("Winter (Dec–Feb)");
            profit.setText("₹40,000 – ₹1,00,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 18. Papaya
        else if (crop.equals("papaya"))
        {
            title.setText("Papaya");
            description.setText("Fast-growing fruit crop with high demand. Rich in vitamins and used for fresh eating and processing.");
            state.setText("Andhra Pradesh");
            time.setText("8–10 months");
            avgProducing.setText("₹70,000 – ₹1,50,000 per hectare");
            pricePer.setText("₹15–₹40 per kg");
            tools.setText("Drip irrigation, cutting tools, sprayers");
            season.setText("Year-round");
            profit.setText("₹30,000 – ₹80,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 19. Coconut
        else if (crop.equals("coconut"))
        {
            title.setText("Coconut");
            description.setText("Major plantation crop of coastal India, providing copra, oil, and other products. Lifeline of coastal farmers.");
            state.setText("Kerala");
            time.setText("12 months (continuous harvesting)");
            avgProducing.setText("₹1,00,000 – ₹2,50,000 per hectare");
            pricePer.setText("₹30–₹60 per nut equivalent");
            tools.setText("Climbing tools, knives, sprayers");
            season.setText("Year-round");
            profit.setText("₹60,000 – ₹1,50,000 per hectare");
            msp.setText("No MSP (market driven)");
        }

// 20. Cotton
        else if (crop.equals("cotton"))
        {
            title.setText("Cotton");
            description.setText("Cash crop and primary source of natural fiber. Used in textile industry worldwide.");
            state.setText("Maharashtra");
            time.setText("150–180 days");
            avgProducing.setText("₹40,000 – ₹90,000 per hectare");
            pricePer.setText("₹60–₹80 per kg (lint)");
            tools.setText("Seed drill, plough, cotton picker");
            season.setText("Kharif");
            profit.setText("₹15,000 – ₹40,000 per hectare");
            msp.setText("₹62–₹70/kg lint equivalent (MSP varies)");
        }

// 21. Jute
        else if (crop.equals("jute"))
        {
            title.setText("Jute");
            description.setText("Important fiber crop known as the ‘golden fiber’. Used for making gunny bags, ropes, and mats.");
            state.setText("West Bengal");
            time.setText("120–150 days");
            avgProducing.setText("₹35,000 – ₹70,000 per hectare");
            pricePer.setText("₹40–₹60 per kg (fiber)");
            tools.setText("Plough, sickle, retting tanks");
            season.setText("Kharif (March–July sowing)");
            profit.setText("₹15,000 – ₹30,000 per hectare");
            msp.setText("₹47/kg fiber (approx MSP)");
        }

// 22. Coffee
        else if (crop.equals("coffee"))
        {
            title.setText("Coffee");
            description.setText("Plantation crop grown in hilly areas. India mainly produces Arabica and Robusta varieties.");
            state.setText("Karnataka");
            time.setText("3–4 years (to start production)");
            avgProducing.setText("₹1,50,000 – ₹3,00,000 per hectare");
            pricePer.setText("₹120–₹200 per kg");
            tools.setText("Pruning tools, pulping machines, dryers");
            season.setText("Harvest: Nov–Feb");
            profit.setText("₹70,000 – ₹1,50,000 per hectare");
            msp.setText("No MSP (market driven)");
        }
        else
        {

            title.setText("Rice");
            description.setText("Staple cereal for most of India; grown in flooded/puddled fields or upland in some areas. High calorie staple and staple-food market crop.");
            pricePer.setText("₹40–₹60");
            avgProducing.setText("₹50,000 – ₹90,000");
            time.setText("120–150 days");
            profit.setText("₹10,000–₹40,000");
            msp.setText("₹23.69/kg");
            season.setText("Kharif (June–Nov)");
            tools.setText("Tractor, rotavator, puddler/transplanter, threshers, winnowers.");
            state.setText("West Bengal");
        }

























        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}