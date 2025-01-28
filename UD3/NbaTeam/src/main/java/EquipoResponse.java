import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EquipoResponse {
    @SerializedName("Equipo")
    private List<Equipo> equipos;

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}