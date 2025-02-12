package peliculas;

import jakarta.persistence.AttributeConverter;

public class XeneroConverter implements AttributeConverter<Xenero, String> {

    @Override
    public String convertToDatabaseColumn(Xenero xenero) {
        return xenero.name().replace('_', ' ');
    }

    @Override
    public Xenero convertToEntityAttribute(String dbData) {
        return Xenero.valueOf(dbData.replace(' ', '_'));
    }

}
