/**
 * Prueba Todo uno
 */
package com.riosoft.dao.generic;

import java.io.Serializable;
import java.util.List;

import com.riosoft.excepciones.DeleteException;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.excepciones.UpdateException;

/**
 * Interface genérica para el acceso a datos
 *
 * @author Oljer Cando
 * @param <T>
 *            Entidad
 * @param <K>
 *            Identificador único de la entidad (PK)
 */
public interface GenericJpaDao<T, K extends Serializable> {

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:12:36 Oljer Cando
     *          Versión inicial.
     * @param id
     * @throws DeleteException
     */
    public void delete(K id) throws DeleteException;

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:12:41 Oljer Cando
     *          Versión inicial.
     * @param entity
     * @throws DeleteException
     */
    public void delete(T entity) throws DeleteException;

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:12:47 Oljer Cando
     *          Versión inicial.
     * @return {@code List<T>}
     * @throws GenericException
     */

    public List<T> findAll() throws GenericException;

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:12:51 Oljer Cando
     *          Versión inicial.
     * @param id
     * @return
     */
    public T findById(K id);

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:13:01 Oljer Cando
     *          Versión inicial.
     * @param entityList
     * @return {@code List<T>}
     * @throws PersistException
     */
    public List<T> persist(List<T> entityList) throws PersistException;

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:12:57 Oljer Cando
     *          Versión inicial.
     * @param entity
     * @return Entidad persistida {@code T}
     * @throws PersistException
     */
    public T persist(T entity) throws PersistException;

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:13:12 Oljer Cando
     *          Versión inicial.
     * @param entityList
     * @return Listado de entidades {@code List<T>}
     * @throws UpdateException
     */
    public List<T> update(List<T> entityList) throws UpdateException;

    /**
     * @author Oljer Cando
     * @history 7 mar. 2022 - 18:13:08 Oljer Cando
     *          Versión inicial.
     * @param entity
     * @return Entidad actualizada {@code T}
     * @throws UpdateException
     */
    public T update(T entity) throws UpdateException;

}
