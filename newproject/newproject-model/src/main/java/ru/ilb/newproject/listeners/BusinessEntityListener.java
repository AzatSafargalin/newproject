package ru.ilb.newproject.listeners;

import java.util.UUID;
import javax.persistence.PrePersist;
import ru.ilb.newproject.model.BusinessEntity;

/**
 *
 * @author AndrewSych
 */
public class BusinessEntityListener {

    @PrePersist
    public void onPrePersist(BusinessEntity businessEntity) {
        if (businessEntity.getUid() == null) {
            businessEntity.setUid(UUID.randomUUID());
        }
    }
}
