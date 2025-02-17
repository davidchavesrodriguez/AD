package local.sanclemente.ad.exame.dao;

import local.sanclemente.ad.exame.model.Plataforma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlataformaDAO implements DAO<Plataforma, Integer> {
    private final Connection connection;

    public PlataformaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Plataforma getById(Integer idPlataforma) throws SQLException {
        Plataforma plataforma = null;
        String sql = "SELECT * FROM Plataforma WHERE idPlataforma = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idPlataforma);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    plataforma = new Plataforma(resultSet.getInt("idPlataforma"), resultSet.getString("nombre"));
                }
            }
        }
        return plataforma;
    }

    @Override
    public List<Plataforma> getAll() throws SQLException {
        List<Plataforma> plataformas = new ArrayList<>();
        String sql = "SELECT * FROM Plataforma";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                plataformas.add(new Plataforma(resultSet.getInt("idPlataforma"), resultSet.getString("nombre")));
            }
        }


        return plataformas;
    }
}
