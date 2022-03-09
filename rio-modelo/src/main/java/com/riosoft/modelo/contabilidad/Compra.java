/**
 * ******************************************************************************
 * * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.modelo.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.riosoft.modelo.comun.EntidadBase;

/**
 * Entidad que registra las compras realizadas por la tienda
 *
 * @author Oljer Cando
 */
@Entity
@Table(name = "compra", schema = "contabilidad")
public class Compra extends EntidadBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "numero_factura", nullable = false, length = 100)
    private String numeroFactura;

    @Column(name = "fecha_compra", nullable = false)
    private Date fechaCompra;

    @Column(name = "subtotal", nullable = false, precision = 18, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "iva", nullable = false, precision = 18, scale = 2)
    private BigDecimal iva;

    @Column(name = "total", nullable = false, precision = 18, scale = 2)
    private BigDecimal total;

    public String getDescripcion() {
        return this.descripcion;
    }

    public Date getFechaCompra() {
        return this.fechaCompra;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
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
