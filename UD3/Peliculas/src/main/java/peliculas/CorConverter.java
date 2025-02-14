package peliculas;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CorConverter implements AttributeConverter<Cor, String> {

    @Override
    public String convertToDatabaseColumn(Cor cor) {
        if (cor == null) {
            return null;
        }
        return cor.getNome();
    }

    @Override
    public Cor convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        // Normaliza los espacios adicionales (reemplaza múltiples espacios por uno solo)
        String normalizedDbData = dbData.trim().replaceAll("\\s+", " ");

        // Depuración: muestra el valor normalizado
        System.out.println("Valor normalizado: '" + normalizedDbData + "'");

        // Compara los valores normalizados
        switch (normalizedDbData) {
            case "B/N":
                return Cor.BN;
            case "B/N e Color":
            case "B/N  y Color":
            case "B/N  y  Color":
            case "B/N y Color":
                return Cor.BN_Y_COLOR;
            case "Color":
                return Cor.COLOR;
            default:
                throw new IllegalArgumentException("Valor desconocido para Cor: " + normalizedDbData);
        }
    }

}
