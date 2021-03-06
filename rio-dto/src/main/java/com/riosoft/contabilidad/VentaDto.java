/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors:prueba
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
public class VentaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String numeroFactura;
    private Date fechaVenta;
    private Long idCliente;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal total;
    private List<DetalleVentaDto> detalleVenta;

    public VentaDto() {
        super();
    }

    public List<DetalleVentaDto> getDetalleVenta() {
        return this.detalleVenta;
    }

    public Date getFechaVenta() {
        return this.fechaVenta;
    }

    public Long getId() {
        return this.id;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }

    public BigDecimal getIva() {
        return this.iva;
    }

    public String getNumeroFactura() {
        return this.numeroFactura;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setDetalleVenta(List<DetalleVentaDto> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
