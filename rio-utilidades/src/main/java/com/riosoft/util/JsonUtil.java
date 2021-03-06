/**
 * ******************************************************************************
 * Copyright (c) 2022 Todo 1. All rights reserved.
 * Contributors: prueba
 * *****************************************************************************
 */
package com.riosoft.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author oljer.cando
 */
public class JsonUtil {

    /**
     * Permite obtener el json codificado para su posterior deserialización
     *
     *          Versión inicial.
     * @param data
     *            Datos de entrada
     * @param gson
     *            Componente que transforma los datos de entrada a un JSON
     * @return json decodificado {@code JSON}
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings({ "unchecked" })
    private String decodeJson(String data, Gson gson) throws UnsupportedEncodingException {
        final Map<Object, Object> inputMapParam = gson.fromJson(data, HashMap.class);
        final String jsonEncrypted = inputMapParam.get("dato").toString();
        final byte[] decodedByte = Base64.getDecoder().decode(jsonEncrypted);
        final String decodedString = new String(decodedByte, StandardCharsets.UTF_8);
        return URLDecoder.decode(decodedString, StandardCharsets.UTF_8.name());
    }

    /**
     * Permite obtener un {@code JsonObject} a partir de un json codificado
     *
     *          Versión inicial.
     * @param data
     * @return {@code JsonObject}
     * @throws UnsupportedEncodingException
     * @throws JsonSyntaxException
     */
    public JsonObject getJson(String data) throws UnsupportedEncodingException {
        final Gson gson = new Gson();
        final String decodedJson = this.decodeJson(data, gson);
        return new JsonParser().parse(decodedJson).getAsJsonObject();
    }

    /**
     * Permite serializar un string json a un objeto {@code JsonObject}
     *
     *          Versión inicial.
     * @param json
     * @return JSON Serializado
     */
    public JsonObject jsonDecoded(String json) {
        return new JsonParser().parse(json).getAsJsonObject();
    }

    /**
     * Permite serializar un json a un objeto {@code Class<T>}
     *
     *          Versión inicial.
     * @param <T>
     *            Tipo de objeto a retornar
     * @param json
     *            Objeto json sin codificar
     * @param cls
     *            Objeto destino {@code Class<T>}
     * @return Objeto serializado {@code T}
     */
    public <T> T jsonDecodedToClass(String json, Class<T> cls) {
        final Gson gson = new Gson();
        return gson.fromJson(json, cls);
    }

    /**
     * @param <T>
     * @param data
     * @param cls
     * @return
     * @throws UnsupportedEncodingException
     */
    public <T> List<T> jsonEncodedToList(String data, Class<T[]> cls) throws UnsupportedEncodingException {
        final Gson gson = new Gson();
        final String decodedJson = this.decodeJson(data, gson);
        final T[] jsonToObject = new Gson().fromJson(decodedJson, cls);
        return Arrays.asList(jsonToObject);
    }

    /**
     * Permite serializar un json a un objeto {@code <T>}
     * @param <T>
     *            Cualquier clase DTO
     * @param data
     *            json codificado
     * @param cls
     *            Nombre de clase destino {@code Class<T>}
     * @return Objeto serializado {@code T}
     * @throws UnsupportedEncodingException
     */
    public <T> T jsonToClass(String data, Class<T> cls) throws UnsupportedEncodingException {
        final Gson gson = new Gson();
        final String decodedJson = this.decodeJson(data, gson);
        return gson.fromJson(decodedJson, cls);
    }

    /**
     * Permite serializar un json a un objeto o tipo de dato personalizado {@code Type}
     *
     *          Versión inicial.
     * @param <T>
     *            Tipo de objeto a retornar
     * @param json
     *            Objeto Json sin codificar
     * @param userType
     *            Tipo de dato personalizado
     * @return Objeto personalizado
     */
    public <T> T jsonToClass(String json, Type userType) {
        final Gson gson = new Gson();
        return gson.fromJson(json, userType);
    }

    /**
     * Permite obtener un listado de objetos a partir de un json
     *
     *          Versión inicial.
     * @param <T>
     *            Tipo de item
     * @param json
     *            json
     * @param cls
     *            Array de objetos destino
     * @return Listado de objetos
     * @throws UnsupportedEncodingException
     */
    public <T> List<T> jsonToList(String json, Class<T[]> cls) {
        final T[] jsonToObject = new Gson().fromJson(json, cls);
        return Arrays.asList(jsonToObject);
    }

    /**
     * Convierte el base 64 a bytes. Se usa para el certificado.
     *
     *          Versión inicial.
     * @param strBase64
     * @return
     */
    public byte[] strBase64ToBytes(String strBase64) {
        return Base64.getDecoder().decode(strBase64);
    }
}