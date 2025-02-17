package local.sanclemente.ad.exame.dao;

import local.sanclemente.ad.exame.model.Genero;
import local.sanclemente.ad.exame.model.Imagen;
import local.sanclemente.ad.exame.model.Juego;
import local.sanclemente.ad.exame.model.Plataforma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JuegoDAO implements DAO<Juego, Integer> {
    private final Connection connection;


    public JuegoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Juego getById(Integer idJuego) throws SQLException {
        Juego juego = null;
        String sql = "SELECT * FROM Juego WHERE idJuego = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idJuego);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Recollemos datos do xogo
                    GeneroDAO generoDAO = new GeneroDAO(connection);
                    PlataformaDAO plataformaDAO = new PlataformaDAO(connection);
                    Genero genero = generoDAO.getById(resultSet.getInt("idGenero"));
                    Plataforma plataforma = plataformaDAO.getById(resultSet.getInt("idPlataforma"));

                    // Imaxes asociadas ao xogo
                    List<Imagen> imagenes = getImagenes(idJuego);

                    // Creamos el objeto Juego con los datos recuperados
                    juego = new Juego(
                            genero,
                            plataforma,
                            resultSet.getString("titulo"),
                            resultSet.getString("miniatura"),
                            resultSet.getString("estado"),
                            resultSet.getString("descripcionCorta"),
                            resultSet.getString("descripcion"),
                            resultSet.getString("url"),
                            resultSet.getString("editor"),
                            resultSet.getString("desarrollador"),
                            resultSet.getDate("fecha").toLocalDate(),
                            imagenes
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Deberías capturar adecuadamente los errores.
        }
        return juego;
    }

    public List<Imagen> getImagenes(Integer idJuego) {
        List<Imagen> imagenes = new ArrayList<>();
        String sql = "SELECT * FROM Imagen WHERE idJuego= ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idJuego);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    imagenes.add(new Imagen(resultSet.getLong("idImagen"), new Juego(), resultSet.getString("url"), resultSet.getBytes("imagen")));
                }
                return imagenes;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Juego> getAll() throws SQLException {
        List<Juego> juegos = new ArrayList<>();
        return juegos;
    }
}
