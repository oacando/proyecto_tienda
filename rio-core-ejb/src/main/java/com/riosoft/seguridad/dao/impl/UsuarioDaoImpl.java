/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.seguridad.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.riosoft.dao.generic.GenericJpaDaoImpl;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.seguridad.Usuario;
import com.riosoft.seguridad.dao.UsuarioDao;

/**
 * @author Oljer Cando
 */
@Stateless
public class UsuarioDaoImpl extends GenericJpaDaoImpl<Usuario, Long> implements UsuarioDao {
    
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /*
     * (non-Javadoc)
     * @see com.riosoft.seguridad.dao.UsuarioDao#validarExistenciaPorCorreo(java.lang.String)
     */
    @Override
    public Boolean veficarExistenciaPorCorreo(String correo) throws GenericException {
        final StringBuilder jpql = new StringBuilder();
        jpql.append("select count (u.correo) ");
        jpql.append("from  Usuario u ");
        jpql.append("where u.correo = : correo ");
        jpql.append("and u.estado = : estado ");
        try {
            final TypedQuery<Long> tQuery = this.em.createQuery(jpql.toString(), Long.class);
            tQuery.setParameter("estado", EstadoRegistro.ACTIVO.getEstado());
            tQuery.setParameter("correo", correo);
            if (tQuery.getSingleResult().intValue() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (final Exception e) {
            throw new GenericException("Se produjo un error al verificar la existencia de", e).addInfo("correo", correo);
        }
    }

}
