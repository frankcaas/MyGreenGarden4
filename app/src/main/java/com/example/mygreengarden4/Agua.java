package com.example.mygreengarden4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Agua extends AppCompatActivity {
    private EditText editTextConsumoMes;
    private EditText editTextPrecioM3;
    private Spinner spinnerMes;
    private Button buttonCalcularValor;
    private TextView textViewResultado;
    private ImageView imageViewAtras1; // Declaración de la variable
    private ImageView imageViewCasita; // Declaración de la variable

    public Agua() {

    }

    public Agua(float volumen, float precio, String mes) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agua);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextConsumoMes = findViewById(R.id.editTextConsumoMesKW);
        editTextPrecioM3 = findViewById(R.id.editTextTiempoHoras);
        spinnerMes = findViewById(R.id.SpinnerMes);
        buttonCalcularValor = findViewById(R.id.buttonCalcularValor);
        textViewResultado = findViewById(R.id.TextViewResultado);
        imageViewAtras1 = findViewById(R.id.imageViewAtras4); // Inicialización de la variable
        imageViewCasita = findViewById(R.id.imageViewCasita4); // Inicialización de la variable

        // Configurar el Spinner de meses
        String[] meses = getResources().getStringArray(R.array.meses_del_año);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, meses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(adapter);

        // Manejar el evento de selección del Spinner
        spinnerMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mesSeleccionado = meses[position];
                // Usa el mesSeleccionado para tus cálculos
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada si no se selecciona nada
            }
        });

        // Manejar el clic del botón "CALCULAR VALOR"
        buttonCalcularValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores del consumo, precio y mes seleccionado
                String consumo = editTextConsumoMes.getText().toString();
                String precio = editTextPrecioM3.getText().toString();
                String mes = spinnerMes.getSelectedItem().toString();

                // Realizar los cálculos
                double valor = Double.parseDouble(consumo) * Double.parseDouble(precio);

                // Mostrar el resultado en textViewResultado
                textViewResultado.setText("El valor a pagar por el mes de " + mes + " es: " + valor);
            }
        });

        // Manejar el clic del ImageView "Atrás"
        imageViewAtras1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras9 = new Intent(Agua.this, NutrientesPlanta.class);
                startActivity(atras9);
            }
        });

        // Manejar el clic del ImageView "Casita"
        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio8 = new Intent(Agua.this, Bienvenida.class);
                startActivity(inicio8);
            }
        });
    }

    public String getMes() {
        // Debes implementar la lógica para obtener el mes.
        return spinnerMes.getSelectedItem().toString();
    }

    public float getVolumen() {
        // Debes implementar la lógica para obtener el volumen.
        return Float.parseFloat(editTextConsumoMes.getText().toString());
    }

    public float getPrecio() {
        // Debes implementar la lógica para obtener el precio.
        return Float.parseFloat(editTextPrecioM3.getText().toString());
    }
}
