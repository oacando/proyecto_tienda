/**
 * ******************************************************************************
 ** Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Oljer Cando
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoDisenioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nemonico;
    private String nombre;

    public TipoDisenioDto() {
        super();
    }

    public TipoDisenioDto(Long id, String nemonico, String nombre) {
        super();
        this.id = id;
        this.nemonico = nemonico;
        this.nombre = nombre;
    }

    public Long getId() {
        return this.id;
    }

    public String getNemonico() {
        return this.nemonico;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
