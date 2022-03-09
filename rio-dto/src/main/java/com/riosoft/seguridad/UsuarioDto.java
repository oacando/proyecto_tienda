/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.seguridad;

import java.io.Serializable;

/**
 * @author Oljer Cando
 */
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String alias;
    private String nombres;
    private String correo;
    private String direccion;
    private String clave;
    private String codigoActivacion;

    public UsuarioDto() {
        super();
    }

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

    public Long getId() {
        return this.id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
