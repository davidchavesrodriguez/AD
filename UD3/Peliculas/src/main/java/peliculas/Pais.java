package peliculas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pais {
    @Id
    @Column(length = 125)
    private String pais;

    public Pais() {
    }

    public Pais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}
