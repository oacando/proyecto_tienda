/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors:prueba
 * *****************************************************************************
 */
package com.riosoft.contabilidad.rest.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.riosoft.contabilidad.VentaDto;
import com.riosoft.contabilidad.facade.VentaFacade;
import com.riosoft.contabilidad.rest.VentaRest;
import com.riosoft.enumerados.TipoMensaje;
import com.riosoft.excepciones.GenericException;
import com.riosoft.seguridad.ResponseDTO;
import com.riosoft.util.JsonUtil;

/**
 * @author Oljer Cando
 */
public class VentaRestImpl implements VentaRest {

    private final Logger log = Logger.getLogger(this.getClass());
    private final JsonUtil jsonUtil = new JsonUtil();

    @EJB(lookup = "java:global/rio-core-ejb/VentaFacadeImpl!com.riosoft.contabilidad.facade.VentaFacade")
    private VentaFacade ventaFacade;

    private Response error(ResponseDTO<Boolean> respuesta, GenericException e) {
        String mensaje = e.getMessage();
        if ((null != e.getInfo()) && !e.getInfo().isEmpty()) {
            mensaje = e.getMessage() + " Datos: [ " + e.getInfo() + " ]";
        }
        respuesta.setMensaje(mensaje);
        respuesta.setTipoMensaje(TipoMensaje.ERROR.toString());
        if (null != e.getCause()) {
            this.log.error(mensaje, e);
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
    }

    /*
     * (non-Javadoc)
     * @see com.riosoft.contabilidad.rest.VentaRest#registrar(java.lang.String)
     */
    @Override
    public Response registrar(String param) {
        final ResponseDTO<Boolean> respuesta = new ResponseDTO<>();
        VentaDto ventaDto = null;
        final Date fecha = new Date();
        final String usuario = "usuario.prueba";// this.accessToken.getPreferredUsername();
        try {
            ventaDto = this.jsonUtil.jsonToClass(param, VentaDto.class);
        } catch (final Exception e) {
            respuesta.setMensaje("Los datos de entrada no son v??lidos");
            respuesta.setTipoMensaje(TipoMensaje.ERROR.toString());
            if (null != e.getCause()) {
                this.log.error(e.getMessage(), e);
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
        }
        try {
            this.ventaFacade.ingresarVenta(ventaDto, usuario, fecha);
            respuesta.setDato(true);
            return Response.status(Response.Status.OK).entity(respuesta).build();
        } catch (final GenericException e) {
            return this.error(respuesta, e);
        }
    }

}
