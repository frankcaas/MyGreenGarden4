package com.example.mygreengarden4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear archivo para usuarios y escribir los datos
        File usuariosFile = new File(getFilesDir(), "datos.txt");
        try {
            FileWriter writer = new FileWriter(usuariosFile);
            writer.append("root,root@root.com,toor,TOOR\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Consider adding a user notification or logging here
        }

        // Crear archivo para registro de agua
        File aguaFile = new File(getFilesDir(), "agua.txt");
        try {
            FileWriter writer = new FileWriter(aguaFile);
            writer.append("15,150000,enero\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Consider adding a user notification or logging here
        }

        // Crear archivo para registro de energia electrica
        File energiaFile = new File(getFilesDir(), "energiaelectrica.txt");
        try {
            FileWriter writer = new FileWriter(energiaFile);
            writer.append("15,150000,enero\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Consider adding a user notification or logging here
        }

        // Crear archivo para registro de abono
        File abonoFile = new File(getFilesDir(), "abono.txt");
        try {
            FileWriter writer = new FileWriter(abonoFile);
            writer.append("15,150000,enero\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Consider adding a user notification or logging here
        }

        // Crear archivo para registro de consejos frijol
        File consejosFrijolFile = new File(getFilesDir(), "consejosfrijol.txt");
        try {
            FileWriter writer = new FileWriter(consejosFrijolFile);

            // Lista de consejos frijol en un array
            String[] consejosFrijoles = {
                    "Suelo: Utiliza un suelo ligero y bien drenado para evitar encharcamientos.",
                    "Rotación de cultivos: Realiza rotación de cultivos para evitar enfermedades y plagas.",
                    "Riego: Proporciona aproximadamente 2.5 cm de agua por semana.",
                    "Luz solar: Asegúrate de que las plantas reciban al menos seis horas de luz solar diaria.",
                    "Cosecha: Cosecha los frijoles cuando las vainas estén llenas y firmes."
            };
            // Recorrer el array y agregar los consejos al archivo
            writer.append("Lista de consejos para frijol:\n");
            for (String consejo : consejosFrijoles) {
                writer.append(consejo).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Consider adding a user notification or logging here
        }

        // Crear archivo para registro de consejos lechuga
        File consejosLechugaFile = new File(getFilesDir(), "consejoslechuga.txt");
        try {
            FileWriter writer = new FileWriter(consejosLechugaFile);

            // Lista de consejos lechuga en un array
            String[] consejosLechuga = {
                    "Preparación del suelo: Asegúrate de que el suelo esté bien drenado y suelto.",
                    "Variedad: Elige la variedad de lechuga que mejor se adapte a tu clima.",
                    "Riego: Mantén el suelo ligeramente húmedo durante todo el ciclo de crecimiento.",
                    "Luz: Proporciona suficiente luz solar, al menos seis horas diarias.",
                    "Control de plagas: Monitorea regularmente para detectar plagas y enfermedades, y utiliza métodos orgánicos de control."
            };
            // Recorrer el array y agregar los consejos al archivo
            writer.append("Lista de consejos para lechuga:\n");
            for (String consejo : consejosLechuga) {
                writer.append(consejo).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Consider adding a user notification or logging here
        }

        // Crear archivo para registro de consejos tomate
        File consejosTomateFile = new File(getFilesDir(), "consejostomate.txt");
        try {
            FileWriter writer = new FileWriter(consejosTomateFile);

            // Lista de consejos tomate en un array
            String[] consejosTomate = {
                    "Ubicación: Planta los tomates en un lugar soleado y aireado.",
                    "Rotación de cultivos: No plantes tomates en el mismo lugar que la temporada pasada para evitar plagas y enfermedades.",
                    "Riego: Riega profundamente y con poca frecuencia, evitando mojar las hojas.",
                    "Tutorado: Usa tutores para mantener las plantas erguidas y facilitar la aireación.",
                    "Poda: Elimina los chupones (ramitas que crecen entre el tallo principal y los secundarios) para dirigir la energía hacia las ramas con frutos."
            };

            // Recorrer el array y agregar los consejos al archivo
            writer.append("Lista de consejos para tomate:\n");
            for (String consejo : consejosTomate) {
                writer.append(consejo).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Consider adding a user notification or logging here
        }

        // Uncomment if EdgeToEdge is necessary, and ensure proper import
        // EdgeToEdge.enable(this);

        Intent intent = new Intent(this, InicioSesion.class);
        startActivity(intent);
    }
}
