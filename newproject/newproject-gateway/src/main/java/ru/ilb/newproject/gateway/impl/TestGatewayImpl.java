package ru.ilb.newproject.gateway.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import ru.ilb.newproject.gateway.utils.ResourceUtils;
import ru.ilb.newproject.utils.ExceptionUtils;
import ru.ilb.newproject.gateway.TestGateway;

/**
 *
 * @author AndrewSych
 */
@Named
public class TestGatewayImpl implements TestGateway {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TestGatewayImpl.class);

    private ResourceUtils resourceUtils;

    @Inject
    public void setResourceUtils(ResourceUtils resourceUtils) {
        this.resourceUtils = resourceUtils;
    }

    @Override
    public Response getTestResponse() {
        Response response = null;
        try {
            response = resourceUtils.googleResource.ping();
        } catch (Exception ex) {
            Logger.getLogger(TestGatewayImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            logger.error("Ошибка вызова GoogleGatewayImpl.getGoogle(): errorText={}",
                    ExceptionUtils.getMessage(ex));
            throw new WebApplicationException("Ошибка getGoogle()", 550);
        }
        if (response.getStatus() != 200) {
            String message = response.getEntity() != null ? response.readEntity(String.class) : null;
            logger.error("Ошибка вызова getGoogle(): status={}, message={}", response.getStatus(), message);
            throw new WebApplicationException("Ошибка вызова getGoogle()", 550);
        }
        return response;
    }

}
