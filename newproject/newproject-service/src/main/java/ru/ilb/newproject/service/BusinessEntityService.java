package ru.ilb.newproject.service;

import java.util.UUID;
import ru.ilb.newproject.model.BusinessEntity;

/**
 *
 * @author AndrewSych
 */
public interface BusinessEntityService {

    BusinessEntity findByUid(UUID uid);
    
    BusinessEntity save(BusinessEntity businessEntity);
}
