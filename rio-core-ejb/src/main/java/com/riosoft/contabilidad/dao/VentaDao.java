/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao;

import javax.ejb.Local;

import com.riosoft.dao.generic.GenericJpaDao;
import com.riosoft.modelo.contabilidad.Venta;

/**
 * @author Oljer Cando
 *
 */
@Local
public interface VentaDao extends GenericJpaDao<Venta, Long> {

}
