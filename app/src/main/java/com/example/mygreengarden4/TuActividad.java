package com.example.mygreengarden4;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TuActividad extends AppCompatActivity implements View.OnClickListener {

    // Frijoles
    private Button buttonAdicionFrijoles;
    private EditText editTextDateFrijoles;
    private ImageButton imageButtonCalendarioFrijoles;
    private TextView textViewProximaFechaFrijoles;

    // Lechuga
    private Button buttonAdicionLechuga;
    private EditText editTextDateLechuga;
    private ImageButton imageButtonCalendarioLechuga;
    private TextView textViewProximaFechaLechuga;

    // Tomate
    private Button buttonAdicionTomate;
    private EditText editTextDateTomate;
    private ImageButton imageButtonCalendarioTomate;
    private TextView textViewProximaFechaTomate;

    private ImageView imageViewAtras;
    private ImageView imageViewCasita;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_actividad);

        // Frijoles
        buttonAdicionFrijoles = findViewById(R.id.buttonAdicionFrijoles);
        editTextDateFrijoles = findViewById(R.id.editTextDateFrijoles);
        imageButtonCalendarioFrijoles = findViewById(R.id.imageButtonCalendarioFrijoles);
        textViewProximaFechaFrijoles = findViewById(R.id.textViewProximaFechaFrijoles);

        // Lechuga
        buttonAdicionLechuga = findViewById(R.id.buttonUltimoRiegoLechuga);
        editTextDateLechuga = findViewById(R.id.editTextDateLechuga);
        imageButtonCalendarioLechuga = findViewById(R.id.imageButtonCalendarioLechuga);
        textViewProximaFechaLechuga = findViewById(R.id.textViewProximaFechaLechuga);

        // Tomate
        buttonAdicionTomate = findViewById(R.id.buttonAccionTomate);
        editTextDateTomate = findViewById(R.id.editTextDateTomate);
        imageButtonCalendarioTomate = findViewById(R.id.imageButtonCalendarioTomate);
        textViewProximaFechaTomate = findViewById(R.id.textViewProximaFechaTomate);

        imageViewAtras = findViewById(R.id.imageViewAtras10);
        imageViewCasita = findViewById(R.id.imageViewCasita10);

        // Escuchadores de botones de calendario
        imageButtonCalendarioFrijoles.setOnClickListener(this);
        imageButtonCalendarioLechuga.setOnClickListener(this);
        imageButtonCalendarioTomate.setOnClickListener(this);

        // Escuchadores de botones de adición
        buttonAdicionFrijoles.setOnClickListener(v -> setFechaAdicion(dia, mes, ano, textViewProximaFechaFrijoles, 9)); // Cada 7-10 días
        buttonAdicionLechuga.setOnClickListener(v -> setFechaAdicion(dia, mes, ano, textViewProximaFechaLechuga, 3)); // Cada 3-4 días
        buttonAdicionTomate.setOnClickListener(v -> setFechaAdicion(dia, mes, ano, textViewProximaFechaTomate, 6)); // Cada 5-7 días

        // Escuchador del botón "Atras"
        imageViewAtras.setOnClickListener(v -> {
            Intent atras10 = new Intent(TuActividad.this, PrincipalCategorias.class);
            startActivity(atras10);
        });

        // Escuchador del botón "Casita"
        imageViewCasita.setOnClickListener(v -> {
            Intent casita1 = new Intent(TuActividad.this, Bienvenida.class);
            startActivity(casita1);
        });
    }

    // Método para actualizar la fecha de adición
    public void setFechaAdicion(int dia, int mes, int ano, TextView textView, int diasAdicionales) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        calendar.add(Calendar.DAY_OF_MONTH, diasAdicionales); // Añadir días específicos

        int diaAdicion = calendar.get(Calendar.DAY_OF_MONTH);
        int mesAdicion = calendar.get(Calendar.MONTH) + 1; // Mes es 0-indexado
        int anoAdicion = calendar.get(Calendar.YEAR);

        textView.setText("Próxima fecha es: " + diaAdicion + "/" + mesAdicion + "/" + anoAdicion);
    }

    @Override
    public void onClick(View v) {
        if (v == imageButtonCalendarioFrijoles || v == imageButtonCalendarioLechuga || v == imageButtonCalendarioTomate) {
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
                String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
                if (v == imageButtonCalendarioFrijoles) {
                    editTextDateFrijoles.setText("FECHA:  " + fecha);
                } else if (v == imageButtonCalendarioLechuga) {
                    editTextDateLechuga.setText("FECHA:  " + fecha);
                } else if (v == imageButtonCalendarioTomate) {
                    editTextDateTomate.setText("FECHA:  " + fecha);
                }
                dia = dayOfMonth;
                mes = month;
                ano = year;
            }, ano, mes, dia);
            datePickerDialog.show();
        }
    }
}
