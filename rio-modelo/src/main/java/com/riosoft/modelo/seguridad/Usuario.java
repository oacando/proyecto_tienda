/**
 * ******************************************************************************
 * * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.modelo.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.riosoft.modelo.comun.EntidadBase;

/**
 * Entidad que registra los usuarios de la tienda
 *
 * @author Oljer Cando
 */
@Entity
@Table(name = "usuario", schema = "seguridad")
public class Usuario extends EntidadBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 100)
    private String alias;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 25)
    private String clave;

    @Column(name = "codigo_activacion", length = 20)
    private String codigoActivacion;

    public String getAlias() {
        return this.alias;
    }

    public String getClave() {
        return this.clave;
    }

    public String getCodigoActivacion() {
        return this.codigoActivacion;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCodigoActivacion(String codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
