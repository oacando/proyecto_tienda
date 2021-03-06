/**
 * ******************************************************************************
 * * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.modelo.contabilidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.riosoft.modelo.comun.EntidadBase;

/**
 * Entidad que registra los productos
 * @author Oljer Cando
 *
 */
@Entity
@Table(name = "producto", schema = "contabilidad")
public class Producto extends EntidadBase implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_disenio", nullable = false)
    private TipoDisenio tipoDisenio;

    public TipoDisenio getTipoDisenio() {
        return tipoDisenio;
    }

    public void setTipoDisenio(TipoDisenio tipoDisenio) {
        this.tipoDisenio = tipoDisenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
