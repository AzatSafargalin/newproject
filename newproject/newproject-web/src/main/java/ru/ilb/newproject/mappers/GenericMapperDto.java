package ru.ilb.newproject.mappers;

import java.util.List;
import org.mapstruct.MappingTarget;

/**
 *
 * @author AndrewSych
 */
public interface GenericMapperDto<E, D> {

    E createFromDto(D dto);

    void updateEntity(@MappingTarget E entity, D dto);

    List<E> createFromDtos(List<D> dtos);

}