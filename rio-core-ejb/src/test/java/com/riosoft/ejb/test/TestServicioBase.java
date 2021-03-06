package com.riosoft.ejb.test;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

import com.riosoft.contabilidad.dao.impl.InventarioDaoImpl;
import com.riosoft.contabilidad.dao.impl.TipoDisenioDaoImpl;
import com.riosoft.contabilidad.facade.impl.CompraFacadeImpl;
import com.riosoft.contabilidad.facade.impl.VentaFacadeImpl;
import com.riosoft.seguridad.dao.impl.UsuarioDaoImpl;

public class TestServicioBase {

    static EntityManager em;
    static TipoDisenioDaoImpl tipoDisenioDaoImpl = new TipoDisenioDaoImpl();
    static InventarioDaoImpl inventarioDaoImpl = new InventarioDaoImpl();
    static UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
    static CompraFacadeImpl comprafacade = new CompraFacadeImpl();
    static VentaFacadeImpl ventaFacadeImpl = new VentaFacadeImpl();

    @After
    public void pseudoBlueprintContainerClose() {
        if (em != null) {
            em.close();
        } else {
            System.out.println("No existe enterprise manager");
        }
    }

    @Before
    public void setup() {
        final Properties props = new Properties();
        props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hulk_store");
        props.put("hibernate.connection.username", "postgres");
        props.put("hibernate.connection.password", "riosoft123");
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("rio-core-ejb", props);
        em = factory.createEntityManager();
        // tipoDisenioDaoImpl.setEm(em);
        // inventarioDaoImpl.setEm(em);
         usuarioDaoImpl.setEm(em);
    }

}
