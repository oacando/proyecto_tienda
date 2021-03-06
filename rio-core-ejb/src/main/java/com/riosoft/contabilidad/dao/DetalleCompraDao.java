/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao;

import javax.ejb.Local;

import com.riosoft.dao.generic.GenericJpaDao;
import com.riosoft.modelo.contabilidad.DetalleCompra;

/**
 * @author Oljer Cando
 */
@Local
public interface DetalleCompraDao extends GenericJpaDao<DetalleCompra, Long> {

    
}
