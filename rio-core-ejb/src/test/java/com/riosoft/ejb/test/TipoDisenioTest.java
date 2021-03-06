
package com.riosoft.ejb.test;

import org.junit.Test;

import com.riosoft.modelo.contabilidad.TipoDisenio;

/**
 * @author Oljer Cando
 */
public class TipoDisenioTest extends TestServicioBase {
    public TipoDisenioTest() {
    }
    
    

    /**
     * Obtiene el tipo diseño para poblar los productos
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 16:35:11 Oljer Cando
     *          Versión inicial.
     */
    @Test
    public void obtenerTipoDiseño() {
        try {
            final TipoDisenio tipoDiseño = tipoDisenioDaoImpl.disenioPorNemonico("FLASH");
            System.out.println(tipoDiseño.getNombre());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
