/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;

import java.util.*;

//import org.apache.pdfbox.pdmodel.PDDocument;

//import java.util.HashSet;
//import java.util.TreeSet;

/**
 * @author pepecalo
 */
public class AppLigaBaloncesto {

    public AppLigaBaloncesto() {
    }

    /**
     * @param args argumentos desde la línea de órdenes
     */
    public static void main(String[] args) {

        Equipo e1 = new Equipo("Real Madrid", 24, 6, 2400, 2100);
        Equipo e2 = new Equipo("FC Barcelona", 22, 8, 2300, 2150);
        Equipo e3 = new Equipo("Manresa", 15, 15, 2050, 2050);
        Equipo e4 = new Equipo("Valencia", 18, 12, 2150, 2100);
        Equipo e5 = new Equipo("Obradoiro", 20, 10, 2250, 2000);
        Equipo e6 = new Equipo("Baskonia", 14, 16, 2000, 2100);
        Equipo e7 = new Equipo("Gran Canaria", 16, 14, 2100, 2050);
        Equipo e8 = new Equipo("Unicaja", 19, 11, 2200, 2000);
        Equipo e9 = new Equipo("Zaragoza", 13, 17, 1950, 2100);
        Equipo e10 = new Equipo("Bilbao Basket", 17, 13, 2150, 2070);
        Equipo e11 = new Equipo("Joventut", 12, 18, 1900, 2000);
        Equipo e12 = new Equipo("Murcia", 21, 9, 2250, 1950);
        Equipo e13 = new Equipo("Andorra", 14, 16, 2005, 2025);
        Equipo e14 = new Equipo("Estudiantes", 10, 20, 1800, 2100);
        Equipo e15 = new Equipo("Tenerife", 22, 8, 2300, 2080);
        Equipo e16 = new Equipo("Boiro", 12, 18, 1950, 2100);
        Equipo e17 = new Equipo("Triñáns", 9, 21, 1800, 2200);

        Equipo f0 = new Equipo("Deportivo da Coruña", 25, 3, 70, 20);
        Equipo f1 = new Equipo("Atlético de Madrid", 20, 8, 45, 30);
        Equipo f2 = new Equipo("Real Madrid", 23, 5, 60, 25);
        Equipo f3 = new Equipo("FC Barcelona", 19, 9, 55, 35);
        Equipo f4 = new Equipo("Sevilla FC", 18, 10, 40, 32);
        Equipo f5 = new Equipo("Real Betis", 15, 13, 38, 36);
        Equipo f6 = new Equipo("Valencia CF", 14, 14, 35, 40);
        Equipo f7 = new Equipo("Athletic Club", 17, 11, 44, 28);
        Equipo f8 = new Equipo("Celta de Vigo", 16, 12, 42, 34);
        Equipo f9 = new Equipo("Getafe CF", 12, 16, 29, 45);
        Equipo f10 = new Equipo("RCD Espanyol", 13, 15, 32, 39);
        Equipo f11 = new Equipo("Real Sociedad", 21, 7, 50, 27);
        Equipo f12 = new Equipo("Girona FC", 10, 18, 30, 50);
        Equipo f13 = new Equipo("UD Las Palmas", 11, 17, 28, 49);
        Equipo f14 = new Equipo("Elche CF", 9, 19, 24, 55);
        Equipo f15 = new Equipo("Granada CF", 12, 16, 36, 44);
        Equipo f16 = new Equipo("Mallorca", 14, 14, 31, 42);


        // Creo clasificación:
        Clasificacion clasificacion = new Clasificacion();
        clasificacion.addEquipos(new TreeSet<>(List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17)));

        Clasificacion clasificacionFutbol = new Clasificacion("Liga futbol");
        clasificacionFutbol.addEquipos(new TreeSet<>(List.of(f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16)));

        // Creo DAO de clasificación:
        Dao<Clasificacion, String> daoClasificacion = ClasificacionDAOFactory.getClasificacionDAO("file");

        daoClasificacion.save(clasificacionFutbol);

        // Guarda la clasificación en un fichero:
        daoClasificacion.save(clasificacion);

        // Leer la clasificación de un fichero:
        Clasificacion clasificacion2 = daoClasificacion.get("Liga ACB");


        System.out.println(clasificacion2);

        Clasificacion clasificacionf = daoClasificacion.get("Liga futbol");
        System.out.println(clasificacionf);


    }


}
