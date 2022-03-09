/**
 * ******************************************************************************
 * * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */

package com.riosoft.contabilidad.dao;

import java.util.List;

import javax.ejb.Local;

import com.riosoft.dao.generic.GenericJpaDao;
import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.contabilidad.Producto;

/**
 * @author Oljer Cando
 */
@Local
public interface ProductoDao extends GenericJpaDao<Producto, Long> {

    /**
     * 
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 16:52:16 Oljer Cando
     * Versión inicial.
     * @return
     * @throws GenericException
     */
    public List<Producto> getProductos() throws GenericException;
}
