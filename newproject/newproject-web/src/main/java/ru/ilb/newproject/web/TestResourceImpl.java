package ru.ilb.newproject.web;

import io.swagger.annotations.Api;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import ru.ilb.common.jaxrs.async.AsyncTaskManager;
import ru.ilb.newproject.api.TestResource;
import ru.ilb.newproject.usecase.test.TestUseCase;
import ru.ilb.newproject.usecase.receive.TestReceiveFromSideDatabaseUseCase;

/**
 *
 * @author AndrewSych
 */
@Named
@Api("test")
@Path("test")
public class TestResourceImpl implements TestResource {

    @Inject
    private AsyncTaskManager asyncTaskManager;

    private UriInfo uriInfo;

    @Context
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    private TestReceiveFromSideDatabaseUseCase testReceiveFromSideDatabase;
    
    private TestUseCase testUseCase;

    @Inject
    public void setTestUseCase(TestUseCase testUseCase) {
        this.testUseCase = testUseCase;
    }
    @Inject
    public void setTestReceiveFromSideDatabase(TestReceiveFromSideDatabaseUseCase testReceiveFromSideDatabase){
        this.testReceiveFromSideDatabase = testReceiveFromSideDatabase;
    }

    @Override
    public Response ping() {
        testReceiveFromSideDatabase.receiveFromSideDatabase(1L);
        return Response
                .ok("OK")
                .header("Content-Type", "text/plain")
                .build();
    }

    @Override
    public Response async() {
        Random random = new Random();
        int delay = random.nextInt(60 - 30) + 30;
        return asyncTaskManager.execute(() -> {
            return Response
                    .ok()
                    .entity(testUseCase.testAsync(delay))
                    .header("Content-Type", "text/plain")
                    .build();
        }, uriInfo);
    }

}
