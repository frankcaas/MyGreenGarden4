package com.example.mygreengarden4.Modelos;

import android.util.Log;

public class Abono {
    private float kg; // Cantidad de abono en kilogramos
    private float precioPorKg; // Precio por kilogramo
    private String mes; // Mes del consumo

    private static final String TAG = "Abono";

    public Abono(float kg, float precioPorKg, String mes) {
        this.kg = kg;
        this.precioPorKg = precioPorKg;
        this.mes = mes;

        // Mensajes de depuración
        Log.d(TAG, "Abono creado: kg = " + kg + ", precioPorKg = " + precioPorKg + ", mes = " + mes);
    }

    public float getKg() {
        Log.d(TAG, "getKg() llamado. kg = " + kg);
        return kg;
    }

    public void setKg(float kg) {
        Log.d(TAG, "setKg() llamado. Nuevo valor: kg = " + kg);
        this.kg = kg;
    }

    public float getPrecioPorKg() {
        Log.d(TAG, "getPrecioPorKg() llamado. precioPorKg = " + precioPorKg);
        return precioPorKg;
    }

    public void setPrecioPorKg(float precioPorKg) {
        Log.d(TAG, "setPrecioPorKg() llamado. Nuevo valor: precioPorKg = " + precioPorKg);
        this.precioPorKg = precioPorKg;
    }

    public String getMes() {
        Log.d(TAG, "getMes() llamado. mes = " + mes);
        return mes;
    }

    public void setMes(String mes) {
        Log.d(TAG, "setMes() llamado. Nuevo valor: mes = " + mes);
        this.mes = mes;
    }

    public float calcularCostoTotal() {
        float costoTotal = this.kg * this.precioPorKg;
        Log.d(TAG, "calcularCostoTotal() llamado. costoTotal = " + costoTotal);
        return costoTotal;
    }
}
