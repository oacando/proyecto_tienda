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
public class ProductoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nombre;
    private TipoDisenioDto tipoDisenioDto;

    public ProductoDto() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public TipoDisenioDto getTipoDisenioDto() {
        return this.tipoDisenioDto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoDisenioDto(TipoDisenioDto tipoDisenioDto) {
        this.tipoDisenioDto = tipoDisenioDto;
    }
}
