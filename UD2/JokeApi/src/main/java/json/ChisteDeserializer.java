package json;

import com.google.gson.*;
import entities.Chiste;
import entities.Flag;

import java.lang.reflect.Type;

public class ChisteDeserializer implements JsonDeserializer<Chiste> {
    @Override
    public Chiste deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Crear una nueva instancia de Chiste
        Chiste chisteDeserialized = new Chiste();

        // Mapear los campos directamente
        int id = jsonObject.get("id").getAsInt();
        String categoria = jsonObject.get("category").getAsString();
        String idioma = jsonObject.get("lang").getAsString();
        String tipo = jsonObject.get("type").getAsString();
        String chiste = jsonObject.has("setup") ? jsonObject.get("setup").getAsString() : "";
        String respuesta = jsonObject.has("delivery") ? jsonObject.get("delivery").getAsString() : "";

        // Asignar los valores al objeto deserializado
        chisteDeserialized.setId(id);
        chisteDeserialized.setCategoria(categoria);
        chisteDeserialized.setLenguaje(idioma);
        chisteDeserialized.setTipo(tipo);
        chisteDeserialized.setChiste(chiste);
        chisteDeserialized.setRespuesta(respuesta);

        // Procesar los flags (dentro de un objeto en el JSON)
        if (jsonObject.has("flags")) {
            JsonObject flagsObject = jsonObject.getAsJsonObject("flags");
            flagsObject.entrySet().forEach(entry -> {
                if (entry.getValue().getAsBoolean()) {
                    // Solo añadir los flags que sean `true`
                    Flag flag = Flag.getFlag(entry.getKey());
                    if (flag != null) {
                        chisteDeserialized.addFlag(flag);
                    }
                }
            });
        }

        return chisteDeserialized;
    }
}
