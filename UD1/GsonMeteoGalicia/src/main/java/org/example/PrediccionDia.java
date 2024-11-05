package org.example;


import com.google.gson.JsonObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PrediccionDia {
    private LocalDate dataPredicion;// Guádala para que la ponga mejor como LocalDate
    private int nivelAviso;
    private int temperaturaMaxima;
    private int temperaturaMinima;
    private int uvMaximo;
    private List<VariableFranxa> listaVariableFranxa;

    public PrediccionDia() {
        listaVariableFranxa = new ArrayList<>();
    }

    public PrediccionDia(String dataPredicion) {
        this.dataPredicion = LocalDateTime.parse(dataPredicion).toLocalDate();
        listaVariableFranxa = new ArrayList<>();
    }

    public PrediccionDia(String dataPredicion, int nivelAviso, int tMax, int tMin, int uvMax, JsonObject ceo, JsonObject pchoiva, JsonObject tmaxFranxa, JsonObject tminFranxa, JsonObject vento) {
    }

    public LocalDate getDataPredicion() {
        return dataPredicion;
    }

    public void setDataPredicion(LocalDate dataPredicion) {
        this.dataPredicion = dataPredicion;
    }

    public int getNivelAviso() {
        return nivelAviso;
    }

    public void setNivelAviso(int nivelAviso) {
        this.nivelAviso = nivelAviso;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(int temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(int temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public int getUvMaximo() {
        return uvMaximo;
    }

    public void setUvMaximo(int uvMaximo) {
        this.uvMaximo = uvMaximo;
    }

    public List<VariableFranxa> getListaVariableFranxa() {
        return listaVariableFranxa;
    }

    public void setListaVariableFranxa(List<VariableFranxa> listaVariableFranxa) {
        this.listaVariableFranxa = listaVariableFranxa;
    }

    public void addVariableFranxa(VariableFranxa variableFranxa) {
        listaVariableFranxa.add(variableFranxa);
    }
    // toString
    @Override
    public String toString() {
        return dataPredicion +
                " (aviso: " + nivelAviso + ") " +
                ", Máxima: " + temperaturaMaxima +
                ", Mínima: " + temperaturaMinima +
                ", Índice ultravioleta máx: " + uvMaximo +
                " " + listaVariableFranxa.stream().collect(StringBuilder::new,
                (sb, vf) -> sb.append(vf).append(System.lineSeparator()), StringBuilder::append);
    }
}