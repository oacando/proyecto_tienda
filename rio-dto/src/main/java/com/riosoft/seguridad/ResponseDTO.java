/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors:prueba
 * 
 * *****************************************************************************
 */
package com.riosoft.seguridad;

/**
 * @author Oljer Cando
 *
 */
public class ResponseDTO<T> {
    private String mensaje;
    private Integer totalFilas;
    private String tipoMensaje;
    private T dato;

    public ResponseDTO() {
        super();
        this.totalFilas = 0;
        this.mensaje = "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getTotalFilas() {
        return totalFilas;
    }

    public void setTotalFilas(Integer totalFilas) {
        this.totalFilas = totalFilas;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

}
