package peliculas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class JPQLExample {
    private EntityManager entityManager;

    public void showTables() {
        Query query = entityManager.createNativeQuery("SHOW TABLES");
        List<Object> result = query.getResultList();

        for (Object table : result) {
            System.out.println(table);
        }
    }
}
