package local.sanclemente.ad.exame.dao;

import local.sanclemente.ad.exame.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO implements DAO<Genero, Integer> {
    private final Connection connection;

    public GeneroDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Genero getById(Integer idGenero) throws SQLException {
        Genero genero=null;
        String sql= "SELECT * FROM Genero WHERE idGenero=?";

        try(PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery()) {
            preparedStatement.setInt(1, idGenero);
            while (resultSet.next()){
                genero=new Genero(resultSet.getInt("idGenero"), resultSet.getString("nombre"));
            }
        }
        return genero;
    }

    @Override
    public List<Genero> getAll() throws SQLException {
        List<Genero> generos= new ArrayList<>();
        String sql= "SELECT * FROM Genero";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()){
                Genero genero= new Genero(resultSet.getInt("idGenero"), resultSet.getString("nombre"));
                generos.add(genero);
            }
        }

        return List.of();
    }
}
