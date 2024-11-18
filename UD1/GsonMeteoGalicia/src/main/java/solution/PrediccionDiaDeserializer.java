package solution;

import com.google.gson.*;
import solution.VariableFranxa;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PrediccionDiaDeserializer implements JsonDeserializer<PrediccionDia> {

    private VariableFranxa getVariableFranxa(VariableMeteo variableMeteo, JsonObject varFranxaJsonObject) {
        int manha = varFranxaJsonObject.get("manha").getAsInt();
        int noite = varFranxaJsonObject.get("noite").getAsInt();
        int tarde = varFranxaJsonObject.get("tarde").getAsInt();

        return new VariableFranxa(variableMeteo, manha, tarde, noite);
    }

    @Override
    public PrediccionDia deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        // Convertir el JsonElement en un JsonObject
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Comprobar y obtener la fecha
        JsonElement fechaElement = jsonObject.get("dataPredicion");
        if (fechaElement == null || !fechaElement.isJsonPrimitive()) {
            throw new JsonParseException("Campo 'dataPredicion' no encontrado o no es una cadena válida.");
        }

        String fecha = fechaElement.getAsString();
        fecha = fecha.split("T")[0];  // Eliminar la parte de la hora
        PrediccionDia prediccionDia = new PrediccionDia();
        prediccionDia.setDataPredicion(LocalDate.parse(fecha));

        // Recuperar otros campos
        JsonElement nivelAvisoElement = jsonObject.get("nivelAviso");
        prediccionDia.setNivelAviso(nivelAvisoElement != null && !nivelAvisoElement.isJsonNull() ? nivelAvisoElement.getAsInt() : 0);

        JsonElement temperaturaMaximaElement = jsonObject.get("tMax");
        prediccionDia.settMax(temperaturaMaximaElement != null && !temperaturaMaximaElement.isJsonNull() ? temperaturaMaximaElement.getAsInt() : 0);

        JsonElement temperaturaMinimaElement = jsonObject.get("tMin");
        prediccionDia.settMin(temperaturaMinimaElement != null && !temperaturaMinimaElement.isJsonNull() ? temperaturaMinimaElement.getAsInt() : 0);

        JsonElement uvMaximoElement = jsonObject.get("uvMax");
        prediccionDia.setUvMaximo(uvMaximoElement != null && !uvMaximoElement.isJsonNull() ? uvMaximoElement.getAsInt() : 0);

        // Recuperar las variables de franxa para cada tipo de variable meteorológica
        for (VariableMeteo variable : VariableMeteo.values()) {
            if (jsonObject.has(variable.getNomeVariableMeteo())) {
                JsonObject varFranxaJsonObject = jsonObject.getAsJsonObject(variable.getNomeVariableMeteo());
                VariableFranxa variableFranxa = getVariableFranxa(variable, varFranxaJsonObject);
                prediccionDia.ad(variable, variableFranxa);
            }
        }

        return prediccionDia;
    }

}
