package ru.ilb.newproject.mappers;

import java.util.List;

/**
 *
 * @author AndrewSych
 */
public interface GenericMapperEntity<E, D> {

    D createFromEntity(E entity);

    List<D> createFromEntities(List<E> entities);

}
