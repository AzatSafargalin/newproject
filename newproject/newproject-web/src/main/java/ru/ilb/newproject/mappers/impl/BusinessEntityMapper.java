/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ilb.newproject.mappers.impl;

import org.mapstruct.Mapper;
import ru.ilb.newproject.mappers.GenericMapperEntity;
import ru.ilb.newproject.model.BusinessEntity;
import ru.ilb.newproject.model.CompanyType;
import ru.ilb.newproject.model.PrivatePerson;
import ru.ilb.newproject.model.SelfEmployed;

/**
 *
 * @author AndrewSych
 */
@Mapper(componentModel = "spring")
public abstract class BusinessEntityMapper implements GenericMapperEntity<BusinessEntity, ru.ilb.newproject.view.BusinessEntity> {
    
    public abstract ru.ilb.newproject.view.PrivatePerson createFromEntity(PrivatePerson businessEntity);

    public abstract ru.ilb.newproject.view.CompanyType createFromEntity(CompanyType businessEntity);

    public abstract ru.ilb.newproject.view.SelfEmployed createFromEntity(SelfEmployed businessEntity);
    
    @Override
    public ru.ilb.newproject.view.BusinessEntity createFromEntity(BusinessEntity businessEntity) {
        ru.ilb.newproject.view.BusinessEntity businessEntityView;
        if (businessEntity instanceof PrivatePerson) {
            businessEntityView = createFromEntity((PrivatePerson) businessEntity);
        } else if (businessEntity instanceof CompanyType) {
            businessEntityView = createFromEntity((CompanyType) businessEntity);
        } else if (businessEntity instanceof SelfEmployed) {
            businessEntityView = createFromEntity((SelfEmployed) businessEntity);
        } else {
            businessEntityView = null;
//            throw new IllegalArgumentException("not implemented");
        }
        return businessEntityView;
    }

}
