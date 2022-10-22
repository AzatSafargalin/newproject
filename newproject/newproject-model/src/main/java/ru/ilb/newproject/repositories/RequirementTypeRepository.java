package ru.ilb.newproject.repositories;

import java.util.Objects;
import ru.ilb.newproject.core.RequirementTypeCode;
import ru.ilb.newproject.model.RequirementType;
import ru.ilb.common.jpa.annotations.AutoPopulableRepository;
import ru.ilb.common.jpa.repository.CacheableJpaRepository;

/**
 *
 * @author AndrewSych
 */
@AutoPopulableRepository
public interface RequirementTypeRepository extends CacheableJpaRepository<RequirementType, Long> {

    public static RequirementType REQUIREMENT_ONE = new RequirementType()
            .withId(1L)
            .withCode(RequirementTypeCode.REQUIREMENT_ONE)
            .withName("Тип требования один");

    public static RequirementType REQUIREMENT_TWO = new RequirementType()
            .withId(2L)
            .withCode(RequirementTypeCode.REQUIREMENT_TWO)
            .withName("Тип требования два");

    public static RequirementType REQUIREMENT_THREE = new RequirementType()
            .withId(3L)
            .withCode(RequirementTypeCode.REQUIREMENT_THREE)
            .withName("Тип требования три");

    default public RequirementType findByCode(RequirementTypeCode code) {
        return findAllCache()
                .stream()
                .filter(x -> Objects.equals(x.getCode(), code))
                .findFirst()
                .orElse(null);
    }
}
