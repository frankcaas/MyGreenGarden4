package com.example.mygreengarden4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mygreengarden4.Modelos.Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InicioSesion extends AppCompatActivity {

    private EditText Nombre;
    private EditText Password;
    private TextView RegistrarAqui;
    private Button IniciarSesion;
    private ImageView imageAtras;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        // Enlazar los componentes del layout con el código Java
        Nombre = findViewById(R.id.EditTextNombre);
        Password = findViewById(R.id.editTextPassword);
        RegistrarAqui = findViewById(R.id.textViewRegistrarAqui);
        IniciarSesion = findViewById(R.id.buttonIniciarSesion);
        imageAtras = findViewById(R.id.imageViewAtras4);
        userManager = new UserManager(this);

        IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNombre = Nombre.getText().toString().trim();
                String inputPassword = Password.getText().toString().trim();

                if (userManager.loginUser(inputNombre, inputPassword)) {
                    Intent intent = new Intent(InicioSesion.this, PrincipalCategorias.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(InicioSesion.this, "Email o Password Invalidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RegistrarAqui.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioSesion.this, Registrarse.class);
                startActivity(intent);
            }
        });
    }
}