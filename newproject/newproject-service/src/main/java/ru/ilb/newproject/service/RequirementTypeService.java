package ru.ilb.newproject.service;

import ru.ilb.newproject.core.RequirementTypeCode;
import ru.ilb.newproject.model.RequirementType;

/**
 *
 * @author AndrewSych
 */
public interface RequirementTypeService {

    RequirementType findByCode(RequirementTypeCode code);
}
