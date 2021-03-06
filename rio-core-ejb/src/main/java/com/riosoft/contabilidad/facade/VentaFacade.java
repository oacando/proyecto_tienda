/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.facade;

import java.util.Date;

import javax.ejb.Local;

import com.riosoft.contabilidad.VentaDto;
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Local
public interface VentaFacade {

    /**
     * Procesa una venta, registra la venta el detalle y actualiza el inventario
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 10:30:03 Oljer Cando
     *          Versión inicial.
     * @param ventaDto
     * @param usuario
     * @param fecha
     * @throws GenericException
     */
    public void ingresarVenta(VentaDto ventaDto, String usuario, Date fecha) throws GenericException;
}
