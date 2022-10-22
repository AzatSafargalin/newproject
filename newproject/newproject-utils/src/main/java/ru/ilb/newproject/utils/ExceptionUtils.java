package ru.ilb.newproject.utils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.slf4j.LoggerFactory;

/**
 *
 * @author AndrewSych
 */
public class ExceptionUtils {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ExceptionUtils.class);

    /**
     * Вывод текста ошибки в корректном виде
     *
     * @param ex
     * @return String
     */
    public static String getMessage(Exception ex) {

        if (ex instanceof WebApplicationException) {
            if (((WebApplicationException) ex).getResponse().getEntity() != null) {
                return ((WebApplicationException) ex).getResponse().readEntity(String.class);
            }
        }
        return ex.getMessage();
    }

    /**
     * Вывод кода ошибки
     *
     * @param ex
     * @return int
     */
    public static int getStatus(Exception ex) {
        if (ex instanceof WebApplicationException) {
            Response response = ((WebApplicationException) ex).getResponse();
            return (response != null ? response.getStatus() : null);
        }

        return 550;
    }
}
