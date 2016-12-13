package com.pbarri.vm.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pablo on 13/12/16.
 */
@MappedSuperclass
public abstract class BaseParametricsEntity implements Serializable {

    // Constructors

    public BaseParametricsEntity() {}

    // Attributes

    @Id
    protected Long id;

    @Column(unique = true, updatable = false, length = 50)
    protected String code;

    @Column(length = 500)
    protected String description;

    // Equals and Hashcode ----------------------------------------------------
    @Override
    public int hashCode() {
        return getClass().hashCode() + getId().intValue();
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d , code=%s]", getClass().getSimpleName(), this.id, this.code);
    }

    @Override
    public boolean equals(Object other) {
        boolean result;

        if (this == other) {
            result = true;
        } else if (other == null) {
            result = false;
        } else if (other instanceof Long) {
            result = getId().equals(other);
        } else if (!getClass().isInstance(other)) {
            result = false;
        } else {
            result = getId().equals(((BaseEntity) other).getId());
        }

        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
