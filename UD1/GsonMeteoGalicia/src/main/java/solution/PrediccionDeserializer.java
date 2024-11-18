package solution;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PrediccionDeserializer implements JsonDeserializer<Prediccion> {

    @Override
    public Prediccion deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext contexto) throws JsonParseException {

        JsonObject pc = jsonElement.getAsJsonObject();

        // Extraer Concello
        JsonObject jsonPredicion = pc.getAsJsonObject("predConcello");
        String nome = jsonPredicion.has("nome") && !jsonPredicion.get("nome").isJsonNull()
                ? jsonPredicion.getAsJsonPrimitive("nome").getAsString()
                : "Desconocido";
        int idConcello = jsonPredicion.getAsJsonPrimitive("idConcello").getAsInt();
        Concello concello = new Concello(idConcello, nome);

        // Crear Prediccion
        Prediccion pr = new Prediccion(concello);

        // Extraer listaPredDiaConcello si está presente
        if (jsonPredicion.has("listaPredDiaConcello") && !jsonPredicion.get("listaPredDiaConcello").isJsonNull()) {
            jsonPredicion.getAsJsonArray("listaPredDiaConcello").forEach(e -> {
                PrediccionDia dia = contexto.deserialize(e, PrediccionDia.class);
                pr.addPredDiaConcello(dia);
            });
        }

        return pr;
    }

}
