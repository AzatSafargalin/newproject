package ru.ilb.newproject.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.*;
import ru.ilb.newproject.listeners.BusinessEntityListener;

/**
 * @author AndrewSych
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(indexes = @Index(name = "UNQ_BUSINESSENTITY", columnList = "UID", unique = true))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners({BusinessEntityListener.class})
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, length = 11)
public abstract class BusinessEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_BUSINESSENTITY_ID_GEN", strategy = GenerationType.TABLE)
    @TableGenerator(name = "SEQ_BUSINESSENTITY_ID_GEN", table = "SEQUENCE", pkColumnValue = "SEQ_BUSINESSENTITY_ID_GEN", valueColumnName = "SEQ_VALUE", pkColumnName = "SEQ_NAME")
    private Long id;
    @Basic
    @Column(columnDefinition = "BINARY(16) NOT NULL")
    private UUID uid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusinessEntity withId(Long id) {
        this.id = id;
        return this;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public BusinessEntity withUid(UUID uid) {
        this.uid = uid;
        return this;
    }

}