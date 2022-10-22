package ru.ilb.newproject.web;

import io.swagger.annotations.Api;
import java.sql.Connection;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AndrewSych
 */
@Named
@Api("heartbeat")
@Path("heartbeat")
public class Heartbeat {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @GET
    @Transactional
    // @Transactional required
    // http://wiki.eclipse.org/EclipseLink/Examples/JPA/EMAPI#Getting_a_JDBC_Connection_from_an_EntityManager
    public String heartbeat() {
        
        em.unwrap(Connection.class);
        return "OK";

    }
}
