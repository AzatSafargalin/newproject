package ru.ilb.newproject.mocklogic;

import com.sun.java.xml.ns.javaee.EnvEntryType;
import com.sun.java.xml.ns.javaee.ResourceEnvRefType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import ru.ilb.common.test.Jndi;

/**
 *
 * @author AndrewSych
 */
public class JndiMock extends Jndi {

    public JndiMock() {
        addExcludeName("jdbc/.apps.newproject/.apps.newproject.db");
        try {
            SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
            getParams().forEach((name, value) -> {
                builder.bind(name, value);
            });
            builder.activate();
        } catch (IllegalStateException | NamingException ex) {
            Logger.getLogger(JndiMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getEnvEntryValue(EnvEntryType envEntryType) {
        switch (envEntryType.getEnvEntryName().getValue()) {
            default:
                return super.getEnvEntryValue(envEntryType);
        }
    }

    @Override
    public Object getResourceEnvRefValue(ResourceEnvRefType resourceEnvRefType) {
        switch (resourceEnvRefType.getResourceEnvRefName().getValue()) {
            default:
                return super.getResourceEnvRefValue(resourceEnvRefType);
        }
    }
}
