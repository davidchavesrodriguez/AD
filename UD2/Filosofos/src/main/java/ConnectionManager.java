import java.sql.*;

public class ConnectionManager {
    public static final String URL = "jdbc:h2:/home/sanclemente.local/a22davidcr/filosofosv2.3.mv.db" +
            ";DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";


    public static void main(String[] args) throws ClassNotFoundException {
        // Specify controller
        Class.forName("org.h2.Driver");
        // Check connection
        try (Connection connection = DriverManager.getConnection(URL)) {
            if (connection != null) {
                System.out.println("Connected to database!");

                // Simple statement
                String query = "SELECT * FROM FILOSOFO";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("Hey");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
