package dao;

import java.util.List;

public interface DAO<T> {
    /**
     * Obtiene un objeto por su identificador.
     *
     * @param id Identificador único del objeto.
     * @return El objeto encontrado o null si no existe.
     */
    T get(long id);

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
    void save(T t);

    /**
     * Actualiza un objeto existente en el almacenamiento.
     *
     * @param t Objeto a actualizar.
     */
    void update(T t);

    /**
     * Elimina un objeto del almacenamiento.
     *
     * @param t Objeto a eliminar.
     */
    void delete(T t);

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
    List<Integer> getAllIds();

    /**
     * Actualiza el contenido LOB (Large Object, como una imagen) de un objeto.
     *
     * @param t Objeto al que se actualizará el LOB.
     * @param f Ruta o contenido del nuevo archivo.
     */
    void updateLOB(T t, String f);

    /**
     * Actualiza el contenido LOB (Large Object) de un objeto por su identificador.
     *
     * @param id Identificador único del objeto.
     * @param f Ruta o contenido del nuevo archivo.
     */
    void updateLOBById(long id, String f);

    /**
     * Elimina todos los objetos del almacenamiento.
     */
    void deleteAll();
}
