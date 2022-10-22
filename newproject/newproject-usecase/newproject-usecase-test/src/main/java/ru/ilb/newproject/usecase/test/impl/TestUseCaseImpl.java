package ru.ilb.newproject.usecase.test.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ilb.newproject.gateway.TestGateway;
import ru.ilb.newproject.usecase.test.TestUseCase;

/**
 *
 * @author AndrewSych
 */
@Named
public class TestUseCaseImpl implements TestUseCase {

    private TestGateway testGateway;

    @Inject
    public void setTestGateway(TestGateway testGateway) {
        this.testGateway = testGateway;
    }

    @Override
    public String testAsync(int delay) {
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestUseCaseImpl.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }
        return "OK";
    }

    @Override
    public String testGateway() {
        testGateway.getTestResponse();
        return "OK";
    }

}
