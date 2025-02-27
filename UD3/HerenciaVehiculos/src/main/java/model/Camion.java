package model;

import jakarta.persistence.Entity;

@Entity
public class Camion extends Vehiculo{
    private double carga;
    private int ejes;

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public int getEjes() {
        return ejes;
    }

    public void setEjes(int ejes) {
        this.ejes = ejes;
    }
}
