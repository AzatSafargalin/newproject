package ru.ilb.newproject.usecase.businessentity.impl;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import ru.ilb.newproject.model.BusinessEntity;
import ru.ilb.newproject.model.PrivatePerson;
import ru.ilb.newproject.service.BusinessEntityService;
import ru.ilb.newproject.usecase.businessentity.BusinessEntityUseCase;

@Named
public class BusinessEntityUseCaseImpl implements BusinessEntityUseCase {

    private BusinessEntityService businessEntityService;

    @Inject
    public void setBusinessEntityService(BusinessEntityService businessEntityService) {
        this.businessEntityService = businessEntityService;
    }

    @Override
    public BusinessEntity getBusinessEntity(final UUID uid) {
        if (uid == null) {
            throw new WebApplicationException("UUID не может быть null", 450);
        }
        BusinessEntity be = businessEntityService.findByUid(uid);
        if (be == null) {
            throw new WebApplicationException("Не найден be с uid=" + uid, 450);
        }
        return be;
    }

    @Override
    public BusinessEntity generateBusinessEntity() {
        BusinessEntity be = new PrivatePerson();
        return businessEntityService.save(be);
    }

}
