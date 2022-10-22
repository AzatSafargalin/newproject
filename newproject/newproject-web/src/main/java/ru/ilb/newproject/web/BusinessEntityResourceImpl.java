package ru.ilb.newproject.web;

import io.swagger.annotations.Api;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import ru.ilb.newproject.api.BusinessEntityResource;
import ru.ilb.newproject.mappers.impl.BusinessEntityMapper;
import ru.ilb.newproject.usecase.businessentity.BusinessEntityUseCase;

/**
 *
 * @author AndrewSych
 */
@Named
@Api("businessEntity")
@Path("businessEntity")
public class BusinessEntityResourceImpl implements BusinessEntityResource {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BusinessEntityResourceImpl.class);
    private BusinessEntityUseCase businessEntityUseCase;

    @Inject
    public void setBusinessEntityUseCase(BusinessEntityUseCase businessEntityUseCase) {
        this.businessEntityUseCase = businessEntityUseCase;
    }
    
    private BusinessEntityMapper businessEntityMapper;

    @Inject
    public void setBusinessEntityMapper(BusinessEntityMapper businessEntityMapper) {
        this.businessEntityMapper = businessEntityMapper;
    }

    @Override
    public ru.ilb.newproject.view.BusinessEntity getBusinessEntity(final UUID uid) {
        return businessEntityMapper.createFromEntity(businessEntityUseCase.getBusinessEntity(uid));
    }

    @Override
    public ru.ilb.newproject.view.BusinessEntity generateBusinessEntity() {

        return businessEntityMapper.createFromEntity(businessEntityUseCase.generateBusinessEntity());
    }

}
