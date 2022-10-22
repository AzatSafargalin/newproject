package ru.ilb.newproject.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

/**
 * @author AndrewSych
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@DiscriminatorValue("2")
public class CompanyType extends BusinessEntity implements Serializable {

}