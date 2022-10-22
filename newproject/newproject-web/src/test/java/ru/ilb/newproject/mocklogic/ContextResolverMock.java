package ru.ilb.newproject.mocklogic;

import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author AndrewSych
 */
public class ContextResolverMock implements ContextResolver<JAXBContext> {

    @Override
    public JAXBContext getContext(Class<?> type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
