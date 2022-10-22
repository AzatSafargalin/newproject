package ru.ilb.newproject.task;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ilb.newproject.usecase.test.TestUseCase;

/**
 *
 * @author AndrewSych
 */
@Named
public class TestServiceTask {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TestServiceTask.class);

    @Resource(mappedName = "apps.newproject.tasks.testtaskenabled")
    private Boolean newprojectTaskEnabled;

    private TestUseCase testUseCase;

    @Inject
    public void setTestUseCase(TestUseCase testUseCase) {
        this.testUseCase = testUseCase;
    }

    public void execute() {
        if (!Boolean.TRUE.equals(newprojectTaskEnabled)) {
            logger.info("Планировщик " + this.getClass().getName() + " выключен.");
            return;
        }
        logger.info("Проверка сервиса.");
        String response = testUseCase.testGateway();
        if (response != "OK") {
            logger.error("Ошибка вызова сервиса.");
            return;
        }
        logger.info("Сервис работает нормально.");
    }
}
