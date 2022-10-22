package ru.ilb.newproject.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import ru.ilb.newproject.core.RequirementTypeCode;
import ru.ilb.newproject.model.RequirementType;
import ru.ilb.newproject.repositories.RequirementTypeRepository;
import ru.ilb.newproject.service.RequirementTypeService;

@Named
public class RequirementTypeServiceImpl implements RequirementTypeService {

    private RequirementTypeRepository requirementTypeRepository;

    @Inject
    public void setRequirementTypeRepository(RequirementTypeRepository requirementTypeRepository) {
        this.requirementTypeRepository = requirementTypeRepository;
    }

    @Override
    public RequirementType findByCode(final RequirementTypeCode code) {
        return requirementTypeRepository.findByCode(code);
    }

}
