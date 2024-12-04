import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BibliotecaConnectionManager {
    // Instancia única para el patrón Singleton
    private static volatile BibliotecaConnectionManager instance;
    private Connection connection;
    public static final String DRIVER = "org.h2.Driver";
    public static final String URL = "jdbc:h2:C:\\Users\\19dch\\OneDrive\\Escritorio\\Clase\\DAM2\\Biblioteca" +
            ";DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE";

    // Constructor privado
    private BibliotecaConnectionManager() {
        try {
            Class.forName(DRIVER); // Carga del controlador H2
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el controlador JDBC", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    // Método para obtener la instancia única
    public static BibliotecaConnectionManager getInstance() {
        if (instance == null) {
            synchronized (BibliotecaConnectionManager.class) {
                if (instance == null) {
                    instance = new BibliotecaConnectionManager();
                }
            }
        }
        return instance;
    }

    // Devuelve la conexión actual
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión de base de datos", e);
        }
        return connection;
    }

    // Método para cerrar la conexión
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error al cerrar la conexión de base de datos", e);
            }
        }
    }
}
