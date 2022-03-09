/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Oljer Cando
 */
public class CompraDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String numeroFactura;
    private String descripcion;
    private Date fechaCompra;
    private BigDecimal subTotal;
    private BigDecimal iva;
    private BigDecimal total;
    private List<DetalleCompraDto> detalleCompra;

    public CompraDto() {
        super();
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public List<DetalleCompraDto> getDetalleCompra() {
        return this.detalleCompra;
    }

    public Date getFechaCompra() {
        return this.fechaCompra;
    }

    public Long getId() {
        return this.id;
    }

    public BigDecimal getIva() {
        return this.iva;
    }

    public String getNumeroFactura() {
        return this.numeroFactura;
    }

    public BigDecimal getSubTotal() {
        return this.subTotal;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDetallesCompra(List<DetalleCompraDto> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
