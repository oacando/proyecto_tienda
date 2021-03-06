/**
 *
 */
package com.riosoft.contabilidad.servicio;

import java.util.Date;

import javax.ejb.Local;

import com.riosoft.contabilidad.CompraDto;
import com.riosoft.excepciones.GenericException;

/**
 * @author Oljer Cando
 */
@Local
public interface ServicioCompra {

    /**
     * Proceso para registrar una compra
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 18:48:20 Oljer Cando
     *          Versión inicial.
     * @param compraDto
     * @throws GenericException
     */
    public void guardar(CompraDto compraDto, String usuario, Date fecha) throws GenericException;

}
