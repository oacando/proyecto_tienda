/*******************************************************/
/*DATABASE: HulkStore*/
/*******************************************************/
SELECT pg_terminate_backend(pg_stat_activity.pid)
 FROM pg_stat_activity
 WHERE datname = 'hulk_store'
  AND pid <> pg_backend_pid();

DROP DATABASE IF EXISTS hulk_store;
CREATE DATABASE hulk_store
    WITH
    OWNER = "postgres"
    ENCODING = 'UTF8'
    TABLESPACE = "pg_default";
COMMENT ON DATABASE hulk_store IS 'Base de datos enfocada administrar la informacion hulkstore.';
