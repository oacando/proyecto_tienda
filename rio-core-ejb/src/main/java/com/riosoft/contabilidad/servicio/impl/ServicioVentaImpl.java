/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.servicio.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.contabilidad.VentaDto;
import com.riosoft.contabilidad.dao.VentaDao;
import com.riosoft.contabilidad.servicio.ServicioVenta;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.modelo.contabilidad.Venta;
import com.riosoft.modelo.seguridad.Usuario;

/**
 * @author Oljer Cando
 */
@Stateless
public class ServicioVentaImpl implements ServicioVenta {

    @EJB
    private VentaDao ventaDao;

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.servicio.ServicioVenta#guardar(com.riosoft.contabilidad.VentaDto, java.lang.String, java.util.Date)
     */
    @Override
    public void guardar(VentaDto ventaDto, String usuario, Date fecha) throws GenericException {
        final Venta venta = this.toVenta(ventaDto, usuario, fecha);
        try {
            this.ventaDao.persist(venta);
            ventaDto.setId(venta.getId());
        } catch (final PersistException e) {
            throw new GenericException(e.getMessage(), e);
        }
    }

    /**
     * mapping dto to entity
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 09:44:55 Oljer Cando
     *          Versión inicial.
     * @param ventaDto
     * @param usuario
     * @param fecha
     * @return
     */
    private Venta toVenta(VentaDto ventaDto, String usuario, Date fecha) {
        final Venta venta = new Venta();
        venta.setNumeroFactura(ventaDto.getNumeroFactura());
        venta.setFechaVenta(ventaDto.getFechaVenta());
        final Usuario cliente = new Usuario();
        cliente.setId(ventaDto.getIdCliente());
        venta.setUsuario(cliente);
        venta.setIva(ventaDto.getIva());
        venta.setSubtotal(ventaDto.getSubtotal());
        venta.setTotal(ventaDto.getTotal());
        venta.setUsuarioCrea(usuario);
        venta.setUsuarioModifica(usuario);
        venta.setEstado(EstadoRegistro.ACTIVO.getEstado());
        venta.setFechaCrea(fecha);
        venta.setFechaModifica(fecha);
        return venta;
    }

}
