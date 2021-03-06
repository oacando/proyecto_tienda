/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.contabilidad.DetalleVentaDto;
import com.riosoft.contabilidad.VentaDto;
import com.riosoft.contabilidad.dao.DetalleVentaDao;
import com.riosoft.contabilidad.servicio.ServicioDetalleVenta;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.modelo.contabilidad.DetalleVenta;
import com.riosoft.modelo.contabilidad.Producto;
import com.riosoft.modelo.contabilidad.Venta;

/**
 * @author Oljer Cando
 */
@Stateless
public class ServicioDetalleVentaImpl implements ServicioDetalleVenta {

    @EJB
    private DetalleVentaDao detalleVentaDao;

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.servicio.ServicioDetalleVenta#guardar(com.riosoft.contabilidad.VentaDto, java.lang.String, java.util.Date)
     */
    @Override
    public void guardar(VentaDto ventaDto, String usuario, Date fecha) throws GenericException {
        try {
            this.detalleVentaDao.persist(this.toDetalleVenta(ventaDto, usuario, fecha));
        } catch (final PersistException e) {
            throw new GenericException(e.getMessage(), e);
        }

    }

    /**
     * Mapping DetalleVentaDto to DetalleVenta
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 09:57:37 Oljer Cando
     *          Versión inicial.
     * @param detalleVentaDto
     * @param venta
     * @return
     */
    private DetalleVenta toDetalleVenta(DetalleVentaDto detalleVentaDto, Venta venta) {
        final DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setVenta(venta);
        final Producto producto = new Producto();
        producto.setId(detalleVentaDto.getIdProducto());
        detalleVenta.setProducto(producto);
        detalleVenta.setCantidad(detalleVentaDto.getCantidad());
        detalleVenta.setValorUnitario(detalleVentaDto.getValorUnitario());
        detalleVenta.setValorTotal(detalleVentaDto.getValorTotal());
        return detalleVenta;
    }

    /**
     * Mapping DetalleVentaDto to DetalleVenta
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 09:57:37 Oljer Cando
     *          Versión inicial.
     * @param detalleVentaDto
     * @param venta
     * @return
     */
    private List<DetalleVenta> toDetalleVenta(VentaDto ventaDto, String usuario, Date fecha) {
        final List<DetalleVenta> detallesVentas = new ArrayList<>();
        final Venta venta = new Venta();
        venta.setId(ventaDto.getId());
        for (final DetalleVentaDto detalleVentaDto : ventaDto.getDetalleVenta()) {
            final DetalleVenta detalleVenta = this.toDetalleVenta(detalleVentaDto, venta);
            detalleVenta.setEstado(EstadoRegistro.ACTIVO.getEstado());
            detalleVenta.setUsuarioCrea(usuario);
            detalleVenta.setUsuarioModifica(usuario);
            detalleVenta.setFechaCrea(fecha);
            detalleVenta.setFechaModifica(fecha);
            detallesVentas.add(detalleVenta);
        }
        return detallesVentas;
    }

}
