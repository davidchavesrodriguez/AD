package local.sanclemente.ad.exame;

import local.sanclemente.ad.exame.dao.GameConnectionManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class GameDownloader {
    private static final String IMAGE_DIRECTORY= "src/main/resources/images";
    private static final String DESCRIPTION_DIRECTORY= "src/main/resources/descriptions";

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        GameDownloader gameDownloader= new GameDownloader();
        gameDownloader.prepareDirectory();
        // gameDownloader.downloadImages();
        gameDownloader.downloadDescription();
    }
    public void prepareDirectory() throws IOException {
        Path imageDir= Paths.get(IMAGE_DIRECTORY);
        Path descriptionDir= Paths.get(DESCRIPTION_DIRECTORY);

        Files.createDirectories(imageDir);
        Files.createDirectories(descriptionDir);
    }
    public void downloadImages() throws ClassNotFoundException {
        String sql= "SELECT idImagen, idJuego, url, imagen FROM Imagen";

        try (Connection connection= GameConnectionManager.getInstance().getConnection()){
            System.out.println("Conectado a la base de datos");
            var statement= connection.createStatement();
            var resultSet= statement.executeQuery(sql);

            while (resultSet.next()){
                int idImagen= resultSet.getInt("idImagen");
                int idJuego= resultSet.getInt("idJuego");
                String url= resultSet.getString("url");

                try(var inputStream = resultSet.getBinaryStream("imagen")){
                    String fileName= idJuego + "-" + idImagen + ".png";
                    Path imagePath= Paths.get(IMAGE_DIRECTORY, fileName);

                    try(var outputStream = Files.newOutputStream(imagePath);
                    var bufferedInputStream = new BufferedInputStream(inputStream);
                    var bufferedOutputStream= new BufferedOutputStream(outputStream)){
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = bufferedInputStream.read(buffer)) != -1){
                            bufferedOutputStream.write(buffer, 0, bytesRead);
                        }
                        System.out.println("Imagen Descargada: " + fileName);
                    }
                }
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void downloadDescription() throws ClassNotFoundException {
        String sql= "SELECT idJuego, descripcion FROM Juego";

        try(Connection connection= GameConnectionManager.getInstance().getConnection()){
            System.out.println("Conectado a la base de datos");

            var statement= connection.createStatement();
            var resulset= statement.executeQuery(sql);

            while (resulset.next()){
                int idJuego= resulset.getInt("idJuego");
                String description= resulset.getString("descripcion");

                Path descriptionFile= Paths.get(DESCRIPTION_DIRECTORY, String.valueOf(idJuego) + ".txt");

                try (var writer = Files.newBufferedWriter(descriptionFile)){
                    writer.write(description);
                    System.out.println("Descripción guardada en " + descriptionFile);
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
