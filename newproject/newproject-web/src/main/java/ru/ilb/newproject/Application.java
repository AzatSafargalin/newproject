package ru.ilb.newproject;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.apache.cxf.Bus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import ru.ilb.common.jaxrs.async.AsyncTaskManager;
import ru.ilb.common.jpa.converters.UUIDConverterBytes;
import ru.ilb.common.jpa.repository.CacheableJpaRepositoryImpl;
import ru.ilb.common.jpa.tools.RepositoryPopulator;

/**
 *
 * @author AndrewSych
 */
@ComponentScan
@SpringBootApplication
@ImportResource("classpath:beans.xml")
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableJpaRepositories(basePackages = "ru.ilb.newproject.repositories", repositoryBaseClass = CacheableJpaRepositoryImpl.class)
@EntityScan(value = {"ru.ilb.newproject.model"}, basePackageClasses = {UUIDConverterBytes.class})
public class Application extends JpaBaseConfiguration {

    @Autowired
    private Bus bus;

    public Application(
            DataSource dataSource,
            JpaProperties properties,
            ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Bean
    public RepositoryPopulator repositoryPopulator() {
        return new RepositoryPopulator();
    }

    @Bean
    public ru.ilb.common.jpa.tools.DescriptorUtils descriptorUtils(EntityManager entityManager) {
        ru.ilb.common.jpa.tools.DescriptorUtils descriptorUtils = new ru.ilb.common.jpa.tools.DescriptorUtils();
        descriptorUtils.setEntityManager(entityManager);
        return descriptorUtils;
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put(PersistenceUnitProperties.WEAVING, "static");
        map.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
        map.put(PersistenceUnitProperties.BATCH_WRITING, "JDBC");
        map.put(PersistenceUnitProperties.BATCH_WRITING_SIZE, "1000");
        map.put(PersistenceUnitProperties.LOGGING_LEVEL, "FINE");
        return map;
    }
    
    @Bean(destroyMethod = "destroy")
    public AsyncTaskManager asyncTaskManager() {
        return new AsyncTaskManager();
    }

    @Bean
    public LoggingInInterceptor logInbound() {
        return new LoggingInInterceptor();
    }

    @Bean
    public LoggingOutInterceptor logOutbound() {
        return new LoggingOutInterceptor();
    }

    @Bean
    public LoggingFeature loggingFeature() {
        LoggingFeature lf = new LoggingFeature();
        lf.setLogBinary(false);
        lf.setPrettyLogging(true);
        lf.addBinaryContentMediaTypes("application/octet-stream");
        lf.addBinaryContentMediaTypes("text/css");
        lf.addBinaryContentMediaTypes("application/javascript");
        lf.addBinaryContentMediaTypes("application/vnd.oasis.opendocument.text");
        lf.setLogMultipart(false);
        return lf;
    }
}
