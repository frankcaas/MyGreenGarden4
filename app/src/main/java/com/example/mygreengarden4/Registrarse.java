package com.example.mygreengarden4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Registrarse extends AppCompatActivity {

    private EditText nombre;
    private EditText correo;
    private EditText password;
    private EditText confirmarPassword;
    private CheckBox aceptarTerminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        // Obtener referencias a los elementos de la interfaz
        nombre = findViewById(R.id.EditTextNombre);
        correo = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        confirmarPassword = findViewById(R.id.editTextConfirmarPassword);
        aceptarTerminos = findViewById(R.id.checkBoxAcepto);
        Button botonRegistrarse = findViewById(R.id.buttonRegistrarse);
        ImageView imageViewAtras = findViewById(R.id.imageViewAtras4);
        ImageView imageViewCasita = findViewById(R.id.imageViewCasita4);

        // Configurar el botón de registro
        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aceptarTerminos.isChecked()) {
                    if (!nombre.getText().toString().isEmpty() && !correo.getText().toString().isEmpty() &&
                            !password.getText().toString().isEmpty() && !confirmarPassword.getText().toString().isEmpty()) {

                        if (password.getText().toString().equals(confirmarPassword.getText().toString())) {
                            if (datosExisten(correo.getText().toString(), nombre.getText().toString())) {
                                Toast.makeText(getApplicationContext(), "El correo o el nombre ya existen", Toast.LENGTH_SHORT).show();
                            } else {
                                guardarRegistro(nombre.getText().toString(), correo.getText().toString(), password.getText().toString());
                                Intent intent = new Intent(Registrarse.this, InicioSesion.class);
                                startActivity(intent);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar los botones de navegación
        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrarse.this, InicioSesion.class);
                startActivity(intent);
            }
        });

        imageViewCasita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registrarse.this, Bienvenida.class);
                startActivity(intent);
            }
        });
    }

    private boolean datosExisten(String correo, String nombreUsuario) {
        File file = new File(getFilesDir(), "datos.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> existingEmails = new ArrayList<>();
            List<String> existingNombresUsuarios = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                existingEmails.add(data[1]);
                existingNombresUsuarios.add(data[0]);
            }

            bufferedReader.close();

            return existingEmails.contains(correo) || existingNombresUsuarios.contains(nombreUsuario);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void guardarRegistro(String nombre, String correo, String password) {
        File file = new File(getFilesDir(), "datos.txt");

        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String nuevoRegistro = nombre + "," + correo + "," + password + "\n";
            bufferedWriter.write(nuevoRegistro);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
