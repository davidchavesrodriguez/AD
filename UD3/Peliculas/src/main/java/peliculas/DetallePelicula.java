package peliculas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetallePelicula {

    private Short anoInicio;

    @Column(name = "outrasDuracions", length = 25)
    private String outrasDuracions;

    @Column(length = 2)
    private String video;

    @Column(length = 2)
    private String laserDisc;

    // Getters y setters
    public Short getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Short anoInicio) {
        this.anoInicio = anoInicio;
    }

    public String getOutrasDuracions() {
        return outrasDuracions;
    }

    public void setOutrasDuracions(String outrasDuracions) {
        this.outrasDuracions = outrasDuracions;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLaserDisc() {
        return laserDisc;
    }

    public void setLaserDisc(String laserDisc) {
        this.laserDisc = laserDisc;
    }

    @Override
    public String toString() {
        return "DetallePelicula{" +
                "anoInicio=" + anoInicio +
                ", outrasDuracions='" + outrasDuracions + '\'' +
                ", video='" + video + '\'' +
                ", laserDisc='" + laserDisc + '\'' +
                '}';
    }
}