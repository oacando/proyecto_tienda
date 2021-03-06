/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.ejb.test;

import java.util.Date;

import org.junit.Test;

import com.riosoft.enumerados.EstadoRegistro;
import com.riosoft.excepciones.GenericException;
import com.riosoft.excepciones.PersistException;
import com.riosoft.modelo.seguridad.Usuario;
import com.riosoft.util.GeneradorCodigo;

/**
 * @author Oljer Cando
 */
public class UsuarioTest extends TestServicioBase {

    public UsuarioTest() {

    }

    /**
     * valida la existencia de un correo en la entidad usuario
     *
     * @author Oljer Cando
     * @history 9 mar. 2022 - 07:55:51 Oljer Cando
     *          Versión inicial.
     */
    @Test
    public void verficarExistenciaUsuarioPorCorreo() {
        try {
            if (usuarioDaoImpl.veficarExistenciaPorCorreo("oljer.cando@abc.com")) {
                System.out.println("existe");
            } else {
                System.out.println("no existe");
            }
        } catch (final GenericException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void registrar() {
        final Usuario user = new Usuario();
        user.setAlias("Emita");
        user.setClave("123");
        user.setCodigoActivacion("VZAPJS");
        user.setCorreo("emita@abc.com");
        user.setDireccion("");
        user.setNombres("Emita");
        user.setEstado(EstadoRegistro.ACTIVO.getEstado());
        user.setUsuarioCrea("ocando");
        user.setUsuarioModifica("ocando");
        user.setFechaCrea(new Date());
        user.setFechaModifica(new Date());
         try {
            usuarioDaoImpl.persist(user);
        } catch (PersistException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void pruebaGeneradorCodigo() {
       String codigo = GeneradorCodigo.getRandomString(6);
       System.out.println(codigo);
    }
}
