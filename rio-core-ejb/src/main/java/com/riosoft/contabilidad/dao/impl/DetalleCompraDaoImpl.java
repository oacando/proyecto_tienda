/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao.impl;

import javax.ejb.Stateless;

import com.riosoft.contabilidad.dao.DetalleCompraDao;
import com.riosoft.dao.generic.GenericJpaDaoImpl;
import com.riosoft.modelo.contabilidad.DetalleCompra;

/**
 * @author Oljer Cando
 */
@Stateless
public class DetalleCompraDaoImpl extends GenericJpaDaoImpl<DetalleCompra, Long> implements DetalleCompraDao {

}
