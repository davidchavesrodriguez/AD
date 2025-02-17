package local.sanclemente.ad.exame;

import local.sanclemente.ad.exame.dao.GeneroDAO;
import local.sanclemente.ad.exame.model.Genero;
import local.sanclemente.ad.exame.dao.GameConnectionManager;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AppExame {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = GameConnectionManager.getInstance().getConnection();

        GeneroDAO generoDAO = new GeneroDAO(connection);
        List<Genero> generos = generoDAO.getAll();

        for (Genero g : generos) {
            System.out.println(g.getNombre());
        }

    }
}
