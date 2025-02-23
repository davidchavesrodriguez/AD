package local.sanclemente.ad.exame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GameConnectionManager {
    private static final String URL= "src/main/resources/FreeToGame;" +
            "DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE;FILE_LOCK=NO";
    private static final String DRIVERS= "org.h2.Driver";

    private static volatile GameConnectionManager instance;
    private Connection connection;

    private GameConnectionManager() throws ClassNotFoundException {
        Class.forName(DRIVERS);
    }

    public static GameConnectionManager getInstance() throws ClassNotFoundException {
        if (instance == null){
            synchronized (GameConnectionManager.class) {
                if (instance == null) {
                    instance= new GameConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            connection= DriverManager.getConnection(URL);
        }
        return connection;
    }
}
