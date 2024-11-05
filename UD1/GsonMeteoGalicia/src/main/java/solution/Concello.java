package solution;

public class Concello {
    private int idConcello;
    private String nombreConcello;

    public Concello() {
    }

    public Concello(int idConcello, String nombreConcello) {
        this.idConcello = idConcello;
        this.nombreConcello = nombreConcello;
    }

    public int getIdConcello() {
        return idConcello;
    }

    public void setIdConcello(int idConcello) {
        this.idConcello = idConcello;
    }

    public String getNombreConcello() {
        return nombreConcello;
    }

    public void setNombreConcello(String nombreConcello) {
        this.nombreConcello = nombreConcello;
    }

    @Override
    public String toString() {
        return "Concello{" +
                "idConcello=" + idConcello +
                ", nombreConcello='" + nombreConcello + '\'' +
                '}';
    }
}
