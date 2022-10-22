package ru.ilb.newproject.provider;

import java.io.IOException;
import javax.inject.Named;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import org.slf4j.LoggerFactory;

/**
 *
 * @author AndrewSych
 */
@Named
@Provider
public class AuthorizationHandler implements ContainerRequestFilter {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AuthorizationHandler.class);

    private final ThreadLocal authorizationData = new ThreadLocal();

    private final String xRemoteUsersGroup = "ru.ilb.newproject.apps.newproject.xremoteusers";

    public AuthorizationData getAuthorizationData() {
        AuthorizationData authData = (AuthorizationData) this.authorizationData.get();
        if (authData == null) {
            authData = new AuthorizationData();
            this.authorizationData.set(authData);
        }
        return authData;
    }

    public void setAuthorizationData(AuthorizationData authData) {
        this.authorizationData.set(authData);
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        SecurityContext securityContext = requestContext.getSecurityContext();

        String userName = securityContext.getUserPrincipal().getName();
        String xRemoteUserName = requestContext.getHeaderString("X-Remote-User");

        if (xRemoteUserName != null
                && securityContext.isUserInRole(xRemoteUsersGroup)) {
            userName = xRemoteUserName;
        }

        AuthorizationData authData = getAuthorizationData()
                .withCurrentAuditor(userName)
                .withHeaders(requestContext.getHeaders());
        requestContext.getHeaders();
        setAuthorizationData(authData);
    }

}
