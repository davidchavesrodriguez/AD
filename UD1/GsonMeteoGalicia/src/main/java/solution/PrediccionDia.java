package solution;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PrediccionDia {
    private LocalDate dataPredicion;
    private int nivelAviso;
    private int tMax;
    private int tMin;
    private int uvMaximo;
    private List<VariableFranxa> listaVariablesFranxa;

    public PrediccionDia() {
        listaVariablesFranxa = new ArrayList<>();
    }

    public PrediccionDia(String dataPredicion) {
        this.dataPredicion = LocalDateTime.parse(dataPredicion).toLocalDate();
        listaVariablesFranxa = new ArrayList<>();
    }

    public PrediccionDia(LocalDate dataPredicion, int nivelAviso, int tMax, int tMin, int uvMaximo, List<VariableFranxa> listaVariablesFranxa) {
        this.dataPredicion = dataPredicion;
        this.nivelAviso = nivelAviso;
        this.tMax = tMax;
        this.tMin = tMin;
        this.uvMaximo = uvMaximo;
        this.listaVariablesFranxa = listaVariablesFranxa;
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

    public int gettMin() {
        return tMin;
    }

    public void settMin(int tMin) {
        this.tMin = tMin;
    }

    public int gettMax() {
        return tMax;
    }

    public void settMax(int tMax) {
        this.tMax = tMax;
    }

    public int getUvMaximo() {
        return uvMaximo;
    }

    public void setUvMaximo(int uvMaximo) {
        this.uvMaximo = uvMaximo;
    }

    public List<VariableFranxa> getListaVariablesFranxa() {
        return listaVariablesFranxa;
    }

    public void setListaVariablesFranxa(List<VariableFranxa> listaVariablesFranxa) {
        this.listaVariablesFranxa = listaVariablesFranxa;
    }

    public void addVariableFranxa(VariableMeteo variableMeteo, VariableFranxa variableFranxa) {
        variableFranxa.setVariableMeteo(variableMeteo);
        listaVariablesFranxa.add(variableFranxa);
    }

    @Override
    public String toString() {
        return dataPredicion +
                ": nivelAviso=" + nivelAviso +
                ", temperaturaMaxima=" + tMax +
                ", temperaturaMinima=" + tMin +
                ", uvMaximo=" + uvMaximo +
                ", listaVariablesFranxa=" + listaVariablesFranxa +
                '}';
    }

//    public static void main(String[] args) {
//        PrediccionDia prediccionDia= new PrediccionDia("2000-11-11T00:00:00");
//        System.out.println(prediccionDia);
//    }
}
