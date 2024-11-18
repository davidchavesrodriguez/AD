package solution;

public class Concello {
    private int idConcello;
    private String nomeConcello;

    public Concello() {

    }

    public Concello(int idConcello, String nomeConcello) {
        this.idConcello = idConcello;
        this.nomeConcello = nomeConcello;
    }

    public int getIdConcello() {
        return idConcello;
    }

    public void setIdConcello(int idConcello) {
        this.idConcello = idConcello;
    }

    public String getNomeConcello() {
        return nomeConcello;
    }

    public void setNomeConcello(String nomeConcello) {
        this.nomeConcello = nomeConcello;
    }

    @Override
    public String toString() {
        return "\nConcello: " + nomeConcello + "[" + idConcello + "]";
    }


}
