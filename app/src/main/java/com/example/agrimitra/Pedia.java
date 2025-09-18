package com.example.agrimitra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedia);


        CardView c1=findViewById(R.id.c1);
        CardView c2=findViewById(R.id.c2);
        CardView c3=findViewById(R.id.c3);
        CardView c4=findViewById(R.id.c4);
        CardView c5=findViewById(R.id.c5);
        CardView c6=findViewById(R.id.c6);
        CardView c7=findViewById(R.id.c7);
        CardView c8=findViewById(R.id.c8);
        CardView c9=findViewById(R.id.c9);
        CardView c10=findViewById(R.id.c10);
        CardView c11=findViewById(R.id.c11);
        CardView c12=findViewById(R.id.c12);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Compost");
                startActivity(intent);
            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Animal Manure");
                startActivity(intent);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Green Manure");
                startActivity(intent);
            }
        });


        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Neem Oil");
                startActivity(intent);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Pyr");
                startActivity(intent);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Dia");
                startActivity(intent);
            }
        });


        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Urea");
                startActivity(intent);
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","DAP");
                startActivity(intent);
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","MOP");
                startActivity(intent);
            }
        });

        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Car");
                startActivity(intent);
            }
        });

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Chlor");
                startActivity(intent);
            }
        });

        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pedia.this, PediaDetailPage.class);
                intent.putExtra("topic","Gly");
                startActivity(intent);
            }
        });































        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}