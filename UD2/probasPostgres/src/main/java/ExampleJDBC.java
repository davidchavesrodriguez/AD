import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleJDBC {
    public static void main(String[] args) {
        // Configuración de la conexión
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "abc123.";

        // Establecer la conexión y consultar los datos
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            showPokemonTable(con);  // Llamamos a la función para mostrar los Pokémon
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
    }

    public static void showPokemonTable(Connection con) throws SQLException {
        String query = "SELECT \"pokedexNumber\", name, type, generation, description FROM public.\"Pokemon\"";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int pokedexNumber = rs.getInt("pokedexNumber");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int generation = rs.getInt("generation");
                String description = rs.getString("description");

                // Mostrar los datos en la consola
                System.out.println("Pokedex Number: " + pokedexNumber +
                        ", Name: " + name +
                        ", Type: " + type +
                        ", Generation: " + generation +
                        ", Description: " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
