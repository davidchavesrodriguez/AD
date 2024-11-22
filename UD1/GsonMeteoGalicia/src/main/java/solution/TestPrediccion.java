package solution;

import com.google.gson.*;
import java.io.FileReader;
import java.io.Reader;

public class TestPrediccion {

    public static void main(String[] args) {
        try {
            // Ruta del archivo JSON
            String rutaArchivo = "src/main/resources/prediccion.json";

            // Leer el archivo JSON
            Reader reader = new FileReader(rutaArchivo);

            // Crear el Gson con el deserializador personalizado
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(PrediccionDia.class, new PrediccionDiaDeserializer())
                    .create();

            // Deserializar el JSON
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonObject predConcello = jsonObject.getAsJsonObject("predConcello");

            // Mostrar información general del concello
            int idConcello = predConcello.get("idConcello").getAsInt();
            String nome = predConcello.get("nome").getAsString();
            System.out.println("Concello: " + nome + "[" + idConcello + "]");

            // Obtener lista de predicciones diarias
            JsonArray listaPredDiaConcello = predConcello.getAsJsonArray("listaPredDiaConcello");
            for (JsonElement predDia : listaPredDiaConcello) {
                PrediccionDia dia = gson.fromJson(predDia, PrediccionDia.class);
                System.out.println(dia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
