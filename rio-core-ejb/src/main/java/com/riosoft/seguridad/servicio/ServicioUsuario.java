/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.seguridad.servicio;

import java.util.Date;

import javax.ejb.Local;

import com.riosoft.excepciones.GenericException;
import com.riosoft.seguridad.UsuarioDto;



/**
 * @author Oljer Cando
 *
 */
@Local
public interface ServicioUsuario {

    /**
     * proceso que tiene como objetivo verificar la existencia de un correo
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 08:02:19 Oljer Cando
     * Versión inicial.
     * @param correo
     * @return
     * @throws GenericException
     */
    public Boolean veficarExistenciaPorCorreo(String correo)throws GenericException;
    
    /**
     * Proceso de registro de usuario
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 08:06:01 Oljer Cando
     * Versión inicial.
     * @param usuarioDto
     * @param usuario
     * @param fecha
     * @throws GenericException
     */
    public void guardar(UsuarioDto usuarioDto, String usuario, Date fecha)throws GenericException;
    
   
}
