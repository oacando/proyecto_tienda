/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.riosoft.contabilidad.dao.InventarioDao;
import com.riosoft.dao.generic.GenericJpaDaoImpl;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.enumerados.Stock;
import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.contabilidad.Inventario;

/**
 * @author Oljer Cando
 */
@Stateless
public class InventarioDaoImpl extends GenericJpaDaoImpl<Inventario, Long> implements InventarioDao {
    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.dao.InventarioDao#buscarPoridProducto(java.lang.Long)
     */
    @Override
    public Inventario buscarPorIdProducto(Long idProducto) throws GenericException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("from  Inventario i ");
        jpql.append("where i.producto.id = : idProducto ");
        jpql.append("and i.estado = : estado ");
        try {
            final TypedQuery<Inventario> tQuery = this.em.createQuery(jpql.toString(), Inventario.class);
            tQuery.setParameter("estado", EstadoRegistro.ACTIVO.getEstado());
            tQuery.setParameter("idProducto", idProducto);
            return tQuery.getSingleResult();
        } catch (final NoResultException e) {
            throw new GenericException("No existe el producto en el invetario", e).addInfo("idProducto", idProducto);
        } catch (final Exception e) {
            throw new GenericException("Se produjo un error al intentar obtener el inventario ", e).addInfo("idProducto", idProducto);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.dao.InventarioDao#validarExistencia(java.lang.Long)
     */
    @Override
    public Boolean obtenerStock(Long idProducto) throws GenericException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("select count (i.stock) ");
        jpql.append("from  Inventario i ");
        jpql.append("where i.producto.id = : idProducto ");
        jpql.append("and i.stock > : stock ");
        jpql.append("and i.estado = : estado ");
        try {
            final TypedQuery<Long> tQuery = this.em.createQuery(jpql.toString(), Long.class);
            tQuery.setParameter("estado", EstadoRegistro.ACTIVO.getEstado());
            tQuery.setParameter("stock", Stock.MINIMO.getStock());
            tQuery.setParameter("idProducto", idProducto);
            if (tQuery.getSingleResult().intValue() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (final Exception e) {
            throw new GenericException("Se produjo un error al verificar la existencia", e).addInfo("idProducto", idProducto);
        }
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /* (non-Javadoc)
     * @see com.riosoft.contabilidad.dao.InventarioDao#existeProducto(java.lang.Long)
     */
    @Override
    public Boolean existeProducto(Long idProducto) throws GenericException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("select count (i.producto.id) ");
        jpql.append("from  Inventario i ");
        jpql.append("where i.producto.id = : idProducto ");
        jpql.append("and i.estado = : estado ");
        try {
            final TypedQuery<Long> tQuery = this.em.createQuery(jpql.toString(), Long.class);
            tQuery.setParameter("estado", EstadoRegistro.ACTIVO.getEstado());
            tQuery.setParameter("idProducto", idProducto);
            if (tQuery.getSingleResult().intValue() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (final Exception e) {
            throw new GenericException("Se produjo un error al verificar la existencia", e).addInfo("idProducto", idProducto);
        }
    }

}
