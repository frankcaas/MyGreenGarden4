package com.example.mygreengarden4.Modelos;

public class Usuario {
private String nombre;
private String correo;

private String password;

public Usuario(String nombre, String correo, String password){
    this.nombre = nombre;
    this.correo = correo;
    this.password = password;
    }

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getCorreo() {
    return correo;
}

public void setCorreo(String correo) {
    this.correo = correo;
}


public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}
