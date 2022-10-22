package ru.ilb.newproject.service.impl;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ilb.newproject.model.BusinessEntity;
import ru.ilb.newproject.repositories.BusinessEntityRepository;
import ru.ilb.newproject.service.BusinessEntityService;

/**
 *
 * @author AndrewSych
 */
@Named
public class BusinessEntityServiceImpl implements BusinessEntityService {

    private BusinessEntityRepository businessEntityRepository;

    @Inject
    public void setBusinessEntityRepository(BusinessEntityRepository businessEntityRepository) {
        this.businessEntityRepository = businessEntityRepository;
    }

    @Override
    public BusinessEntity findByUid(final UUID uid) {
        return businessEntityRepository.findByUid(uid);
    }

    @Override
    public BusinessEntity save(final BusinessEntity businessEntity) {
        return businessEntityRepository.save(businessEntity);
    }

}
