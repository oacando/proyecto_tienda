/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.contabilidad.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.contabilidad.CompraDto;
import com.riosoft.contabilidad.DetalleCompraDto;
import com.riosoft.contabilidad.dao.DetalleCompraDao;
import com.riosoft.contabilidad.servicio.ServicioDetalleCompra;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.modelo.contabilidad.Compra;
import com.riosoft.modelo.contabilidad.DetalleCompra;
import com.riosoft.modelo.contabilidad.Producto;

/**
 * @author Oljer Cando
 */
@Stateless
public class ServicioDetalleCompraImpl implements ServicioDetalleCompra {

    @EJB
    private DetalleCompraDao detalleCompraDao;

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.servicio.ServicioDetalleCompra#guardar(com.riosoft.contabilidad.CompraDto, java.lang.String, java.util.Date)
     */
    @Override
    public void guardar(CompraDto compraDto, String usuario, Date fecha) throws GenericException {
        try {
            this.detalleCompraDao.persist(this.toDetalleCompra(compraDto, usuario, fecha));
        } catch (final PersistException e) {
            throw new GenericException(e.getMessage(), e);
        }
    }

    /**
     * Mapping List<DetalleCompra>
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 20:11:39 Oljer Cando
     *          Versión inicial.
     * @param compraDto
     * @param usuario
     * @param fecha
     * @return
     */
    private List<DetalleCompra> toDetalleCompra(CompraDto compraDto, String usuario, Date fecha) {
        final List<DetalleCompra> detallesCompras = new ArrayList<>();
        final Compra compra = new Compra();
        compra.setId(compraDto.getId());
        for (final DetalleCompraDto detalleCompraDto : compraDto.getDetalleCompra()) {
            final DetalleCompra detalleCompra = this.toDetalleCompra(detalleCompraDto, compra);
            detalleCompra.setEstado(EstadoRegistro.ACTIVO.getEstado());
            detalleCompra.setUsuarioCrea(usuario);
            detalleCompra.setUsuarioModifica(usuario);
            detalleCompra.setFechaCrea(fecha);
            detalleCompra.setFechaModifica(fecha);
            detallesCompras.add(detalleCompra);
        }
        return detallesCompras;
    }

    /**
     * Mapping to Entity
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 20:12:17 Oljer Cando
     *          Versión inicial.
     * @param detalleCompraDto
     * @param compra
     * @return
     */
    private DetalleCompra toDetalleCompra(DetalleCompraDto detalleCompraDto, Compra compra) {
        final DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setCompra(compra);
        final Producto producto = new Producto();
        producto.setId(detalleCompraDto.getIdProducto());
        detalleCompra.setProducto(producto);
        detalleCompra.setCantidad(detalleCompraDto.getCantidad());
        detalleCompra.setValorUnitario(detalleCompraDto.getValorUnitario());
        detalleCompra.setValorTotal(detalleCompraDto.getValorTotal());
        return detalleCompra;
    }

}
