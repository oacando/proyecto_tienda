/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors:prueba
 * *****************************************************************************
 */
package com.riosoft.seguridad.rest.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;
import com.riosoft.enumerados.TipoMensaje;
import com.riosoft.excepciones.GenericException;
import com.riosoft.seguridad.ResponseDTO;
import com.riosoft.seguridad.UsuarioDto;
import com.riosoft.seguridad.rest.UsuarioRest;
import com.riosoft.seguridad.servicio.ServicioUsuario;
import com.riosoft.util.JsonUtil;

/**
 * @author Oljer Cando
 */
public class UsuarioRestimpl implements UsuarioRest {
    private final Logger log = Logger.getLogger(this.getClass());
    private final JsonUtil jsonUtil = new JsonUtil();

    @EJB(lookup = "java:global/rio-core-ejb/ServicioUsuarioImpl!com.riosoft.seguridad.servicio.ServicioUsuario")
    private ServicioUsuario servicioUsuario;

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
     * @see com.riosoft.seguridad.rest.UsuarioRest#registrar(java.lang.String)
     */
    @Override
    public Response registrar(String param) {
        final ResponseDTO<UsuarioDto> respuesta = new ResponseDTO<>();
        UsuarioDto usuarioDto = null;
        final Date fecha = new Date();
        final String usuario = "usuario.prueba";// this.accessToken.getPreferredUsername();
        try {
            this.jsonUtil.getJson(param);
            usuarioDto = this.jsonUtil.jsonToClass(param, UsuarioDto.class);
        } catch (final Exception e) {
            respuesta.setMensaje("Los datos de entrada no son v??lidos");
            respuesta.setTipoMensaje(TipoMensaje.ERROR.toString());
            if (null != e.getCause()) {
                this.log.error(e.getMessage(), e);
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
        }
        try {
            this.servicioUsuario.guardar(usuarioDto, usuario, fecha);
            respuesta.setDato(usuarioDto);
            return Response.status(Response.Status.OK).entity(respuesta).build();
        } catch (final GenericException e) {
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
    }

    /*
     * (non-Javadoc)
     * @see com.riosoft.seguridad.rest.UsuarioRest#verificarExistenciaPorCorreo(java.lang.String)
     */
    @Override
    public Response verificarExistenciaPorCorreo(String param) {
        final ResponseDTO<Boolean> respuesta = new ResponseDTO<>();
        String correo = null;
        try {
            final JsonObject data = this.jsonUtil.getJson(param);
            correo = data.get("correo").getAsString();
        } catch (final Exception e) {
            respuesta.setMensaje("Los datos de entrada no son v??lidos");
            respuesta.setTipoMensaje(TipoMensaje.ERROR.toString());
            if (null != e.getCause()) {
                this.log.error(e.getMessage(), e);
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(respuesta).build();
        }
        try {
            respuesta.setDato(this.servicioUsuario.veficarExistenciaPorCorreo(correo));
            return Response.status(Response.Status.OK).entity(respuesta).build();
        } catch (final GenericException e) {
            return this.error(respuesta, e);
        }
    }

}
