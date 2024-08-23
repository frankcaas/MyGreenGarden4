package com.example.mygreengarden4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDate;
    private ImageButton buttonAccionAgua, buttonAccionEnergiaElectrica, buttonAccionEnergiaElectrica, buttonCF;

    private String[] dailyTips = {

            "Rotación de cultivos: Realiza rotación de cultivos para evitar enfermedades y plagas.",
            "Riego: Proporciona aproximadamente 2.5 cm de agua por semana.",
            "Luz solar: Asegúrate de que las plantas reciban al menos seis horas de luz solar diaria.",
            "Cosecha: Cosecha los frijoles cuando las vainas estén llenas y firmes."

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDate = findViewById(R.id.textViewDate);
        buttonAccionAgua = findViewById(R.id.buttonAccionAgua);
        buttonAccionEnergiaElectrica = findViewById(R.id.buttonAccionEnergiaElectrica);
        buttonEstadisticas = findViewById(R.id.buttonEstadisticas);
        buttonDailyTips = findViewById(R.id.buttonConsejos);
        buttonCF= findViewById(R.id.buttonCF);
        buttonCL= findViewById(R.id.buttonCL)
        buttonCT= findViewById(R.id.buttonCT)


        // Inicializar los SharedPreferences
        SharedPreferences preferences = getSharedPreferences("DailyTips", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Verificar si los consejos ya están guardados
        boolean isInitialized = preferences.getBoolean("isInitialized", false);

        if (!isInitialized) {
            // Guardar los consejos en SharedPreferences
            for (int i = 0; i < dailyTips.length; i++) {
                editor.putString("tip_" + i, dailyTips[i]);
            }
            editor.putBoolean("isInitialized", true);
            editor.apply();
        }

        // Obtener la fecha actual en español de Colombia
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "CO"));
        String currentDate = sdf.format(new Date());
        textViewDate.setText(currentDate);

        buttonAccionAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_agua.class);
                startActivity(intent);
            }
        });

        buttonAccionEnergiaElectrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ElectricityDataEntryActivity.class);
                startActivity(intent);
            }
        });

        buttonEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EstadisticasConsumo.class);
                startActivity(intent);
            }
        });

        buttonConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la fecha guardada en SharedPreferences
                String savedDate = preferences.getString("savedDate", "");

                // Comparar la fecha actual con la guardada
                if (!currentDate.equals(savedDate)) {
                    // Si es un nuevo día, guardar un nuevo consejo
                    Random random = new Random();
                    int randomIndex = random.nextInt(10);
                    String newTip = dailyTips[randomIndex];
                    editor.putString("currentTip", newTip);
                    editor.putString("savedDate", currentDate);
                    editor.apply();
                }

                Intent intent = new Intent(MainActivity.this, Consejos.class);
                startActivity(intent);
            }
        });
    }

