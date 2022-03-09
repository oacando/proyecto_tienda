/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.contabilidad.servicio.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.contabilidad.CompraDto;
import com.riosoft.contabilidad.dao.CompraDao;
import com.riosoft.contabilidad.servicio.ServicioCompra;
import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.modelo.contabilidad.Compra;

/**
 * @author Oljer Cando
 */
@Stateless
public class ServicioCompraImpl implements ServicioCompra {

    @EJB
    private CompraDao compraDao;

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.servicio.ServicioCompra#guardar(com.riosoft.contabilidad.CompraDto)
     */
    @Override
    public void guardar(CompraDto compraDto, String usuario, Date fecha) throws GenericException {
        try {
            final Compra compra = this.toCompra(compraDto, usuario, fecha);
            this.compraDao.persist(compra);
            compraDto.setId(compra.getId());
        } catch (final PersistException e) {
            throw new GenericException(e.getMessage(), e);
        }
    }

    /**
     * Mapping CompraDto to Entity Compra 
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 19:41:02 Oljer Cando
     *          Versión inicial.
     * @param compraDto
     * @param usuario
     * @param fecha
     * @return
     */
    private Compra toCompra(CompraDto compraDto, String usuario, Date fecha) {
        final Compra compra = new Compra();
        compra.setUsuarioCrea(usuario);
        compra.setUsuarioModifica(usuario);
        compra.setFechaCrea(fecha);
        compra.setFechaModifica(fecha);
        compra.setEstado(EstadoRegistro.ACTIVO.getEstado());
        compra.setDescripcion(compraDto.getDescripcion());
        compra.setNumeroFactura(compraDto.getNumeroFactura());
        compra.setFechaCompra(compraDto.getFechaCompra());
        compra.setSubtotal(compraDto.getSubTotal());
        compra.setIva(compraDto.getIva());
        compra.setTotal(compraDto.getTotal());
        return compra;
    }

}
