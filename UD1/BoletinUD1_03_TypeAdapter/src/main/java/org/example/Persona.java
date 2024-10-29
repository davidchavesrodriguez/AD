package org.example;

import java.util.List;

public class Persona {
    private String nombre;
    private int edad;
    private Direccion direccion;
    private List<Persona> amigos;

    public Persona() {
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCidade() {
        return direccion != null ? direccion.getCiudad() : null;
    }

    public String getCalle() {
        return direccion != null ? direccion.getCalle() : null;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}' + direccion;
    }
}
