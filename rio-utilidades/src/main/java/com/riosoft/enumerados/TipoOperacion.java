/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.enumerados;

/**
 * @author Oljer Cando
 *
 */
public enum TipoOperacion {
    SUMA("suma"),
    RESTA("resta");

    private String tipo;

    private TipoOperacion(String tipo) {
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
