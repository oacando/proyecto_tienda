/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Oljer Cando
 */
public class DateUtil {
    private static final Locale LOCALE_EC = new Locale("es", "ES");

    /**
     * Permite dar formato a un objeto {@code Date}
     * Versión inicial.
     *
     * @param fecha
     *            Objeto {@code Date}
     * @param formato
     *            Formato de la fecha/hora
     *            <ul>
     *            <li>dd/MM/yyyy</li>
     *            <li>dd/MM/yyyy HH:mm</li>
     *            <li>yyyy-MM-dd</li>
     *            <li>yyyy-MM-dd HH:mm</li>
     *            <li>HH:mm</li>
     *            <li>etc</li>
     *            </ul>
     * @return Fecha/hora con formato
     * @throws ParseException
     */
    public static String fechaHoraConFormato(Date fecha, String formato) {
        return formato(formato).format(fecha);
    }

    /**
     * Permite transformar un objeto {@code Date} a un formato de fecha y hora
     * Versión inicial.
     *
     * @param fecha
     *            Fecha
     * @return Fecha con formato Ejm: 12 marzo de 2019, a las 09:52
     */
    public static String fechaHoraLarga(Date fecha) {
        return formato("dd MMMM 'de' yyyy, 'a las' HH:mm").format(fecha);
    }

    /**
     * Permite transformar un objeto {@code Date} a un formato de fecha
     *
     *          Versión inicial.
     * @param fecha
     *            Fecha
     * @return Fecha con formato Ejm: 12 marzo de 2019
     */
    public static String fechaLarga(Date fecha) {
        return formato("dd MMMM 'de' yyyy").format(fecha);
    }

    /**
     * Genera un {@code SimpleDateFormat} a partir de un formato especifico.
     * Versión inicial.
     *
     * @param formato
     *            Formato de fecha
     * @return {@code SimpleDateFormat}
     */
    private static final SimpleDateFormat formato(String formato) {
        return new SimpleDateFormat(formato, LOCALE_EC);
    }

    /**
     * Permite dar formato a un objeto {@code Date}
     *
     * @param fecha
     * @return Hora en formato HHhmm Ejm: 09h25
     */
    public static String hora(Date fecha) {
        return formato("HH'h'mm").format(fecha);
    }

    /**
     * Permite transformar una fecha desde una cadena a un objeto {@code Date}
     * Versión inicial.
     *
     * @param fecha
     *            Fecha en formato de cadena
     * @param formato
     *            Formato de la fecha
     *            <ul>
     *            <li>dd/MM/yyyy</li>
     *            <li>dd/MM/yyyy HH:mm</li>
     *            <li>yyyy-MM-dd</li>
     *            <li>yyyy-MM-dd HH:mm</li>
     *            <li>etc</li>
     *            </ul>
     * @return Fecha parseada {@code Date}
     * @throws ParseException
     */
    public static Date parse(String fecha, String formato) throws ParseException {
        return formato(formato).parse(fecha);
    }

    /**
     * Permite transformar una fecha desde una cadena un objeto {@code Date}
     * Versión inicial.
     *
     * @param fecha
     *            Fecha en el formato {@code dd/MM/yyyy}
     * @return Fecha parseada {@code Date}
     * @throws ParseException
     */
    public static Date parseDesdeFechaCorta(String fecha) throws ParseException {
        return formato("dd/MM/yyyy").parse(fecha);
    }

    /**
     * Permite transformar una fecha desde una cadena un objeto {@code Date}
     * Versión inicial.
     *
     * @param fecha
     *            Fecha en el formato {@code yyyy-MM-dd}
     * @return Fecha parseada {@code Date}
     * @throws ParseException
     */
    public static Date parseDesdeFechaCortaGuion(String fecha) throws ParseException {
        return formato("yyyy-MM-dd").parse(fecha);
    }

    /**
     * Permite transformar una fecha desde una cadena un objeto {@code Date}
     * Versión inicial.
     *
     * @param fecha
     *            Fecha en el formato {@code dd/MM/yyyy HH:mm}
     * @return Fecha parseada {@code Date}
     * @throws ParseException
     */
    public static Date parseDesdeFechaHoraCorta(String fecha) throws ParseException {
        return formato("dd/MM/yyyy HH:mm").parse(fecha);
    }

    /**
     * Permite transformar una fecha desde una cadena un objeto {@code Date}
     * Versión inicial.
     *
     * @param fecha
     * @return Fecha parseada {@code Date}
     * @throws ParseException
     */
    public static Date parseDesdeFechaHoraCortaGuion(String fecha) throws ParseException {
        return formato("yyyy-MM-dd HH:mm").parse(fecha);
    }

    private DateUtil() {
    }
}
