/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors:prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Oljer Cando
 */
@Path("ventas/")
@Produces(MediaType.APPLICATION_JSON)
public interface VentaRest {

    /**
     * Api Rest que registra una venta de la tienda
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 10:44:12 Oljer Cando
     *          Versión inicial.
     * @param param
     * @return
     */
    @POST
    @Path("registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrar(String param);
}
