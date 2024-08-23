package com.example.mygreengarden4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NutrientesPlanta extends AppCompatActivity {

    private ImageView volveratras;
    private ImageView principalCasita;
    private Button nutrientesagua;
    private Button nutrientesenergiaelectrica;
    private Button nutrientesabono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrientes_planta);

        // Inicialización de las vistas
        volveratras = findViewById(R.id.imageViewAtras4);
        principalCasita = findViewById(R.id.imageViewCasita4);
        nutrientesagua = findViewById(R.id.buttonAccionAgua);
        nutrientesenergiaelectrica = findViewById(R.id.buttonAccionEnergiaElectrica);
        nutrientesabono = findViewById(R.id.buttonCT);

        // Manejar el clic del botón "Agua"
        nutrientesagua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutrientesPlanta.this, Agua.class);
                startActivity(intent);
            }
        });

        // Manejar el clic del botón "Energía Eléctrica"
        nutrientesenergiaelectrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next1 = new Intent(NutrientesPlanta.this, Electricidad.class);
                startActivity(next1);
            }
        });

        // Manejar el clic del botón "Abono"
        nutrientesabono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next2 = new Intent(NutrientesPlanta.this, Abono.class); // Corregido: Se debe abrir la actividad "Abono"
                startActivity(next2);
            }
        });

        // Manejar el clic del ImageView "Volver Atrás"
        volveratras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras7 = new Intent(NutrientesPlanta.this, PrincipalCategorias.class);
                startActivity(atras7);
            }
        });

        // Manejar el clic del ImageView "Casita"
        principalCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio7 = new Intent(NutrientesPlanta.this, Bienvenida.class);
                startActivity(inicio7);
            }
        });
    }
}
