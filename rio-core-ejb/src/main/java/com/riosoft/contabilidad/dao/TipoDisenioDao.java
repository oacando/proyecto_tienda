/**
 * ******************************************************************************
 * * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.dao;

import java.util.List;

import javax.ejb.Local;

import com.riosoft.contabilidad.TipoDisenioDto;
import com.riosoft.dao.generic.GenericJpaDao;
import com.riosoft.excepciones.GenericException;
import com.riosoft.modelo.contabilidad.TipoDisenio;

/**
 * @author Oljer Cando
 *
 */
@Local
public interface TipoDisenioDao extends GenericJpaDao<TipoDisenio, Long> {
    
    /**
     * Lista los tipos de diseño que presenta para registrar un producto
     *
     * @author Oljer Cando
     * @history 7 mar. 2022 - 23:09:31 Oljer Cando
     * Versión inicial.
     * @param estado
     * @return List<TipoDisenio>
     * @throws GenericException
     */
    public List<TipoDisenioDto> diseniosDtos() throws GenericException;
    
 
    /**
     * Obtiene un diseño especifico dado el nemonico
     *
     * @author Oljer Cando
     * @history 8 mar. 2022 - 15:57:32 Oljer Cando
     * Versión inicial.
     * @param nemonico
     * @return TipoDisenio
     * @throws GenericException
     */
    public TipoDisenio disenioPorNemonico(String nemonico) throws GenericException;
}
