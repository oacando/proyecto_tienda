/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.servicio;

import java.util.Date;

import javax.ejb.Local;

import com.riosoft.contabilidad.VentaDto;
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Local
public interface ServicioDetalleVenta {

    /**
     * Proceso de registro de los detalles de la compra
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 09:48:14 Oljer Cando
     *          Versión inicial.
     * @param ventaDto
     * @param usuario
     * @param fecha
     * @throws GenericException
     */
    public void guardar(VentaDto ventaDto, String usuario, Date fecha) throws GenericException;
}
