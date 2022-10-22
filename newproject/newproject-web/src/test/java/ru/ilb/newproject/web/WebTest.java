package ru.ilb.newproject.web;

import javax.inject.Inject;
import org.apache.cxf.jaxrs.client.Client;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ilb.newproject.configuration.TestConfiguration;
import ru.ilb.newproject.usecase.test.TestUseCase;
import ru.ilb.newproject.utils.InjectTest;

/**
 *
 * @author AndrewSych
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = TestConfiguration.class)
public class WebTest {

    private final String LOGIN = "admin";
    
    private final String PASSWORD = "548548";

    private void configureClient(Client client) {
        String authorizationHeader = "Basic " + org.apache.cxf.common.util.Base64Utility.encode((LOGIN + ":" + PASSWORD).getBytes());
        client.header("Authorization", authorizationHeader);
//        client.header("User-Agent", "autotest dev-mozilla-auto-config host:" + OPERATOR_HOST + " user:" + OPERATOR_LOGIN);
//        client.header("X-Remote-Point", CASHIER_POINT_ID);
    }

    /**
     * �?спользуется для ресурсов с обязательной авторизацией
     */
//    @Before
//    public void setUp() {
//        configureClient(WebClient.client(testResource));
//    }
//    private ru.ilb.newproject.api.TestResource testResource;
//
//    @Inject
//    public void setTestResource(TestResource testResource) {
//        this.testResource = testResource;
//    }
//
    private InjectTest injectTest;

    @Inject
    public void setInjectTest(InjectTest injectTest) {
        this.injectTest = injectTest;
    }

    private TestUseCase testUseCase;

    @Inject
    public void setTestUseCase(TestUseCase testUseCase) {
        this.testUseCase = testUseCase;
    }

    @Test
    public void testPingGoogle() {
        String resp = testUseCase.testGateway();
        assertEquals("OK", resp);
    }

    @Test
    public void testMe() {
        int test = injectTest.testMePlease(1);
        assertEquals(test, 2);
    }

}
