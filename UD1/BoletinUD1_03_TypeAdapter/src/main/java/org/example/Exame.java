package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Exame {
    private String nombre;
    private LocalDateTime fecha;
    List<String> participantes = new ArrayList<>();

    public Exame() {
    }

    public Exame(String nombre, LocalDateTime fecha, List<String> participantes) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Exame{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", participantes=" + participantes +
                '}';
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }
}

