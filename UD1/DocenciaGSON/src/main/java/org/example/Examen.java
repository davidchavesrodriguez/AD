package org.example;

import java.util.Date;
import java.util.List;

public class Examen {
    private String materia;
    private Date fecha;
    private List<String> participantes;

    public Examen() {
    }

    public Examen(String materia, Date fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Examen{");
        sb.append("fecha=").append(fecha);
        sb.append(", participantes=").append(participantes);
        sb.append('}');
        return sb.toString();
    }

}
