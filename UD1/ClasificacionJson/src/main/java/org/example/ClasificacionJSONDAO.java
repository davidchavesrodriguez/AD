package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClasificacionJSONDAO implements Dao<Clasificacion, String> {

    public static final Path DEFAULT_PATH = Paths.get("e:\\data\\");
    public static final Gson gson = new Gson();


    private Path ruta;

    public ClasificacionJSONDAO() {
        ruta = DEFAULT_PATH;
    }

    public ClasificacionJSONDAO(Path ruta) {
        this.ruta = ruta;
    }

    @Override
    public Clasificacion get(String competicion) {
        try {
            // Define la ruta completa del archivo JSON
            Path filePath = ruta.resolve(competicion + ".json");

            // Leer el contenido del archivo JSON
            String json = Files.readString(filePath);

            // Convertir el JSON a un objeto Clasificacion
            return gson.fromJson(json, Clasificacion.class);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Clasificacion> getAll() {
        try {
            // Listar todos los archivos JSON en la ruta
            return Files.list(ruta)
                    .filter(path -> path.toString().endsWith(".json")) // Filtrar solo archivos JSON
                    .map(path -> {
                        try {
                            String json = Files.readString(path);
                            return gson.fromJson(json, Clasificacion.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(obj -> obj != null) // Eliminar los nulos (en caso de error de lectura)
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Devuelve una lista vacía si hay algún error
        }
    }


    @Override
    public boolean save(Clasificacion clasificacion) {
        try {
            // Define la ruta completa, con el nombre del archivo basado en la competición
            Path filePath = ruta.resolve(clasificacion.getCompeticion() + ".json");

            // Escribir el objeto clasificacion en formato JSON
            String json = gson.toJson(clasificacion);
            Files.writeString(filePath, json);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(Clasificacion clasificacion) {
        try {
            // Define la ruta completa del archivo JSON a eliminar
            Path filePath = ruta.resolve(clasificacion.getCompeticion() + ".json");

            // Eliminar el archivo
            return Files.deleteIfExists(filePath);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    @Override
    public boolean deleteAll() {
        try {
            List<Path> archivos = Files.list(ruta)
                    .filter(path -> path.toString().endsWith(".json"))
                    .toList();
            for (Path path : archivos) {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException e) {
                    System.err.println("No se pudo eliminar el archivo: " + path);
                    e.printStackTrace();
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteById(String competicion) {
        try {
            // Define la ruta completa del archivo JSON basado en el nombre de la competición
            Path filePath = ruta.resolve(competicion + ".json");

            // Eliminar el archivo si existe
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void update(Clasificacion clasificacion) {
        // Simplemente reutiliza el método save() para sobrescribir el archivo existente
        save(clasificacion);
    }

}