package com.example.agrimitra;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PediaDetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedia_detail_page);

        String topic = getIntent().getStringExtra("topic").toLowerCase();

        ImageView imageView = findViewById(R.id.img1);
        TextView title = findViewById(R.id.t1);
        TextView description = findViewById(R.id.t3);
        TextView keyIngredients = findViewById(R.id.t5);
        TextView source = findViewById(R.id.t7);

        switch (topic) {

            case "compost":
                imageView.setImageResource(R.drawable.compost);
                title.setText("Compost");
                description.setText("Compost is an organic soil amendment made from decomposed plant and animal waste. It improves soil fertility, structure, and water retention, while providing essential nutrients for crops. Compost also enhances microbial activity, which helps plants absorb nutrients more efficiently. Using compost reduces the need for chemical fertilizers, making farming more sustainable. Regular application improves long-term soil health, increases yields, and prevents erosion.");
                keyIngredients.setText("Decomposed crop residues, kitchen waste, animal dung, leaves.");
                source.setText("Natural (biodegradable organic matter).");
                break;

            case "animal manure":
                imageView.setImageResource(R.drawable.manure);
                title.setText("Animal Manure");
                description.setText("Animal manure is a traditional organic fertilizer obtained from livestock waste. It enriches soil with essential nutrients like nitrogen, phosphorus, and potassium while improving soil texture. It boosts soil microbes and helps retain moisture. Different animals (cow, goat, poultry) provide manure with varying nutrient contents. When applied properly, it increases crop yields and reduces the need for chemical fertilizers. However, it should be well-composted to avoid harmful pathogens.");
                keyIngredients.setText("Nitrogen, phosphorus, potassium, organic matter.");
                source.setText("Natural (animal waste).");
                break;

            case "green manure":
                imageView.setImageResource(R.drawable.gm);
                title.setText("Green Manure");
                description.setText("Green manure involves growing specific crops (like legumes, clover, or sunhemp) and plowing them back into the soil before maturity. These crops add organic matter, improve soil structure, and enrich nitrogen levels through biological nitrogen fixation. Green manures prevent weed growth, reduce soil erosion, and enhance soil fertility naturally.");
                keyIngredients.setText("Nitrogen-rich legume plants (sunhemp, clover, beans).");
                source.setText("Natural (cultivated plants grown for soil enrichment).");
                break;

            case "neem oil":
                imageView.setImageResource(R.drawable.no);
                title.setText("Neem Oil");
                description.setText("Neem oil is a natural pesticide and insect repellent extracted from neem tree seeds. It disrupts the growth and reproduction of pests such as aphids, whiteflies, and caterpillars. Neem oil is biodegradable and safe for beneficial insects like bees. It also has antifungal properties, protecting crops from diseases like powdery mildew.");
                keyIngredients.setText("Azadirachtin, Nimbin, Salannin.");
                source.setText("Natural (neem tree seeds).");
                break;

            case "pyr":
                imageView.setImageResource(R.drawable.pyth);
                title.setText("Pyrethrin");
                description.setText("Pyrethrin is a natural insecticide derived from chrysanthemum flowers. It attacks the nervous system of insects, causing paralysis and death. It is effective against mosquitoes, beetles, flies, and caterpillars. Pyrethrin breaks down quickly in sunlight, making it environmentally friendly. Farmers use pyrethrin-based sprays as part of integrated pest management.");
                keyIngredients.setText("Pyrethrin I and II compounds.");
                source.setText("Natural (chrysanthemum flowers).");
                break;

            case "dia":
                imageView.setImageResource(R.drawable.dis);
                title.setText("Diatomaceous Earth");
                description.setText("Diatomaceous earth is a natural powder made from fossilized remains of microscopic algae called diatoms. It works as a mechanical insecticide by dehydrating pests such as ants, beetles, and mites. Farmers spread it around crops, storage areas, or animal sheds for pest control. It also improves soil aeration when mixed with soil.");
                keyIngredients.setText("Silica, alumina, trace minerals.");
                source.setText("Natural (fossilized diatoms).");
                break;

            case "urea":
                imageView.setImageResource(R.drawable.urea);
                title.setText("Urea");
                description.setText("Urea is a widely used synthetic nitrogen fertilizer that provides plants with a concentrated source of nitrogen, essential for leaf growth and photosynthesis. It dissolves easily in water, making it quick-acting. Farmers often apply urea during crop growth stages to boost productivity.");
                keyIngredients.setText("Nitrogen (46%).");
                source.setText("Synthetic (from ammonia and carbon dioxide).");
                break;

            case "dap":
                imageView.setImageResource(R.drawable.dap);
                title.setText("DAP (Diammonium Phosphate)");
                description.setText("DAP is a popular fertilizer containing both nitrogen and phosphorus. It is highly soluble in water, making nutrients available quickly to crops. Farmers use DAP during sowing to promote root development and early plant growth. Its balanced nutrient supply enhances yield and strengthens plants against stress.");
                keyIngredients.setText("Nitrogen (18%), Phosphorus (46%).");
                source.setText("Synthetic (from ammonia and phosphoric acid).");
                break;

            case "mop":
                imageView.setImageResource(R.drawable.mop);
                title.setText("MOP (Muriate of Potash)");
                description.setText("MOP is the most common potassium fertilizer used worldwide. Potassium strengthens plant stems, improves drought resistance, and enhances crop quality. Farmers apply MOP to crops like sugarcane, potato, banana, and vegetables. It also improves storage quality of produce.");
                keyIngredients.setText("Potassium chloride (60% K₂O).");
                source.setText("Mineral (mined from potash deposits).");
                break;

            case "car":
                imageView.setImageResource(R.drawable.carb);
                title.setText("Carbaryl");
                description.setText("Carbaryl is a synthetic insecticide belonging to the carbamate group. It is effective against chewing and sucking insects such as caterpillars, beetles, and aphids. Farmers use it to protect fruits, vegetables, and field crops. Carbaryl acts on the insect’s nervous system, leading to paralysis.");
                keyIngredients.setText("Carbaryl (1-naphthyl methylcarbamate).");
                source.setText("Synthetic (chemically produced).");
                break;

            case "chlor":
                imageView.setImageResource(R.drawable.chlor);
                title.setText("Chlorpyrifos");
                description.setText("Chlorpyrifos is an organophosphate insecticide used to control soil-borne and foliar pests like termites, cutworms, and borers. It works by disrupting the nervous system of insects. Farmers apply it on cotton, rice, maize, and vegetables. It is effective but should be used safely.");
                keyIngredients.setText("Chlorpyrifos compound.");
                source.setText("Synthetic (chemical).");
                break;

            case "gly":
                imageView.setImageResource(R.drawable.gly);
                title.setText("Glyphosate");
                description.setText("Glyphosate is a broad-spectrum systemic herbicide used to control weeds. It blocks a plant enzyme essential for growth, leading to weed death. Farmers use it for land preparation before sowing crops like maize, soybean, and cotton. Overuse can cause herbicide resistance in weeds.");
                keyIngredients.setText("Glyphosate isopropylamine salt.");
                source.setText("Synthetic (chemical).");
                break;

            default:
                title.setText("No Data Available");
                description.setText("Sorry, information for this item is not available.");
                keyIngredients.setText("-");
                source.setText("-");
                break;
        }

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
