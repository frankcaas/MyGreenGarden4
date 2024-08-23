package com.example.mygreengarden4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Electricidad extends AppCompatActivity {

    private EditText consumoKW;
    private EditText precioKWh;
    private EditText tiempoUsoHoras;
    private Spinner spinnerMes;
    private TextView resultado;
    private Button calcularValor;
    private ImageView imageAtras;
    private ImageView imageCasita;

    public Electricidad(float kilovatios, float precio, String mes) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricidad);

        // Enlazar los componentes del layout con el código Java
        consumoKW = findViewById(R.id.editTextConsumoMesKW);
        precioKWh = findViewById(R.id.editTextPrecioKWh);
        tiempoUsoHoras = findViewById(R.id.editTextTiempoHoras);
        spinnerMes = findViewById(R.id.SpinnerMes);
        resultado = findViewById(R.id.TextViewResultado);
        calcularValor = findViewById(R.id.buttonCalcularValor);
        imageAtras = findViewById(R.id.imageViewAtras4);
        imageCasita = findViewById(R.id.imageViewCasita4);

        // Configurar el evento de clic para el botón "Calcular Valor"
        calcularValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String consumoKWStr = consumoKW.getText().toString().trim();
                String precioKWhStr = precioKWh.getText().toString().trim();
                String tiempoUsoHorasStr = tiempoUsoHoras.getText().toString().trim();

                if (consumoKWStr.isEmpty() || precioKWhStr.isEmpty() || tiempoUsoHorasStr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Convertir los valores ingresados a tipos numéricos
                    double consumoKW = Double.parseDouble(consumoKWStr);
                    double precioKWh = Double.parseDouble(precioKWhStr);
                    double tiempoUsoHoras = Double.parseDouble(tiempoUsoHorasStr);

                    // Calcular el valor total
                    double valorTotal = consumoKW * precioKWh * tiempoUsoHoras;

                    // Mostrar el resultado
                    resultado.setText("Resultado: $" + String.format("%.2f", valorTotal));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Por favor ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar la imagen "Atrás"
        imageAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a la pantalla anterior
                finish(); // O puedes iniciar una nueva actividad si lo prefieres
            }
        });

        // Configurar la imagen "Casita"
        imageCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a la pantalla de inicio
                Intent casita10 = new Intent(Electricidad.this, PrincipalCategorias.class);
                startActivity(casita10);
            }
        });
    }

    // Método para obtener el mes seleccionado en el Spinner
    public String getMes() {
        return spinnerMes.getSelectedItem().toString();
    }

    // Método para obtener el consumo en kilovatios (implementación podría variar según contexto)
    public double getKilovatios() {
        String consumoKWStr = consumoKW.getText().toString().trim();
        return Double.parseDouble(consumoKWStr);
    }

    // Método para obtener el precio del kilowatt-hora
    public double getPrecio() {
        String precioKWhStr = precioKWh.getText().toString().trim();
        if (precioKWhStr.isEmpty()) {
            return 0.0; // O puedes manejar el caso de un campo vacío de otra manera
        }
        return Double.parseDouble(precioKWhStr);
    }
}
