package com.example.mygreengarden4.Modelos;

public class Electricidad {
    private float kilovatios;
    private float precio;
    private String mes;

    public Electricidad(float kilovatios, float precio, String mes) {
        this.kilovatios = kilovatios;
        this.precio = precio;
        this.mes = mes;
    }

    public float getKilovatios() {
        return kilovatios;
    }

    public float getPrecio() {
        return precio;
    }

    public String getMes() {
        return mes;
    }
}
