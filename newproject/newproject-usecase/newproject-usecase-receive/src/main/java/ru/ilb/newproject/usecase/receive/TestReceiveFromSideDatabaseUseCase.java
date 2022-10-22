package ru.ilb.newproject.usecase.receive;

import ru.ilb.newproject.model.dto.test.ReceiveFromSideDatabaseDto;

/**
 *
 * @author AndrewSych
 */
public interface TestReceiveFromSideDatabaseUseCase {

    ReceiveFromSideDatabaseDto receiveFromSideDatabase(Long id);
}
