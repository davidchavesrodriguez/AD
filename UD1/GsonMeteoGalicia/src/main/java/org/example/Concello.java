package org.example;

public class Concello {
    private String nomeConcello;
    private Integer idConcello;

    public Concello() {
    }

    public Concello(String nomeConcello) {
        this.nomeConcello = nomeConcello;
    }

    public Concello(String nomeConcello, Integer idConcello) {
        this.nomeConcello = nomeConcello;
        this.idConcello = idConcello;
    }

    public String getNomeConcello() {
        return nomeConcello;
    }

    public void setNomeConcello(String nomeConcello) {
        this.nomeConcello = nomeConcello;
    }

    public Integer getIdConcello() {
        return idConcello;
    }

    public void setIdConcello(Integer idConcello) {
        this.idConcello = idConcello;
    }

    @Override
    public String toString() {
        return "Concello='" + nomeConcello + " {" + idConcello + '}';
    }
}
