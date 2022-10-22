package ru.ilb.newproject.usecase.businessentity;

import java.util.UUID;
import ru.ilb.newproject.model.BusinessEntity;

/**
 *
 * @author AndrewSych
 */
public interface BusinessEntityUseCase {

    BusinessEntity getBusinessEntity(UUID uid);

    BusinessEntity generateBusinessEntity();
}
