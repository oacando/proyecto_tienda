/**
 * Prueba Todo uno
 */
package com.riosoft.excepciones;

import javax.ejb.ApplicationException;

/**
 * @author Oljer Cando
 *
 */
@ApplicationException(rollback = true)
public class UpdateException extends Exception {
    private static final long serialVersionUID = 1L;
    public static final String FORMATO_MENSAJE = "Se produjo un error al intentar actualizar datos de un registro en la tabla %s, entidad %s.";

    public UpdateException(Object entity) {
        super(GenericException.format(FORMATO_MENSAJE, entity));
    }

    public UpdateException(Object entity, Throwable ex) {
        super(GenericException.format(FORMATO_MENSAJE, entity), ex);
    }

}
