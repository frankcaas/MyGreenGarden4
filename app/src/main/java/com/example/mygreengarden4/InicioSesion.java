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

        // Crear intents para las actividades de registro de usuario y principal
        Intent registroIntent = new Intent(this, Registrarse.class);
        Intent principalIntent = new Intent(this, PrincipalCategorias.class);

        // Leer los datos del archivo
        File file = new File(getFilesDir(), "datos.txt");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en los datos del usuario separados por comas
                String[] userData = line.split(",");
                if (userData.length >= 3) { // Verificación mínima para asegurar que hay suficientes datos
                    String nombre = userData[0].trim();
                    String correo = userData[1].trim();
                    String passwordData = userData[2].trim();
                    // Crear un objeto Usuario y añadirlo a la lista de usuarios
                    Usuario nuevoUsuario = new Usuario(nombre, correo, passwordData);
                    usuarios.add(nuevoUsuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Configurar el evento de clic para el botón de inicio de sesión
        IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputNombre = Nombre.getText().toString().trim();
                String inputPassword = Password.getText().toString().trim();

                if (inputNombre.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean usuarioEncontrado = false;
                for (Usuario usuario : usuarios) {
                    if (usuario.getPassword().equals(inputPassword) &&
                            (usuario.getNombre().equals(inputNombre) || usuario.getCorreo().equals(inputNombre))) {
                        // Si se encuentra una coincidencia, iniciar la actividad principal y salir del bucle
                        startActivity(principalIntent);
                        usuarioEncontrado = true;
                        break;
                    }
                }

                if (!usuarioEncontrado) {
                    // Si no se encontró una coincidencia, mostrar un mensaje de error utilizando Toast
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar el evento de clic para el enlace de registro
        RegistrarAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad de registro de usuario
                startActivity(registroIntent);
            }
        });

        // Configurar la imagen "Atrás"
        imageAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioSesion.this, Bienvenida.class);
                startActivity(intent);
            }
        });
    }
}
