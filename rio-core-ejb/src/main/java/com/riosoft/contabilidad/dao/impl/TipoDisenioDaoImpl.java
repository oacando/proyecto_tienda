/**
 * ******************************************************************************
 *  Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.riosoft.contabilidad.TipoDisenioDto;
import com.riosoft.contabilidad.dao.TipoDisenioDao;
import com.riosoft.dao.generic.GenericJpaDaoImpl;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.contabilidad.TipoDisenio;

/**
 * @author Oljer Cando
 *
 */
@Stateless
public class TipoDisenioDaoImpl extends GenericJpaDaoImpl<TipoDisenio, Long> implements TipoDisenioDao{

    public void setEm(EntityManager em) {
        this.em=em;
    }
    
    /* (non-Javadoc)
     * @see com.riosoft.contabilidad.dao.TipoDisenioDao#getDisenioDtos()
     */
    @Override
    public List<TipoDisenioDto> diseniosDtos() throws GenericException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("select distinct new ");
        jpql.append(TipoDisenioDto.class.getCanonicalName());
        jpql.append(" (");
        jpql.append(" td.id,");
        jpql.append(" td.nemonico,");
        jpql.append(" td.nombre");
        jpql.append(" ) ");
        jpql.append("from  TipoDisenio td ");
        jpql.append("where td.estado = : estado ");
        jpql.append("order by td.id ");
        try {
            final TypedQuery<TipoDisenioDto> tQuery = this.em.createQuery(jpql.toString(), TipoDisenioDto.class);
            tQuery.setParameter("estado", EstadoRegistro.ACTIVO.getEstado());
            return tQuery.getResultList();
        } catch (final NoResultException e) {
            throw new GenericException("No existen diseños registrados en la base de datos", e);
        } catch (final Exception e) {
            throw new GenericException("Se produjo un error al obtener el diseño", e);
        }
    }

    /* (non-Javadoc)
     * @see com.riosoft.contabilidad.dao.TipoDisenioDao#getDisenioPorNemonico(java.lang.String)
     */
    @Override
    public TipoDisenio disenioPorNemonico(String nemonico) throws GenericException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("from  TipoDisenio td ");
        jpql.append("where td.estado = : estado ");
        jpql.append("and td.nemonico = : nemonico ");
        jpql.append("order by td.id ");
        try {
            final TypedQuery<TipoDisenio> tQuery = this.em.createQuery(jpql.toString(), TipoDisenio.class);
            tQuery.setParameter("estado", EstadoRegistro.ACTIVO.getEstado());
            tQuery.setParameter("nemonico", nemonico);
            return tQuery.getSingleResult();
        } catch (final NoResultException e) {
            throw new GenericException("No existe diseño con el nemonico registrados en la base de datos", e).addInfo("nemonico", nemonico);
        } catch (final Exception e) {
            throw new GenericException("Se produjo un error al obtener el diseño dado un nemonico", e).addInfo("nemonico", nemonico);
        }
    }

}
