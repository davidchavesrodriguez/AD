package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

public class PrediccionAdapter implements JsonDeserializer<Prediccion> {
    @Override
    public Prediccion deserialize(JsonElement e, Type t, JsonDeserializationContext c) throws JsonParseException {
        JsonObject ojson = e.getAsJsonObject();
        JsonObject jsonPredicion = ojson.getAsJsonObject("predConcello");

        // Obtener nombre y id del concello
        String nomeConcello = (jsonPredicion.has("nome")
                && !jsonPredicion.get("nome").isJsonNull()) ? jsonPredicion.get("nome").getAsString() : null;
        int idConcello = jsonPredicion.get("idConcello").getAsInt();

        // Crear la instancia de Prediccion
        Prediccion prediccion = new Prediccion(new Concello(nomeConcello, idConcello));

        // Obtener y agregar la lista de predicciones diarias
        JsonArray array = jsonPredicion.getAsJsonArray("ListaPreDiaConcello");
        for (JsonElement elemento : array) {
            prediccion.addPredDiaConcello(c.deserialize(elemento.getAsJsonObject(), PrediccionDia.class));
        }

        return prediccion;
    }
}
