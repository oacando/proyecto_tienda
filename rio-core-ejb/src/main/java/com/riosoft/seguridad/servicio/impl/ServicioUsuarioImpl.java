/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.seguridad.servicio.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.modelo.seguridad.Usuario;
import com.riosoft.seguridad.UsuarioDto;
import com.riosoft.seguridad.dao.UsuarioDao;
import com.riosoft.seguridad.servicio.ServicioUsuario;
import com.riosoft.util.GeneradorCodigo;

/**
 * @author Oljer Cando
 */
@Stateless
public class ServicioUsuarioImpl implements ServicioUsuario {

    @EJB
    private UsuarioDao usuarioDao;

    /*
     * (non-Javadoc)
     * @see com.riosoft.seguridad.servicio.ServicioUsuario#guardar(com.riosoft.seguridad.UsuarioDto, java.lang.String, java.util.Date)
     */
    @Override
    public void guardar(UsuarioDto usuarioDto, String usuario, Date fecha) throws GenericException {
        final Usuario user = this.toUsuario(usuarioDto, usuario, fecha);
        try {
            this.usuarioDao.persist(user);
        } catch (final PersistException e) {
            throw new GenericException(e.getMessage(), e);
        }

    }

    /**
     * Mapping dto to entity
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 08:22:09 Oljer Cando
     *          Versión inicial.
     * @param usuarioDto
     * @param usuario
     * @param fecha
     * @return
     */
    private Usuario toUsuario(UsuarioDto usuarioDto, String usuario, Date fecha) {
        final Usuario user = new Usuario();
        user.setAlias(usuarioDto.getAlias());
        user.setClave(usuarioDto.getClave());
        user.setCodigoActivacion(GeneradorCodigo.getRandomString(6));
        user.setCorreo(usuarioDto.getCorreo());
        user.setDireccion(null != usuarioDto.getDireccion() ? usuarioDto.getDireccion() : "");
        user.setNombres(usuarioDto.getNombres());
        user.setEstado(EstadoRegistro.ACTIVO.getEstado());
        user.setUsuarioCrea(usuario);
        user.setUsuarioModifica(usuario);
        user.setFechaCrea(fecha);
        user.setFechaModifica(fecha);
        return user;
    }

    /*
     * (non-Javadoc)
     * @see com.riosoft.seguridad.servicio.ServicioUsuario#veficarExistenciaPorCorreo(java.lang.String)
     */
    @Override
    public Boolean veficarExistenciaPorCorreo(String correo) throws GenericException {
        return this.usuarioDao.veficarExistenciaPorCorreo(correo);
    }

}
