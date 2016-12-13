package com.pbarri.vm.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by pablo on 13/12/16.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    // Constructors

    public BaseEntity() {}

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Version
    protected Long version;

    @Column(nullable = false)
    protected LocalDateTime timestamp;

    // Equals and hashcode

    @Override
    public int hashCode() {
        return (id != null) ? id.intValue() : super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d , version=%d]", getClass().getSimpleName(), this.id, this.version);
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
        } else if (getId() != null){
            result = getId().equals(((BaseEntity) other).getId());
        } else {
            result = false;
        }

        return result;
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
