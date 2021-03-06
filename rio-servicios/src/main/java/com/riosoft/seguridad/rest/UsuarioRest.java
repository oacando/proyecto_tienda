/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors:prueba
 * *****************************************************************************
 */
package com.riosoft.seguridad.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jakarta.ws.rs.GET;

/**
 * @author Oljer Cando
 */
@Path("usuario/")
@Produces(MediaType.APPLICATION_JSON)
public interface UsuarioRest {

    /**
     * Registra una cuenta de usaurio
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 08:38:18 Oljer Cando
     *          Versión inicial.
     * @param param
     * @return
     */
    @POST
    @Path("registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrar(String param);

    /**
     * Valida la cuenta de usuario
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 08:38:37 Oljer Cando
     *          Versión inicial.
     * @param param
     * @return
     */
    @GET
    @Path("varificar-existencia")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verificarExistenciaPorCorreo(String param);
}
