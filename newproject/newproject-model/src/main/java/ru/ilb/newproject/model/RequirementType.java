package ru.ilb.newproject.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.*;
import ru.ilb.newproject.core.RequirementTypeCode;

/**
 * @author AndrewSych
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class RequirementType implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_REQUIREMENT_TYPE_ID_GEN", strategy = GenerationType.TABLE)
    @TableGenerator(name = "SEQ_REQUIREMENT_TYPE_ID_GEN", table = "SEQUENCE", pkColumnValue = "SEQ_REQUIREMENT_TYPE_ID_GEN", valueColumnName = "SEQ_VALUE", pkColumnName = "SEQ_NAME")
    private Long id;
    @Basic
    @Enumerated(EnumType.STRING)
    private RequirementTypeCode code;
    @Basic
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequirementType withId(Long id) {
        this.id = id;
        return this;
    }

    public RequirementTypeCode getCode() {
        return code;
    }

    public void setCode(RequirementTypeCode code) {
        this.code = code;
    }

    public RequirementType withCode(RequirementTypeCode code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RequirementType withName(String name) {
        this.name = name;
        return this;
    }

}