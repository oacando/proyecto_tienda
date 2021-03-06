/**
 * ******************************************************************************
 *  Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao;

import javax.ejb.Local;

import com.riosoft.dao.generic.GenericJpaDao;
import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.contabilidad.Inventario;

/**
 * @author Oljer Cando
 */
@Local
public interface InventarioDao extends GenericJpaDao<Inventario, Long> {

    /**
     * Verifica la existencia de un producto
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 16:58:19 Oljer Cando
     *          Versión inicial.
     * @param idProducto
     * @return boolean
     * @throws GenericException
     */
    public Boolean obtenerStock(Long idProducto) throws GenericException;
    
    /**
     * Obtiene el inventario dado el idProducto
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 20:22:44 Oljer Cando
     * Versión inicial.
     * @return
     * @throws GenericException
     */
    public Inventario buscarPorIdProducto(Long idProducto)throws GenericException;
    
    /**
     * verifica si el producto existe en la entidad inventario
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 10:06:20 Oljer Cando
     * Versión inicial.
     * @param idProducto
     * @return
     * @throws GenericException
     */
    public Boolean existeProducto(Long idProducto) throws GenericException;

}
