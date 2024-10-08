package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ex3 {
    public static void main(String[] args) throws IOException {
//            Escribid un programa en Java que, empleando las clases de Java NIO 2, liste los
//        archivos de un directorio por medio del método list(). Debe mostrar sólo los
//        archivos fuente Java, no los directorios que contiene. Recuerda el uso de filtros en
//        Stream y de forEach.
        Path filePath = Paths.get("/home/sanclemente.local/a22davidcr/Escritorio/AD/UD1/BoletinUD1_02");
        try (Stream<Path> stream = Files.list(filePath)) {
            stream
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);


//            Haz el mismo ejercicio con el método list() de File y compara el tiempo de
//        ejecución en cada caso.
            File[] files = filePath.toFile().listFiles(
                    file -> file.isFile() &&
                            file.getName().endsWith(".java"));

            if (files != null) {
                for (File file : files) {
                    System.out.println(file);
                }
            }

        }
    }
}
