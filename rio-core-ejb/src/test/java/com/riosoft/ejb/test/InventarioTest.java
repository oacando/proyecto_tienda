/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.ejb.test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.Test;

import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.contabilidad.Inventario;

/**
 * @author Oljer Cando
 */
public class InventarioTest extends TestServicioBase {
    public InventarioTest() {
    }

    @Test
    public void validarExistenciaProducto() throws GenericException {
        try {
            if (inventarioDaoImpl.obtenerStock(1L)) {
                System.out.println("existe");
            } else {
                System.out.println("No existe");
            }
        } catch (final GenericException e) {
            throw new GenericException(e.getMessage(), e);
        }
    }
    
    @Test
    public void obtenerProducto() throws GenericException {
        try {
          final Inventario inventario =  inventarioDaoImpl.buscarPorIdProducto(1L);
          System.out.println(inventario.getId());
        } catch (final GenericException e) {
            throw new GenericException(e.getMessage(), e);
        }
    }
    
    @Test
    public void calcular() {
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        double utilidad = 0.15;
        BigDecimal precioCompra = new BigDecimal("25");
        BigDecimal valutilidad = new BigDecimal(Double.toString(utilidad));
        BigDecimal resUtilidad = precioCompra.multiply(valutilidad);
        precioCompra = precioCompra.add(resUtilidad);
        System.out.println(precioCompra);
    }


}
