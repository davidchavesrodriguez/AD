package solution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prediccion {
    private static final String SEPARADOR = "------------------------------";

    private Concello concello;
    private List<PrediccionDia> listaPrediccionsDia;

    public Prediccion() {
        listaPrediccionsDia = new ArrayList<>();
    }

    public Prediccion(Concello concello) {
        this.concello = concello;
        listaPrediccionsDia = new ArrayList<>();
    }

    public Prediccion(Concello concello, List<PrediccionDia> listaPrediccionsDia) {
        this.concello = concello;
        this.listaPrediccionsDia = listaPrediccionsDia;
    }

    public Concello getConcello() {
        return concello;
    }

    public void setConcello(Concello concello) {
        this.concello = concello;
    }

    public List<PrediccionDia> getListaPrediccionsDia() {
        return listaPrediccionsDia;
    }

    public void setListaPrediccionsDia(List<PrediccionDia> listaPrediccionsDia) {
        this.listaPrediccionsDia = listaPrediccionsDia;
    }

    public void addPredDiaConcello(PrediccionDia predDia){
        listaPrediccionsDia.add(predDia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediccion that = (Prediccion) o;
        return Objects.equals(concello, that.concello);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(concello);
    }

    @Override
    public String toString() {
        return concello + System.lineSeparator() + SEPARADOR + System.lineSeparator()
                + listaPrediccionsDia.stream().collect(StringBuilder::new,
                (sb, pd) -> sb.append(pd).append(System.lineSeparator())
                        .append(SEPARADOR).append(System.lineSeparator()), StringBuilder::append);
    }

}

