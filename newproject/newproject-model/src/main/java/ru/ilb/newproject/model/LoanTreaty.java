package ru.ilb.newproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.*;

/**
 * @author AndrewSych
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class LoanTreaty implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_LOANTREATY_ID_GEN", strategy = GenerationType.TABLE)
    @TableGenerator(name = "SEQ_LOANTREATY_ID_GEN", table = "SEQUENCE", pkColumnValue = "SEQ_LOANTREATY_ID_GEN", valueColumnName = "SEQ_VALUE", pkColumnName = "SEQ_NAME")
    private Long id;
    @OneToOne
    private BusinessEntity businessEntity;
    @OneToMany(mappedBy = "loanTreaty")
    @XmlTransient
    private List<Requirement> requirements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoanTreaty withId(Long id) {
        this.id = id;
        return this;
    }

    public BusinessEntity getBusinessEntity() {
        return businessEntity;
    }

    public void setBusinessEntity(BusinessEntity businessEntity) {
        this.businessEntity = businessEntity;
    }

    public LoanTreaty withBusinessEntity(BusinessEntity businessEntity) {
        this.businessEntity = businessEntity;
        return this;
    }

    public List<Requirement> getRequirements() {
        if (requirements == null) {
            requirements = new ArrayList<>();
        }
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public LoanTreaty withRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
        return this;
    }

    public void addRequirement(Requirement requirement) {
        getRequirements().add(requirement);
        requirement.setLoanTreaty(this);
    }

    public void removeRequirement(Requirement requirement) {
        getRequirements().remove(requirement);
        requirement.setLoanTreaty(null);
    }

}