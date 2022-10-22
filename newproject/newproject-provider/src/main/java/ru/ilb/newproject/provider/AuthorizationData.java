package ru.ilb.newproject.provider;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author AndrewSych
 */
public class AuthorizationData {
    /**
     * ldap логин пользователя
     */
    private String currentAuditor;

    /**
     * Заголовки
     */
    private MultivaluedMap<String, String> headers;

    /**
     * Логин пользователя
     *
     * @return String
     */
    public String getCurrentAuditor() {
        return currentAuditor;
    }

    public MultivaluedMap<String, String> getHeaders(){
        if (headers == null)
            headers = new MultivaluedHashMap<>();
        return headers;
    }

    /**
     * Set логин пользователя
     *
     * @param currentAuditor
     * @return AuthorizationData
     */
    public AuthorizationData withCurrentAuditor(String currentAuditor) {
        this.currentAuditor = currentAuditor;

        return this;
    }

    /**
     * Set логин пользователя
     *
     * @param currentAuditor
     */
    public void setCurrentAuditor(String currentAuditor) {
        this.currentAuditor = currentAuditor;
    }

    public AuthorizationData withHeaders(MultivaluedMap<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public void setHeaders(MultivaluedMap<String, String> headers) {
        this.headers = headers;
    }

}
