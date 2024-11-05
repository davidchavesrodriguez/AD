package org.example;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrediccionAdapter implements JsonDeserializer<Prediccion> {

    @Override
    public Prediccion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject mainJsonObject = jsonElement.getAsJsonObject();

        // Extrae el objeto Concello
        JsonObject concelloJson = mainJsonObject.getAsJsonObject("concello");
        Concello concello = new Concello();
        if (concelloJson != null) {
            concello.setNomeConcello(concelloJson.get("nome").getAsString());
            concello.setIdConcello(concelloJson.get("id").getAsInt());
        }

        // Extrae la lista de predicciones diarias
        List<PrediccionDia> listaPredDiaConcello = new ArrayList<>();
        for (JsonElement diaElement : mainJsonObject.getAsJsonArray("prediccionDias")) {
            PrediccionDia dia = new PrediccionDia();
            JsonObject diaJson = diaElement.getAsJsonObject();

            // Maneja los posibles valores nulos
            if (diaJson.has("dataPredicion") && !diaJson.get("dataPredicion").isJsonNull()) {
                dia.setDataPredicion(LocalDate.parse(diaJson.get("dataPredicion").getAsString()));
            }
            if (diaJson.has("temperaturaMaxima") && !diaJson.get("temperaturaMaxima").isJsonNull()) {
                dia.setTemperaturaMaxima((int) diaJson.get("temperaturaMaxima").getAsDouble());
            }
            if (diaJson.has("temperaturaMinima") && !diaJson.get("temperaturaMinima").isJsonNull()) {
                dia.setTemperaturaMinima((int) diaJson.get("temperaturaMinima").getAsDouble());
            }

            listaPredDiaConcello.add(dia);
        }

        Prediccion prediccion = new Prediccion();
        prediccion.setConcello(concello);
        prediccion.setListaPredDiaConcello(listaPredDiaConcello);

        return prediccion;
    }
}
