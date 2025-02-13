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
        for (Cor cor : Cor.values()) {
            if (cor.getNome().equals(dbData)) {
                return cor;
            }
        }
        throw new IllegalArgumentException("Valor desconocido para Cor: " + dbData);
    }
}
