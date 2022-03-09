/*-----------------------------------------------------------------------------------------
|                                    Todo 1                                                 |
|                                Quito - Ecuador                                            |
|                                                                                           |
|                               ©Copyright 2022                                             |
|                             Derechos Reservados                                           |
|
|-------------------------------------------------------------------------------------------|

-----------------------------------------------------------------------------------------/
[DEV]

- Módulo        : Todo contabilidad
- Autor         : oljer.cando
- Fecha         : 08/03/2022 16:13
- Version       : 1.0
- Comentario    : Creación de esquema para hulk_store

[TESTER]

[ ] Aplicar pruebas de estres.
[ ] Validar objetos creados y modificado.
[ ] Población de datos.
[ ] Otros.
    - DBA - Tester :
    - Fecha         :
    - Comentario  :
------------------------------------------------------------------------------------------*/


/*
Nota: El script se debe ejecutar en la base de datos hulk_store
*/

do
$$
    begin


        -- ======================================================================================================================================================================================
        -------------------------------------------------------------ESQUEMA SEGURIDAD---------------------------------------------------------------------------------------------------
        -- =======================================================================================================================================================================================

        -- =====================================
        -- Usuario
        -- =====================================
        drop table if exists seguridad."usuario" cascade;
        CREATE TABLE seguridad."usuario"
        (
            "id"                serial                 NOT NULL,
            "alias"             character varying(100) not null,
            "nombres"           character varying(100) not null,
            "correo"            character varying(100) not null,
            "direccion"         character varying(100) not null,
            "clave"             character varying(25)  not null,
            "codigo_activacion" character varying(20),
            "estado"            boolean                not null,
            "usuario_crea"      varchar(50)            not null,
            "usuario_modifica"  varchar(50)            not null,
            "fecha_crea"        timestamptz            not null,
            "fecha_modifica"    timestamptz            not null,
            CONSTRAINT pk_usuario primary key ("id")
        ) WITHOUT OIDS;
        COMMENT ON TABLE seguridad."usuario" IS 'Tabla que contiene los usuarios del sistema';
        COMMENT ON COLUMN seguridad."usuario"."id" IS 'Identificador único del usuario';
        COMMENT ON COLUMN seguridad."usuario"."alias" IS 'Alias del usuario';
        COMMENT ON COLUMN seguridad."usuario"."nombres" IS 'Nombre de usuario';
        COMMENT ON COLUMN seguridad."usuario"."correo" IS 'Correo de usuario';
        COMMENT ON COLUMN seguridad."usuario"."direccion" IS 'Direccion de usuario';
        COMMENT ON COLUMN seguridad."usuario"."estado" IS 'Estado lógico del usuario';
        COMMENT ON COLUMN seguridad."usuario"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN seguridad."usuario"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN seguridad."usuario"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN seguridad."usuario"."fecha_modifica" IS 'Fecha de modificación del registro. ';


        -- ======================================================================================================================================================================================
        -------------------------------------------------------------ESQUEMA CONTABILIDAD--------------------------------------------------------------------------------------------------------------
        -- =======================================================================================================================================================================================

        -- =====================================
        -- tipo_disenio
        -- =====================================

        drop table if exists contabilidad."tipo_disenio" cascade;

        CREATE TABLE if not exists contabilidad."tipo_disenio"
        (
            "id"               serial       NOT NULL,
            "nemonico_grupo"   varchar(200) not null,
            "nemonico"         varchar(200) not null,
            "nombre"           varchar(300) not null,
            "estado"           boolean      not null,
            "usuario_crea"     varchar(50)  not null,
            "usuario_modifica" varchar(50)  not null,
            "fecha_crea"       timestamptz  not null,
            "fecha_modifica"   timestamptz  not null,
            CONSTRAINT pk_tipo_disenio PRIMARY KEY ("id")
        )
            WITHOUT OIDS;
        COMMENT ON TABLE contabilidad."tipo_disenio" IS 'La tabla es la proveedora de catálogos usados en el sistema';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."id" IS 'Clave primaria de la tabla';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."nemonico_grupo" IS 'Agrupador de nemonicos.';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."nemonico" IS 'Nemonico que representa a un único registro.';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."nombre" IS 'Nombre del diseño.';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."fecha_modifica" IS 'Fecha de modificación del registro. ';
        COMMENT ON COLUMN contabilidad."tipo_disenio"."estado" IS 'Estado lógico del registro: true para activo y false para eliminado';


        -- =====================================
        -- Producto
        -- =====================================
        drop table if exists contabilidad."producto" cascade;
        create table contabilidad."producto"
        (
            "id"               serial,
            "nombre"           character varying(200) not null,
            "id_tipo_disenio"  int8                   not null,
            "estado"           boolean                not null,
            "usuario_crea"     varchar(50)            not null,
            "usuario_modifica" varchar(50)            not null,
            "fecha_crea"       timestamptz            not null,
            "fecha_modifica"   timestamptz            not null,
            constraint pk_producto primary key ("id"),
            constraint fk_producto_id_tipo_disenio foreign key ("id_tipo_disenio") references contabilidad."tipo_disenio" ("id")
        ) WITHOUT OIDS;
        COMMENT ON TABLE contabilidad."producto" IS 'La tabla contiene la información de los productos';
        COMMENT ON COLUMN contabilidad."producto"."id" IS 'Identificador del producto';
        COMMENT ON COLUMN contabilidad."producto"."nombre" IS 'Nombre del producto';
        COMMENT ON COLUMN contabilidad."producto"."id_tipo_disenio" IS 'Id del tipo de disenio del de producto';
        COMMENT ON COLUMN contabilidad."producto"."estado" IS 'Estado lógico del producto';
        COMMENT ON COLUMN contabilidad."producto"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN contabilidad."producto"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN contabilidad."producto"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN contabilidad."producto"."fecha_modifica" IS 'Fecha de modificación del reg';

        -- =====================================
        -- Compra
        -- =====================================
        drop table if exists contabilidad."compra" cascade;
        create table contabilidad."compra"
        (
            "id"               serial,
            "descripcion"      character varying(200) not null,
            "numero_factura"   character varying(100) not null,
            "fecha_compra"     date                   not null,
            "subtotal"         numeric(18, 2)         not null default 0.0,
            "iva"              numeric(18, 2)         not null default 0.0,
            "total"            numeric(18, 2)         not null default 0.0,
            "estado"           boolean                not null,
            "usuario_crea"     varchar(50)            not null,
            "usuario_modifica" varchar(50)            not null,
            "fecha_crea"       timestamptz            not null,
            "fecha_modifica"   timestamptz            not null,
            constraint pk_compra primary key (id)
        ) WITHOUT OIDS;
        COMMENT ON TABLE contabilidad."compra" IS 'La tabla contiene la información de las compras generadas';
        COMMENT ON COLUMN contabilidad."compra"."id" IS 'Identificador de la compra';
        COMMENT ON COLUMN contabilidad."compra"."descripcion" IS 'Descripción de compra';
        COMMENT ON COLUMN contabilidad."compra"."numero_factura" IS 'Numero del documento de compra';
        COMMENT ON COLUMN contabilidad."compra"."fecha_compra" IS 'Fecha de la compra';
        COMMENT ON COLUMN contabilidad."compra"."subtotal" IS 'Valor del subtotal';
        COMMENT ON COLUMN contabilidad."compra"."iva" IS 'Valor del iva';
        COMMENT ON COLUMN contabilidad."compra"."total" IS 'Valor total';
        COMMENT ON COLUMN contabilidad."compra"."estado" IS 'Estado lógico de la compra';
        COMMENT ON COLUMN contabilidad."compra"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN contabilidad."compra"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN contabilidad."compra"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN contabilidad."compra"."fecha_modifica" IS 'Fecha de modificación del reg';

        -- =====================================
        -- Detalle Compra
        -- =====================================
        drop table if exists contabilidad."detalle_compra" cascade;
        create table contabilidad."detalle_compra"
        (
            "id"               serial,
            "id_compra"        int8           not null,
            "id_producto"      int8           not null,
            "cantidad"         int8           not null default 0,
            "valor_unitario"   numeric(18, 2) not null default 0.0,
            "valor_total"      numeric(18, 2) not null default 0.0,
            "estado"           boolean        not null,
            "usuario_crea"     varchar(50)    not null,
            "usuario_modifica" varchar(50)    not null,
            "fecha_crea"       timestamptz    not null,
            "fecha_modifica"   timestamptz    not null,
            constraint pk_detalle_compra primary key (id),
            constraint kk_detalle_compra_compra foreign key (id_compra) references contabilidad."compra" ("id"),
            constraint fk_detalle_compra_producto foreign key (id_producto) references contabilidad."producto" ("id")
        ) WITHOUT OIDS;
        COMMENT ON TABLE contabilidad."detalle_compra" IS 'La tabla contiene el detalle de la información de las compras generadas';
        COMMENT ON COLUMN contabilidad."detalle_compra"."id" IS 'Identificador del detalle de la compra';
        COMMENT ON COLUMN contabilidad."detalle_compra"."id_compra" IS 'Id de la compra';
        COMMENT ON COLUMN contabilidad."detalle_compra"."id_producto" IS 'Id del producto';
        COMMENT ON COLUMN contabilidad."detalle_compra"."cantidad" IS 'Número de unidades';
        COMMENT ON COLUMN contabilidad."detalle_compra"."valor_unitario" IS 'Valor unitario del producto';
        COMMENT ON COLUMN contabilidad."detalle_compra"."valor_total" IS 'Valor total';
        COMMENT ON COLUMN contabilidad."detalle_compra"."estado" IS 'Estado lógico del detalle de compra';
        COMMENT ON COLUMN contabilidad."detalle_compra"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN contabilidad."detalle_compra"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN contabilidad."detalle_compra"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN contabilidad."detalle_compra"."fecha_modifica" IS 'Fecha de modificación del reg';

        -- =====================================
        -- Inventario
        -- =====================================

        drop table if exists contabilidad."inventario" cascade;
        create table contabilidad."inventario"
        (
            "id"               serial,
            "id_producto"      integer        not null,
            "precio_compra"    numeric(18, 2) not null default 0.0,
            "precio_venta"     numeric(18, 2) not null default 0.0,
            "stock"            int            not null default 0,
            "estado"           boolean        not null,
            "usuario_crea"     varchar(50)    not null,
            "usuario_modifica" varchar(50)    not null,
            "fecha_crea"       timestamptz    not null,
            "fecha_modifica"   timestamptz    not null,
            constraint pk_inventario primary key (id),
            constraint fk_inventario_producto foreign key (id_producto) references contabilidad."producto" ("id")
        ) WITHOUT OIDS;
        COMMENT ON TABLE contabilidad."inventario" IS 'La tabla contiene la información de las compras generadas';
        COMMENT ON COLUMN contabilidad."inventario"."id" IS 'Identificador de la compra';
        COMMENT ON COLUMN contabilidad."inventario"."id_producto" IS 'Id del producto';
        COMMENT ON COLUMN contabilidad."inventario"."precio_compra" IS 'Precio de compra del producto';
        COMMENT ON COLUMN contabilidad."inventario"."precio_venta" IS 'Precio de venta del producto';
        COMMENT ON COLUMN contabilidad."inventario"."stock" IS 'Número de stock del producto';
        COMMENT ON COLUMN contabilidad."inventario"."estado" IS 'Estado lógico del inventario';
        COMMENT ON COLUMN contabilidad."inventario"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN contabilidad."inventario"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN contabilidad."inventario"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN contabilidad."inventario"."fecha_modifica" IS 'Fecha de modificación del reg';

        -- =====================================
        -- Inventario
        -- =====================================

        drop table if exists contabilidad."venta" cascade;
        create table contabilidad."venta"
        (
            "id"               serial,
            "numero_factura"   character varying(100) not null,
            "fecha_venta"      date                   not null,
            "id_cliente"       int8                   not null,
            "subtotal"         numeric(18, 2)         not null default 0.0,
            "iva"              numeric(18, 2)         not null default 0.0,
            "total"            numeric(18, 2)         not null default 0.0,
            "estado"           boolean                not null,
            "usuario_crea"     varchar(50)            not null,
            "usuario_modifica" varchar(50)            not null,
            "fecha_crea"       timestamptz            not null,
            "fecha_modifica"   timestamptz            not null,
            constraint pk_venta primary key ("id"),
            constraint fk_venta_cliente foreign key ("id_cliente") references seguridad."usuario" ("id")
        ) WITHOUT OIDS;
        COMMENT ON TABLE contabilidad."venta" IS 'La tabla contiene la información de las ventas realizadas';
        COMMENT ON COLUMN contabilidad."venta"."id" IS 'Identificador de la venta';
        COMMENT ON COLUMN contabilidad."venta"."numero_factura" IS 'Número de factura';
        COMMENT ON COLUMN contabilidad."venta"."fecha_venta" IS 'Fecha de la venta';
        COMMENT ON COLUMN contabilidad."venta"."id_cliente" IS 'Id del cliente';
        COMMENT ON COLUMN contabilidad."venta"."subtotal" IS 'Valor del subtotal';
        COMMENT ON COLUMN contabilidad."venta"."iva" IS 'Valor del iva';
        COMMENT ON COLUMN contabilidad."venta"."total" IS 'Valor total de la venta';
        COMMENT ON COLUMN contabilidad."venta"."estado" IS 'Estado lógico de la venta';
        COMMENT ON COLUMN contabilidad."venta"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN contabilidad."venta"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN contabilidad."venta"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN contabilidad."venta"."fecha_modifica" IS 'Fecha de modificación del reg';

        -- =====================================
        -- Detalle de Venta
        -- =====================================
        drop table if exists contabilidad."detalle_venta" cascade;
        create table contabilidad."detalle_venta"
        (
            "id"               serial,
            "id_venta"         int8           not null,
            "id_producto"      int8           not null,
            "cantidad"         int8           not null default 0,
            "valor_unitario"   numeric(18, 2) not null default 0.0,
            "valor_total"      numeric(18, 2) not null default 0.0,
            "estado"           boolean        not null,
            "usuario_crea"     varchar(50)    not null,
            "usuario_modifica" varchar(50)    not null,
            "fecha_crea"       timestamptz    not null,
            "fecha_modifica"   timestamptz    not null,
            constraint pk_detalle_venta primary key ("id"),
            constraint kk_detalle_venta_venta foreign key ("id_venta") references contabilidad."venta" ("id"),
            constraint fk_detalle_venta_producto foreign key ("id_producto") references contabilidad.producto ("id")
        ) WITHOUT OIDS;
        COMMENT ON TABLE contabilidad."detalle_venta" IS 'La tabla contiene el detalle de las ventas';
        COMMENT ON COLUMN contabilidad."detalle_venta"."id" IS 'Identificador del detalle de la venta';
        COMMENT ON COLUMN contabilidad."detalle_venta"."id_venta" IS 'Id de la venta';
        COMMENT ON COLUMN contabilidad."detalle_venta"."id_producto" IS 'Id del inventario';
        COMMENT ON COLUMN contabilidad."detalle_venta"."cantidad" IS 'Cantidad de productos';
        COMMENT ON COLUMN contabilidad."detalle_venta"."valor_unitario" IS 'Valor unitario del producto';
        COMMENT ON COLUMN contabilidad."detalle_venta"."valor_total" IS 'Valor total por producto';
        COMMENT ON COLUMN contabilidad."detalle_venta"."estado" IS 'Estado lógico de la venta';
        COMMENT ON COLUMN contabilidad."detalle_venta"."usuario_crea" IS 'Usuario que crea el registro.';
        COMMENT ON COLUMN contabilidad."detalle_venta"."usuario_modifica" IS 'Usuario que modifica el registro.';
        COMMENT ON COLUMN contabilidad."detalle_venta"."fecha_crea" IS 'Fecha de creación del registro.';
        COMMENT ON COLUMN contabilidad."detalle_venta"."fecha_modifica" IS 'Fecha de modificación del reg';


    end
$$;


