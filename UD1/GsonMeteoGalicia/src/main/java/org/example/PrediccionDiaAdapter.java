package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PrediccionDiaAdapter implements JsonDeserializer<PrediccionDia> {
    @Override
    public PrediccionDia deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonPrediccionDia = jsonElement.getAsJsonObject();

        // Creamos un objeto PrediccionDia
        PrediccionDia prediccionDia = new PrediccionDia();
        prediccionDia.setTemperaturaMaxima(jsonPrediccionDia.get("tMax").getAsInt());
        prediccionDia.setTemperaturaMinima(jsonPrediccionDia.get("tMin").getAsInt());
        prediccionDia.setUvMaximo(jsonPrediccionDia.get("uvMax").getAsInt());

        if (jsonPrediccionDia.has("nivelAviso") && !jsonPrediccionDia.get("nivelAviso").isJsonNull()) {
            prediccionDia.setUvMaximo(jsonPrediccionDia.get("nivelAviso").getAsInt());
        }

        // Obtenemos la fecha de la predicción llamando al método deserialize de la clase JsonDeserializationContext
        prediccionDia.setDataPredicion(context.deserialize(jsonPrediccionDia.get("dataPredicion"), LocalDate.class));

        return prediccionDia;
    }
}
