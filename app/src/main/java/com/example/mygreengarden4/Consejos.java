package com.example.mygreengarden4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Consejos extends AppCompatActivity {

    private ImageView imageViewAtras;
    private ImageView imageViewCasita;
    private Button buttonCF;
    private Button buttonCL;
    private Button buttonCT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        imageViewAtras = findViewById(R.id.imageViewAtras4);
        imageViewCasita = findViewById(R.id.imageViewCasita4);
        buttonCF = findViewById(R.id.buttonCF); // Inicialización añadida
        buttonCL = findViewById(R.id.buttonCL); // Inicialización añadida
        buttonCT = findViewById(R.id.buttonCT); // Inicialización añadida

        buttonCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consejos.this, ConsejosFrijoles.class);
                startActivity(intent);
            }
        });

        buttonCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consejos.this, ConsejosLechuga.class);
                startActivity(intent);
            }
        });

        buttonCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consejos.this, ConsejosTomate.class);
                startActivity(intent);
            }
        });

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consejos.this, PrincipalCategorias.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consejos.this, Bienvenida.class);
                startActivity(intent);
            }
        });
    }
}
