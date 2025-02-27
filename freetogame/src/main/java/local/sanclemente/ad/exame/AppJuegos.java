package local.sanclemente.ad.exame;

import local.sanclemente.ad.exame.dao.GameConnectionManager;
import local.sanclemente.ad.exame.dao.GeneroDAO;
import local.sanclemente.ad.exame.dao.JuegoDAO;
import local.sanclemente.ad.exame.dao.PlataformaDAO;
import local.sanclemente.ad.exame.model.Genero;
import local.sanclemente.ad.exame.model.Juego;
import local.sanclemente.ad.exame.model.Plataforma;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppJuegos {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try (Connection connection = GameConnectionManager.getInstance().getConnection()){
            GeneroDAO generoDAO= new GeneroDAO(connection);
            PlataformaDAO plataformaDAO= new PlataformaDAO(connection);
            JuegoDAO juegoDAO= new JuegoDAO(connection);

            // Mostrar géneros
            System.out.println("Géneros disponibles");
            List<Genero> generos= generoDAO.getAll();
            for (Genero genero : generos){
                System.out.println(genero.getIdGenero() + ": " + genero.getNombre());
            }

            // Mostrar plataformas
            System.out.println("Plataformas disponibles");
            List<Plataforma> plataformas= plataformaDAO.getAll();
            for (Plataforma plataforma: plataformas){
                System.out.println(plataforma.getIdPlataforma() + ": " + plataforma.getNombre());
            }

            // Pedir id e mostrar xogo
            System.out.println("Indica un ID");
            Scanner scanner= new Scanner(System.in);
            int idXogo= scanner.nextInt();

            System.out.println(juegoDAO.getById(idXogo));

    }
}}
