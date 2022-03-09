/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba ocando
 * *****************************************************************************
 */
package com.riosoft.enumerados;

/**
 * @author Oljer Cando
 */
public enum TipoMensaje {
    ERROR("error"),
    ADVERTENCIA("advertencia"),
    EXITO("exito"),
    INFORMACION("informacion");

    private String tipo;

    private TipoMensaje(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }

}
