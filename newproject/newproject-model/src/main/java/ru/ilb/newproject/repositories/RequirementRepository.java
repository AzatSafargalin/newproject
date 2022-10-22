package ru.ilb.newproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilb.newproject.model.Requirement;

/**
 *
 * @author AndrewSych
 */

public interface RequirementRepository extends JpaRepository<Requirement, Long> {

}
