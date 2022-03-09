/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.facade.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.contabilidad.VentaDto;
import com.riosoft.contabilidad.facade.VentaFacade;
import com.riosoft.contabilidad.servicio.ServicioDetalleVenta;
import com.riosoft.contabilidad.servicio.ServicioInventario;
import com.riosoft.contabilidad.servicio.ServicioVenta;
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Stateless
public class VentaFacadeImpl implements VentaFacade {
    @EJB
    private ServicioVenta servicioVenta;

    @EJB
    private ServicioDetalleVenta ServicioDetalleVenta;

    @EJB
    ServicioInventario servicioInventario;

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.facade.VentaFacade#ingresarVenta(com.riosoft.contabilidad.VentaDto, java.lang.String, java.util.Date)
     */
    @Override
    public void ingresarVenta(VentaDto ventaDto, String usuario, Date fecha) throws GenericException {
        try {
            this.servicioVenta.guardar(ventaDto, usuario, fecha);
            this.ServicioDetalleVenta.guardar(ventaDto, usuario, fecha);
            this.servicioInventario.procesarEgreso(ventaDto, usuario, fecha);
        } catch (final GenericException e) {
            throw new GenericException(e.getMessage(), e);
        }

    }

}
