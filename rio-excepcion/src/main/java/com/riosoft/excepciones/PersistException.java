/**
 * Prueba Todo uno
 */
package com.riosoft.excepciones;

import javax.ejb.ApplicationException;

/**
 * @author Oljer Cando
 */
@ApplicationException(rollback = true)
public class PersistException extends Exception{
    

    private static final long serialVersionUID = 1L;
    public static final String FORMATO_MENSAJE = "Se produjo un error al intentar insertar datos en la tabla %s, entidad %s.";

    public PersistException(Object entity) {
        super(GenericException.format(FORMATO_MENSAJE, entity));
    }

    public PersistException(Object entity, Throwable ex) {
        super(GenericException.format(FORMATO_MENSAJE, entity), ex);
    }

}
