package ru.ilb.newproject.web;

import ch.qos.logback.classic.Level;
import io.swagger.annotations.Api;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.slf4j.LoggerFactory;

/**
 *
 * @author AndrewSych
 */
@Named
@Api("admin")
@Path("admin")
public class AdminResourceImpl {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces("text/plain")
    @Path("/cache/clearCache")
    public Response clearCache() {
        em.getEntityManagerFactory().getCache().evictAll();

        return Response.ok("OK").build();
    }

    @POST
    @Produces("text/plain")
    @Path("/logging")
    public Response setLogging(@QueryParam("logger") String logger, @QueryParam("level") String level) {
        ((ch.qos.logback.classic.Logger) LoggerFactory.getLogger(logger)).setLevel(Level.valueOf(level));
        return Response.ok("OK").build();
    }
}
