package ru.ilb.newproject.gateway.utils.custom;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author AndrewSych
 */
@Path("/")
public interface TestResource {

    @GET
    @Valid
    @Produces("text/plain")
    Response ping();
}
