/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package local.sanclemente.ad.exame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author pepecalo
 */
public class GameConnectionManager {

    private static final String URL = "jdbc:h2:file:./src/main/resources/FreeToGameExame;" +
            "DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE;FILE_LOCK=NO";
    public static final String DRIVER = "org.h2.Driver";

    private static volatile GameConnectionManager instance;
    private Connection connection;

    private GameConnectionManager() throws ClassNotFoundException {
        Class.forName(DRIVER);
    }

    // SINGLETON
    public static GameConnectionManager getInstance() throws ClassNotFoundException {
        if (instance == null) {
            synchronized (GameConnectionManager.class){
                if (instance == null){
                    instance = new GameConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        try {
            if (connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
