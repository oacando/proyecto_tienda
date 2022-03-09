/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.enumerados;

/**
 * Enumerado para los estados lógicos de las tablas
 * 
 * @author Oljer Cando
 */
public enum EstadoRegistro {

    ACTIVO(Boolean.TRUE),
    ELIMINADO(Boolean.FALSE);

    private final Boolean estado;

    EstadoRegistro(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return this.estado;
    }

}
