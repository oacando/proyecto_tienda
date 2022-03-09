/*-----------------------------------------------------------------------------------------
|                                   Todo 1                                                  |
|                                Quito - Ecuador                                            |
|                                                                                           |
|                               ©Copyright 2022                                             |
|                             Derechos Reservados                                           |
|
|-------------------------------------------------------------------------------------------|

-----------------------------------------------------------------------------------------/
[DEV]

- Módulo        : contabilidad
- Autor         : oljer.cando
- Fecha         : 08-03-2022 16:15
- Version       : 1.0
- Comentario    : Población de las tablas tipo catalogos contabilidad

[TESTER]

[ ] Aplicar pruebas de estres.
[ ] Validar objetos creados y modificado.
[ ] Población de datos.
[ ] Otros.
    - DBA - Tester :
    - Fecha         :
    - Comentario  :
------------------------------------------------------------------------------------------*/


do
$$
    declare
        usuario varchar(50) = 'oljer.cando';
        fecha   timestamp   := (select current_timestamp);
    begin
        with tipos(grupo, nemonico, nombre)
                 as (
                select 'MARVEL', 'AVENGERS', 'AVENGERS'
                union
                select 'MARVEL', 'SPIDER_MAN', 'SPIDER MAN'
                union
                select 'MARVEL', 'CAPTAIN_AMERICA', 'CAPTAIN AMERICA'
                union
                select 'DC_COMICS', 'FLASH', 'FLASH'
                union
                select 'DC_COMICS', 'CATWOMAN', 'CATWOMAN'
            )
        insert
        into contabilidad.tipo_disenio(nemonico_grupo, nemonico, nombre, estado, usuario_crea, usuario_modifica,
                                       fecha_crea, fecha_modifica)
        select a.grupo,
               a.nemonico,
               a.nombre,
               true,
               usuario,
               usuario,
               fecha,
               fecha

        from tipos a
                 left join contabilidad.tipo_disenio td on (a.nemonico = td.nemonico)
        where td.id is null;
    end
$$;

---------------Poblacion de productos----------------------
do
$$
    declare
        usuario varchar(50) = 'oljer.cando';
        fecha   timestamp   := (select current_timestamp);
    begin
        with tipos(nombre, tipo_disenio)
                 as (
                select 'CAMISETA', (select id from contabilidad.tipo_disenio where nemonico ='AVENGERS')
                union
                select 'VASO', (select id from contabilidad.tipo_disenio where nemonico ='SPIDER_MAN')
                union
                select 'LLAVERO', (select id from contabilidad.tipo_disenio where nemonico ='CAPTAIN_AMERICA')
            )
        insert
        into contabilidad.producto(nombre, id_tipo_disenio, estado, usuario_crea, usuario_modifica, fecha_crea,
                                   fecha_modifica)
        select a.nombre,
               a.tipo_disenio,
               true,
               usuario,
               usuario,
               fecha,
               fecha

        from tipos a
                 left join contabilidad.producto p on (a.nombre = p.nombre and a.tipo_disenio=p.id_tipo_disenio )
        where p.id is null;
    end
$$;
