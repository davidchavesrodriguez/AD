package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PredicionAdapter implements JsonDeserializer<Prediccion> {
    @Override
    public Prediccion deserialize(JsonElement e, Type t, JsonDeserializationContext c) throws JsonParseException {
        JsonObject ojson = e.getAsJsonObject();
        JsonObject jsonPredicion = ojson.getAsJsonObject("predConcello");
        String nomeConcello = (jsonPredicion.has("nome")
                && !jsonPredicion.get("nome").isJsonNull()) ? jsonPredicion.get("nome").getAsString() : null;
        int idConcello = jsonPredicion.get("idConcello").getAsInt();
        Prediccion prediccion = new Prediccion(new Concello(nomeConcello, idConcello));


        return prediccion;
    }
}