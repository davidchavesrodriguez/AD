package solution;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.time.LocalDate;

public class AppPrediccion {
    public static final String URL = "https://servizos.meteogalicia.gal/mgrss/predicion/" +
            "jsonPredConcellos.action?idConc=15078&request_locale=gl";

    HttpURLConnection connection;


    public AppPrediccion() throws IOException, URISyntaxException {
        // Crear url a partir de String
        URL url = new URI(URL).toURL();

        // Abrir conexión
        connection = (HttpURLConnection) url.openConnection();

        // Registrar deserializador
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Prediccion.class, new PrediccionDeserializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString();

            // Deserializar Json a obxecto Prediccion
            Prediccion prediccion = gson.fromJson(json, Prediccion.class);
            System.out.println(prediccion);
        } finally {
            connection.disconnect();
        }
    }

    public static void main(String[] args) {
        try {
            new AppPrediccion();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
