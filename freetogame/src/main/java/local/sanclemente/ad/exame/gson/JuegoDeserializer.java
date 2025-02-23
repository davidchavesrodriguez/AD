package local.sanclemente.ad.exame.gson;

import com.google.gson.*;
import local.sanclemente.ad.exame.model.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JuegoDeserializer implements JsonDeserializer<Juego> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public Juego deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        int idJuego = jsonObject.get("idJuego").getAsInt();
        String titulo = jsonObject.get("titulo").getAsString();
        String miniatura = jsonObject.has("miniatura") ? jsonObject.get("miniatura").getAsString() : null;
        String estado = jsonObject.has("estado") ? jsonObject.get("estado").getAsString() : null;
        String descripcionCorta = jsonObject.has("descripcionCorta") ? jsonObject.get("descripcionCorta").getAsString() : null;
        String descripcion = jsonObject.has("descripcion") ? jsonObject.get("descripcion").getAsString() : null;
        String url = jsonObject.has("url") ? jsonObject.get("url").getAsString() : null;
        String editor = jsonObject.has("editor") ? jsonObject.get("editor").getAsString() : null;
        String desarrollador = jsonObject.has("desarrollador") ? jsonObject.get("desarrollador").getAsString() : null;

        LocalDate fecha = null;
        if (jsonObject.has("fecha") && !jsonObject.get("fecha").isJsonNull()) {
            fecha = LocalDate.parse(jsonObject.get("fecha").getAsString(), DATE_FORMATTER);
        }

        // Deserializar objetos anidados
        Genero genero = context.deserialize(jsonObject.get("genero"), Genero.class);
        Plataforma plataforma = context.deserialize(jsonObject.get("plataforma"), Plataforma.class);
        RequisitosSistema requisitosSistema = jsonObject.has("requisitosSistema") ?
                context.deserialize(jsonObject.get("requisitosSistema"), RequisitosSistema.class) : null;

        // Deserializar la lista de imágenes
        List<Imagen> imagenes = new ArrayList<>();
        if (jsonObject.has("imagenes") && jsonObject.get("imagenes").isJsonArray()) {
            JsonArray imagenesArray = jsonObject.getAsJsonArray("imagenes");
            for (JsonElement imgElement : imagenesArray) {
                Imagen imagen = context.deserialize(imgElement, Imagen.class);
                imagenes.add(imagen);
            }
        }

        return new Juego(idJuego, genero, plataforma, titulo, miniatura, estado, descripcionCorta, descripcion, url, editor, desarrollador, fecha, imagenes, requisitosSistema);
    }
}
