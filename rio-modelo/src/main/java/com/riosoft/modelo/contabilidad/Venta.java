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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.riosoft.modelo.comun.EntidadBase;
import com.riosoft.modelo.seguridad.Usuario;

/**
 * Entidad que regista las ventas
 *
 * @author Oljer Cando
 */
@Entity
@Table(name = "venta", schema = "contabilidad")
public class Venta extends EntidadBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "numero_factura", nullable = false, length = 100)
    private String numeroFactura;

    @Column(name = "fecha_venta", nullable = false)
    private Date fechaVenta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal subtotal;

    @Column( nullable = false, precision = 18, scale = 2)
    private BigDecimal iva;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal total;

    public Date getFechaVenta() {
        return this.fechaVenta;
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
