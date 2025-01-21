import jakarta.persistence.AttributeConverter;

public class EstadoCivilConverter implements AttributeConverter<EstadoCivil, String> {

    @Override
    public String convertToDatabaseColumn(EstadoCivil estadoCivil) {
        return estadoCivil.toString();
    }

    @Override
    public EstadoCivil convertToEntityAttribute(String dbData) {
        return EstadoCivil.valueOf(dbData);
    }
}
