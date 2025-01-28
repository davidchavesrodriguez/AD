import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class GSONLoader {

    public static void main(String[] args) {
        try {
            // Cargar el archivo JSON
            FileReader reader = new FileReader("src/main/resources/equipos.json");

            // Crear un objeto Gson
            Gson gson = new Gson();

            // Especificar el tipo de la respuesta (EquiposResponse)
            Type responseType = new TypeToken<EquipoResponse>(){}.getType();

            // Deserializar el JSON
            EquipoResponse response = gson.fromJson(reader, responseType);

            // Imprimir los equipos
            for (Equipo equipo : response.getEquipos()) {
                System.out.println(equipo.getNombreCompleto());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
