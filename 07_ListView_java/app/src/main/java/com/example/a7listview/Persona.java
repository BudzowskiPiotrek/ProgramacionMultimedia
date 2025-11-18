package com.example.a7listview;

public class Persona {
    private String nombre;
    private String apellidos;


    Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;

    }
    String getNombre() {
        return this.nombre;
    }
    String getApellidos() {
        return this.apellidos;
    }

}
