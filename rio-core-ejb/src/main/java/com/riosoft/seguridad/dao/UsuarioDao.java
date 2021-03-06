/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.seguridad.dao;

import javax.ejb.Local;

import com.riosoft.dao.generic.GenericJpaDao;
import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.seguridad.Usuario;

/**
 * @author Oljer Cando
 */
@Local
public interface UsuarioDao extends GenericJpaDao<Usuario, Long> {

    /**
     * Previo al registro de un usuario se valida la existencia por medio del correo
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 07:46:31 Oljer Cando
     *          Versión inicial.
     * @param correo
     * @return
     * @throws GenericException
     */
    public Boolean veficarExistenciaPorCorreo(String correo) throws GenericException;
}
