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
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Local
public interface ServicioDetalleCompra {

    /**
     * Procesa los items correspondientes a la compra
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 19:51:16 Oljer Cando
     *          Versión inicial.
     * @param compraDto
     * @param usuario
     * @param fecha
     * @throws GenericException
     */
    public void guardar(CompraDto compraDto, String usuario, Date fecha) throws GenericException;

}
