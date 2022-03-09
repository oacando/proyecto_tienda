/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors:prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Oljer Cando
 */
public class DetalleVentaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idProducto;
    private Long cantidad;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    public DetalleVentaDto() {
        super();
    }

    public Long getCantidad() {
        return this.cantidad;
    }

    public Long getId() {
        return this.id;
    }

    public Long getIdProducto() {
        return this.idProducto;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
