/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.contabilidad.servicio.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.contabilidad.CompraDto;
import com.riosoft.contabilidad.DetalleCompraDto;
import com.riosoft.contabilidad.DetalleVentaDto;
import com.riosoft.contabilidad.VentaDto;
import com.riosoft.contabilidad.dao.InventarioDao;
import com.riosoft.contabilidad.servicio.ServicioInventario;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.enumerados.TipoOperacion;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.excepciones.UpdateException;
import com.riosoft.modelo.contabilidad.Inventario;
import com.riosoft.modelo.contabilidad.Producto;

/**
 * @author Oljer Cando
 */
@Stateless
public class ServicioInventarioImpl implements ServicioInventario {

    @EJB
    private InventarioDao inventarioDao;

    private void actualizarStock(Inventario inventario, Integer cantidad, String operador) throws GenericException {
        Integer stockActual = 0;
        if (operador.equals(TipoOperacion.SUMA.getTipo())) {
            stockActual = inventario.getStock() + cantidad;
        } else {
            stockActual = inventario.getStock() - cantidad;
        }
        inventario.setStock(stockActual);
        try {
            this.inventarioDao.update(inventario);
        } catch (final UpdateException e) {
            throw new GenericException(e.getMessage(), e);
        }
    }

    private BigDecimal precioVenta(BigDecimal precioCompra) {
        final NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        final double utilidad = 0.15;
        final BigDecimal valutilidad = new BigDecimal(Double.toString(utilidad));
        final BigDecimal resUtilidad = precioCompra.multiply(valutilidad);
        precioCompra = precioCompra.add(resUtilidad);
        return precioCompra;
    }

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.servicio.ServicioInventario#procesarEgreso(com.riosoft.contabilidad.CompraDto, java.lang.String, java.util.Date)
     */
    @Override
    public void procesarEgreso(VentaDto ventaDto, String usuario, Date fecha) throws GenericException {
        for (final DetalleVentaDto detalleVentaDto : ventaDto.getDetalleVenta()) {
            try {
                if (this.inventarioDao.existeProducto(detalleVentaDto.getIdProducto())) {
                    final Inventario inventario = this.inventarioDao.buscarPorIdProducto(detalleVentaDto.getIdProducto());
                    inventario.setFechaModifica(fecha);
                    inventario.setUsuarioModifica(usuario);
                    this.actualizarStock(inventario, detalleVentaDto.getCantidad().intValue(), TipoOperacion.RESTA.getTipo());
                } else {
                    final Inventario inventario = this.toInventario(detalleVentaDto, usuario, fecha);
                    try {
                        this.inventarioDao.persist(inventario);
                    } catch (final PersistException e1) {
                        throw new GenericException(e1.getMessage(), e1);
                    }
                }

            } catch (final GenericException e) {
                throw new GenericException(e.getMessage(), e);
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.servicio.ServicioInventario#procesar(com.riosoft.contabilidad.CompraDto, java.lang.String, java.util.Date)
     */
    @Override
    public void procesarIngreso(CompraDto compraDto, String usuario, Date fecha) throws GenericException {
        for (final DetalleCompraDto detalleCompraDto : compraDto.getDetalleCompra()) {
            try {
                final Inventario inventario = this.inventarioDao.buscarPorIdProducto(detalleCompraDto.getIdProducto());
                inventario.setFechaModifica(fecha);
                inventario.setUsuarioModifica(usuario);
                this.actualizarStock(inventario, detalleCompraDto.getCantidad().intValue(), TipoOperacion.SUMA.getTipo());
            } catch (final GenericException e) {
                final Inventario inventario = this.toInventario(detalleCompraDto, usuario, fecha);
                try {
                    this.inventarioDao.persist(inventario);
                } catch (final PersistException e1) {
                    throw new GenericException(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Mapping Dto to entity
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 10:21:05 Oljer Cando
     * Versi??n inicial.
     * @param detalleCompraDto
     * @param usuario
     * @param fecha
     * @return
     */
    private Inventario toInventario(DetalleCompraDto detalleCompraDto, String usuario, Date fecha) {
        final Inventario inventario = new Inventario();
        final Producto producto = new Producto();
        producto.setId(detalleCompraDto.getIdProducto());
        inventario.setProducto(producto);
        inventario.setPrecioCompra(detalleCompraDto.getValorUnitario());
        inventario.setPrecioVenta(this.precioVenta(detalleCompraDto.getValorUnitario()));
        inventario.setStock(detalleCompraDto.getCantidad().intValue());
        inventario.setEstado(EstadoRegistro.ACTIVO.getEstado());
        inventario.setFechaCrea(fecha);
        inventario.setFechaModifica(fecha);
        inventario.setUsuarioCrea(usuario);
        inventario.setUsuarioModifica(usuario);
        return inventario;
    }

    /**
     * Mapping Dto to entity
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 10:21:05 Oljer Cando
     * Versi??n inicial.
     * @param detalleCompraDto
     * @param usuario
     * @param fecha
     * @return
     */
    private Inventario toInventario(DetalleVentaDto detalleventaDto, String usuario, Date fecha) {
        final Inventario inventario = new Inventario();
        final Producto producto = new Producto();
        producto.setId(detalleventaDto.getIdProducto());
        inventario.setProducto(producto);
        inventario.setPrecioCompra(detalleventaDto.getValorUnitario());
        inventario.setPrecioVenta(this.precioVenta(detalleventaDto.getValorUnitario()));
        inventario.setStock(detalleventaDto.getCantidad().intValue());
        inventario.setEstado(EstadoRegistro.ACTIVO.getEstado());
        inventario.setFechaCrea(fecha);
        inventario.setFechaModifica(fecha);
        inventario.setUsuarioCrea(usuario);
        inventario.setUsuarioModifica(usuario);
        return inventario;
    }

}
