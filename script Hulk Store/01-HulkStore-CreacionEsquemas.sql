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

- Módulo        : Todo RioSoft
- Autor         : oljer.cando
- Fecha         : 7-03-2022 18:48
- Version       : 1.0
- Comentario    : Creación de esquemas para la base de datos hulk_store

[TESTER]

[ ] Aplicar pruebas de estres.
[ ] Validar objetos creados y modificado.
[ ] Población de datos.
[ ] Otros.
    - DBA - Tester :        
    - Fecha        :
    - Comentario   :
------------------------------------------------------------------------------------------*/


/*
Nota: El script se debe ejecutar en la base de datos hulk_store
*/

/*******************************************************/
/*SCHEMA: contabilidad*/
/*******************************************************/
DO
$$
    begin
        if not exists(SELECT schema_name FROM information_schema.schemata WHERE schema_name = 'contabilidad') then
            CREATE SCHEMA contabilidad AUTHORIZATION postgres;

            COMMENT ON SCHEMA contabilidad IS 'Esquema para tablas del módulo contabilidad';
        end if;
    end ;
$$;


/*******************************************************/
/*SCHEMA: seguridad*/
/*******************************************************/
DO
$$
    begin
        if not exists(SELECT schema_name FROM information_schema.schemata WHERE schema_name = 'seguridad') then
            CREATE SCHEMA seguridad AUTHORIZATION postgres;

            COMMENT ON SCHEMA seguridad IS 'Esquema para tablas del módulo de los usuarios';
        end if;
    end ;
$$;
