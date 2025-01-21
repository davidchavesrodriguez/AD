import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, Character> {
    @Override
    public Character convertToDatabaseColumn(Sexo sexo) {
        return sexo == Sexo.HOME ? 'H' : 'M';
    }

    @Override
    public Sexo convertToEntityAttribute(Character dbData) {
        return dbData == 'H' ? Sexo.HOME : Sexo.MULLER;
    }

}
