package ru.ilb.newproject.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilb.newproject.model.BusinessEntity;

/**
 *
 * @author AndrewSych
 */
public interface BusinessEntityRepository extends JpaRepository<BusinessEntity, Long> {

    BusinessEntity findByUid(UUID uid);
}
