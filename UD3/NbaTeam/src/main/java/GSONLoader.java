import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class GSONLoader {

    public static void main(String[] args) {
        // Use try-with-resources to ensure the FileReader is closed
        try (FileReader reader = new FileReader("src/main/resources/equipos.json")) {
            // Create a Gson object
            Gson gson = new GsonBuilder().create();

            // Specify the type of the response (EquiposResponse)
            Type responseType = new TypeToken<EquipoResponse>(){}.getType();

            // Deserialize the JSON
            EquipoResponse response = gson.fromJson(reader, responseType);

            // Print the teams
            if (response != null && response.getEquipos() != null) {
                for (Equipo equipo : response.getEquipos()) {
                    System.out.println(equipo.getNombreCompleto());
                }
            } else {
                System.out.println("No teams found or JSON is invalid.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}