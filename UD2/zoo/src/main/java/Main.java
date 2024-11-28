import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (
                // Establece la conexión con la base de datos
                Connection connection = DriverManager.getConnection("jdbc:h2:/home/sanclemente.local/a22davidcr/Escritorio/zoo;DATABASE_TO_UPPER=FALSE");
                // Prepara la declaración SQL para insertar un registro
                var st = connection.prepareStatement("INSERT INTO Animal (nome, descripcion, foto) VALUES (?, ?, ?)")
        ) {

            // Prepara el FileReader para leer el archivo de texto
            FileReader fileReader = new FileReader("/home/sanclemente.local/a22davidcr/Descargas/EnlaceDrive(1).txt");
            // Prepara el FileInputStream para leer el archivo binario (imagen)
            FileInputStream fileInputStream = new FileInputStream("/home/sanclemente.local/a22davidcr/Descargas/images.png");

            // Desactiva el autocommit para manejar las transacciones
            connection.setAutoCommit(false);

            // Establece los parámetros en la declaración SQL
            st.setString(1, "Turonia");  // Nombre del animal
            st.setClob(2, fileReader); // Descripción (archivo de texto)
            st.setBlob(3, fileInputStream); // Imagen (archivo binario)

            // Ejecuta la actualización y verifica si se insertó correctamente
            if (st.executeUpdate() > 0) {
                System.out.println("Insertado");
            } else {
                System.out.println("Ha habido un error");
            }

            // Confirma la transacción
            connection.commit();
            connection.setAutoCommit(true);

            // Cierra los recursos
            fileReader.close();
            fileInputStream.close();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
