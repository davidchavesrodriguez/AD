/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package local.sanclemente.ad.exame.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pepecalo
 * @param <T> Tipo de dato del objeto
 */
public interface DAO<T, K> {

    // SELECT * BY ID
    T getById(K id) throws SQLException;

    // SELECT *
    List<T> getAll() throws SQLException;

}