/**
 * Prueba Todo uno
 */
package com.riosoft.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import com.riosoft.excepciones.DeleteException;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.excepciones.UpdateException;

/**
 * Implementación de generic DAO para el manejo de las entidades de seguridad
 *
 * @author Oljer Cando
 */
public class GenericJpaDaoImpl<T, K extends Serializable> implements GenericJpaDao<T, K> {

    @PersistenceContext(unitName = "rio-core-ejb")
    protected EntityManager em;

    private final Class<T> GenericClass;

    @SuppressWarnings("unchecked")
    public GenericJpaDaoImpl() {
        this.GenericClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void delete(K id) throws DeleteException {
        final T obj = this.findById(id);
        this.delete(obj);

    }

    @Override
    public void delete(T entity) throws DeleteException {
        try {
            entity = this.em.merge(entity);
            this.em.remove(entity);
        } catch (final IllegalArgumentException | TransactionRequiredException ex) {
            throw new DeleteException(entity, ex);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() throws GenericException {
        return this.em.createQuery("select o from " + this.GenericClass.getCanonicalName() + " o").getResultList();
    }

    @Override
    public T findById(K id) {
        return this.em.find(this.GenericClass, id);
    }

    @Override
    public List<T> persist(List<T> entityList) throws PersistException {
        final List<T> r = new ArrayList<>();
        try {
            for (final T t : entityList) {
                this.em.persist(t);
                r.add(t);
            }
            return r;
        } catch (final EntityExistsException | IllegalArgumentException | TransactionRequiredException ex) {
            throw new PersistException(entityList, ex);
        }
    }

    @Override
    public T persist(T entity) throws PersistException {
        try {
            this.em.persist(entity);
            return entity;
        } catch (final EntityExistsException | IllegalArgumentException | TransactionRequiredException ex) {
            throw new PersistException(entity, ex);
        }
    }

    @Override
    public List<T> update(List<T> entityList) throws UpdateException {
        final List<T> r = new ArrayList<>();
        try {
            for (final T t : entityList) {
                this.em.merge(t);
                r.add(t);
            }
            return r;
        } catch (final IllegalArgumentException | TransactionRequiredException ex) {
            throw new UpdateException(entityList, ex);
        }
    }

    @Override
    public T update(T entity) throws UpdateException {
        try {
            return this.em.merge(entity);
        } catch (final IllegalArgumentException | TransactionRequiredException ex) {
            throw new UpdateException(entity, ex);
        }
    }

}
