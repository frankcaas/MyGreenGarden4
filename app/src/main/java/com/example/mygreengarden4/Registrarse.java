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

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Registrarse extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private CheckBox checkBoxTerms;
    private Button buttonRegistrarse;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        checkBoxTerms = findViewById(R.id.checkBoxAcepto);
        buttonRegistrarse = findViewById(R.id.buttonRegistrarse);
        userManager = new UserManager(this);

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Registrarse.this, "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(Registrarse.this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Registrarse.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                } else if (!checkBoxTerms.isChecked()) {
                    Toast.makeText(Registrarse.this, "Debe aceptar los Términos y Condiciones", Toast.LENGTH_SHORT).show();
                } else {
                    registrarUsuario(email, password);
                }
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void registrarUsuario(String email, String password) {
        userManager.registerUser(email, password);
        Toast.makeText(Registrarse.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        finish();
    }
}