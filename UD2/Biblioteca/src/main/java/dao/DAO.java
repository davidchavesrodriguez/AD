package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    /**
     * Obtiene un objeto por su identificador.
     *
     * @param id Identificador único del objeto.
     * @return El objeto encontrado o null si no existe.
     */
    T get(long id) throws SQLException;

    /**
     * Obtiene una lista de todos los objetos almacenados.
     *
     * @return Lista de todos los objetos.
     */
    List<T> getAll();

    /**
     * Guarda un nuevo objeto en el almacenamiento.
     *
     * @param t Objeto a guardar.
     */
    void save(T t) throws SQLException;

    /**
     * Actualiza un objeto existente en el almacenamiento.
     *
     * @param t Objeto a actualizar.
     */
    void update(T t) throws SQLException;

    /**
     * Elimina un objeto del almacenamiento.
     *
     * @param t Objeto a eliminar.
     */
    void delete(T t) throws SQLException;

    /**
     * Elimina un objeto por su identificador.
     *
     * @param id Identificador único del objeto a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró.
     */
    boolean deleteById(long id);

    /**
     * Obtiene una lista de todos los identificadores.
     *
     * @return Lista de identificadores únicos.
     */
    List<Integer> getAllIds() throws SQLException;

    /**
     * Actualiza el contenido LOB (Large Object, como una imagen) de un objeto.
     *
     * @param t Objeto al que se actualizará el LOB.
     * @param f Ruta o contenido del nuevo archivo.
     */
    void updateLOB(T t, String f) throws SQLException;

    /**
     * Actualiza el contenido LOB (Large Object) de un objeto por su identificador.
     *
     * @param id Identificador único del objeto.
     * @param f Ruta o contenido del nuevo archivo.
     */
    void updateLOBById(long id, String f) throws SQLException;

    /**
     * Elimina todos los objetos del almacenamiento.
     */
    void deleteAll() throws SQLException;
}
