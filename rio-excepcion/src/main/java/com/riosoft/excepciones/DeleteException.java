/**
 * Prueba Todo uno 
 */
package com.riosoft.excepciones;

/**
 * @author Oljer Cando
 *
 */
public class DeleteException extends Exception {
    private static final long serialVersionUID = 1L;
    public static final String FORMATO_MENSAJE = "Se produjo un error al intentar eliminar un registro en la tabla %s, entidad %s.";

    public DeleteException(Object entity) {
        super(GenericException.format(FORMATO_MENSAJE, entity));
    }

    public DeleteException(Object entity, Throwable ex) {
        super(GenericException.format(FORMATO_MENSAJE, entity), ex);
    }
}
