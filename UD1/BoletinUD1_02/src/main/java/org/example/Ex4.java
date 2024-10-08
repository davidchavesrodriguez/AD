package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ex4 {
    public static void main(String[] args) throws IOException {
        Path sourceDir = Paths.get("/home/sanclemente.local/a22davidcr/Escritorio/AD/UD1/BoletinUD1_02/src/main/java/org/example");
        Path destDir = Paths.get("/home/sanclemente.local/a22davidcr/Escritorio/AD/UD1/BoletinUD1_02/resources"); // Cambia a la ruta de destino que quieras

        // Verificar que la carpeta de destino existe, sino crearla
        if (!Files.exists(destDir)) {
            Files.createDirectories(destDir);
        }

        File[] files = sourceDir.toFile().listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    Path destFile = Path.of("src/main/resources/" + file.getName());
                    System.out.println("Copying file: " + file.getName() + " to " + destFile);
                    Files.copy(file.toPath(), destFile, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
}
