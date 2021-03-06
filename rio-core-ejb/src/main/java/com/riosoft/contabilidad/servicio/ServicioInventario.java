/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.contabilidad.servicio;

import java.util.Date;

import javax.ejb.Local;

import com.riosoft.contabilidad.CompraDto;
import com.riosoft.contabilidad.VentaDto;
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Local
public interface ServicioInventario {
    /**
     * proceso los datos del inventario cuando se realiza una venta
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 09:59:29 Oljer Cando
     *          Versión inicial.
     * @param compraDto
     * @param usuario
     * @param fecha
     * @throws GenericException
     */
    public void procesarEgreso(VentaDto ventaDto, String usuario, Date fecha) throws GenericException;

    /**
     * procesa los datos del inventario cuando se realiza una compra
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 20:16:28 Oljer Cando
     *          Versión inicial.
     * @param compraDto
     * @param usuario
     * @param fecha
     * @throws GenericException
     */
    public void procesarIngreso(CompraDto compraDto, String usuario, Date fecha) throws GenericException;

}
