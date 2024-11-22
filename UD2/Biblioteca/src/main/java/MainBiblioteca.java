import java.sql.Connection;

public class MainBiblioteca {
    public static void main(String[] args) {
        // Obtener la instancia Singleton
        BibliotecaConnectionManager connectionManager = BibliotecaConnectionManager.getInstance();

        // Obtener la conexión desde el Singleton
        Connection connection = connectionManager.getConnection();

        // Mostrar información de la conexión
        System.out.println("Conexión establecida: " + connection);

        // Cerrar la conexión al finalizar
        connectionManager.closeConnection();
    }
}
