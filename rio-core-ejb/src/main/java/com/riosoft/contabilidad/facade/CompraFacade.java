/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.facade;

import java.util.Date;

import javax.ejb.Local;

import com.riosoft.contabilidad.CompraDto;
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Local
public interface CompraFacade {

    /**
     * proceso para registrar una compra y actualizar el inventario
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 18:07:13 Oljer Cando
     *          Versión inicial.
     * @return
     * @throws GenericException
     */
    public void ingresarCompra(CompraDto compraDto, String usuario, Date fecha) throws GenericException;

}
