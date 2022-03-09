/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.enumerados;

/**
 * Reglas de stock minimo
 *
 * @author Oljer Cando
 */
public enum Stock {
    MINIMO(1),
    MAXIMO(1000);

    private final Integer stock;

    Stock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return this.stock;
    }

}
