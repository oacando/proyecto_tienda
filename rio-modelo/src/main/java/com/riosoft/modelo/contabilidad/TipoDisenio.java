/**
 * ******************************************************************************
 * * Copyright (c) 2022 Todo 1. All rights reserved.
 * * Contributors:
 * * prueba
 * *****************************************************************************
 */
package com.riosoft.modelo.contabilidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.riosoft.modelo.comun.EntidadBase;

/**
 * Entidad que registra de los tipos de disenio para los productos
 *
 * @author Oljer Cando
 */
@Entity
@Table(name = "tipo_disenio", schema = "contabilidad")
public class TipoDisenio extends EntidadBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "nemonico_grupo", nullable = false, length = 200)
    private String nemonicoGrupo;

    public String getNemonicoGrupo() {
        return this.nemonicoGrupo;
    }

    public void setNemonicoGrupo(String nemonicoGrupo) {
        this.nemonicoGrupo = nemonicoGrupo;
    }

    @Column(nullable = false, length = 200)
    private String nemonico;

    @Column(nullable = false, length = 300)
    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNemonico() {
        return this.nemonico;
    }

    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
    }
}
