/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.facade.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.contabilidad.CompraDto;
import com.riosoft.contabilidad.facade.CompraFacade;
import com.riosoft.contabilidad.servicio.ServicioCompra;
import com.riosoft.contabilidad.servicio.ServicioDetalleCompra;
import com.riosoft.contabilidad.servicio.ServicioInventario;
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Stateless
public class CompraFacadeImpl implements CompraFacade {

    @EJB
    private ServicioCompra servicioCompra;

    @EJB
    private ServicioDetalleCompra servicioDetalleCompra;

    @EJB
    private ServicioInventario servicioInventario;

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.facade.CompraFacade#ingresarCompra(com.riosoft.contabilidad.CompraDto)
     */
    @Override
    public void ingresarCompra(CompraDto compraDto, String usuario, Date fecha) throws GenericException {
        try {
            this.servicioCompra.guardar(compraDto, usuario, fecha);
            this.servicioDetalleCompra.guardar(compraDto, usuario, fecha);
            this.servicioInventario.procesarIngreso(compraDto, usuario, fecha);
        } catch (final GenericException e) {
            throw new GenericException(e.getMessage(), e);
        }
    }

}
