package ru.ilb.newproject.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.*;

/**
 * @author AndrewSych
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Requirement implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_REQUIREMENT_ID_GEN", strategy = GenerationType.TABLE)
    @TableGenerator(name = "SEQ_REQUIREMENT_ID_GEN", table = "SEQUENCE", pkColumnValue = "SEQ_REQUIREMENT_ID_GEN", valueColumnName = "SEQ_VALUE", pkColumnName = "SEQ_NAME")
    private Long id;
    @OneToOne
    private RequirementType requirementType;
    @ManyToOne
    private LoanTreaty loanTreaty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Requirement withId(Long id) {
        this.id = id;
        return this;
    }

    public RequirementType getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(RequirementType requirementType) {
        this.requirementType = requirementType;
    }

    public Requirement withRequirementType(RequirementType requirementType) {
        this.requirementType = requirementType;
        return this;
    }

    public LoanTreaty getLoanTreaty() {
        return loanTreaty;
    }

    public void setLoanTreaty(LoanTreaty loanTreaty) {
        this.loanTreaty = loanTreaty;
    }

    public Requirement withLoanTreaty(LoanTreaty loanTreaty) {
        this.loanTreaty = loanTreaty;
        return this;
    }

}