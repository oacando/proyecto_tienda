/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao.impl;

import javax.ejb.Stateless;

import com.riosoft.contabilidad.dao.DetalleVentaDao;
import com.riosoft.dao.generic.GenericJpaDaoImpl;
import com.riosoft.modelo.contabilidad.DetalleVenta;

/**
 * @author Oljer Cando
 */
@Stateless
public class DetalleVentaDaoImpl extends GenericJpaDaoImpl<DetalleVenta, Long> implements DetalleVentaDao {

}
