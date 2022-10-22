package ru.ilb.newproject.configuration;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import ru.ilb.newproject.mocklogic.ContextResolverMock;
import ru.ilb.common.jpa.converters.UUIDConverterBytes;
import ru.ilb.common.jpa.repository.CacheableJpaRepositoryImpl;

/**
 *
 * @author AndrewSych
 */
@Configuration
@ComponentScan(basePackages = {
    "ru.ilb.newproject.mocklogic",
    "ru.ilb.newproject.usecase",
    "ru.ilb.newproject.usecase.impl",
    "ru.ilb.newproject.service",
    "ru.ilb.newproject.service.impl",
    "ru.ilb.newproject.utils",
    "ru.ilb.newproject.gateway",
    "ru.ilb.newproject.gateway.utils",
    "ru.ilb.newproject.gateway.utils.custom",
    "ru.ilb.newproject.provider",
    "ru.ilb.newproject.converters",})
@EntityScan(value = {"ru.ilb.newproject.model"}, basePackageClasses = {UUIDConverterBytes.class})
@EnableJpaRepositories(basePackages = "ru.ilb.newproject.repositories", repositoryBaseClass = CacheableJpaRepositoryImpl.class)
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class TestConfiguration extends JpaBaseConfiguration {

    @Autowired
    private Environment env;

    /**
     * @param dataSource
     * @param properties
     * @param jtaTransactionManager
     */
    protected TestConfiguration(
            DataSource dataSource,
            JpaProperties properties,
            ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
//        setupSsl();
    }

    private void setupSsl() {
        String home = System.getProperty("user.home");
        System.setProperty("javax.net.ssl.trustStore", home + "/.java/deployment/security/trusted.cacerts");
        System.setProperty("javax.net.ssl.keyStore", home + "/.java/deployment/security/trusted.clientcerts");
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
    }

    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = super.entityManagerFactory(factoryBuilder);
        entityManagerFactory.setPersistenceUnitName("newproject");
        return entityManagerFactory;
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put(PersistenceUnitProperties.WEAVING, "static");
        map.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.NONE);
        map.put(PersistenceUnitProperties.BATCH_WRITING, "JDBC");
        map.put(PersistenceUnitProperties.BATCH_WRITING_SIZE, "1000");
        return map;
    }

    @Bean
    public ContextResolver<JAXBContext> jaxbContextResolver() {
        return new ContextResolverMock();
    }

    @Bean
    public ru.ilb.newproject.gateway.utils.custom.TestResource testProxy() {
        return JAXRSClientFactory.create("https://www.google.com/", ru.ilb.newproject.gateway.utils.custom.TestResource.class);
    }

}
