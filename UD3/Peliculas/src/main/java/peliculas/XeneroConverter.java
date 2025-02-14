package peliculas;

import jakarta.persistence.AttributeConverter;

public class XeneroConverter implements AttributeConverter<Xenero, String> {

    @Override
    public String convertToDatabaseColumn(Xenero xenero) {
        // Devuelve la descripción para la base de datos
        return xenero.getDescricion();
    }

    @Override
    public Xenero convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        // Normaliza los espacios adicionales (reemplaza múltiples espacios por uno solo)
        String normalizedDbData = dbData.trim().replaceAll("\\s+", " ");

        // Usa el método fromString para encontrar el valor del enum correspondiente
        return Xenero.fromString(normalizedDbData);
    }
}
