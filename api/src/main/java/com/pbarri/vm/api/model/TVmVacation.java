package com.pbarri.vm.api.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by pablo on 13/12/16.
 */
@Entity
@Table(name = "T_VM_VACATIONS")
public class TVmVacation extends BaseEntity {

    // Constructor

    public TVmVacation() {
    }

    // Attributes

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Boolean approved;

    @Column(nullable = false)
    private Boolean managed;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private TVmUser user;

    // Getters and setters

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getManaged() {
        return managed;
    }

    public void setManaged(Boolean managed) {
        this.managed = managed;
    }

    public TVmUser getUser() {
        return user;
    }

    public void setUser(TVmUser user) {
        this.user = user;
    }
}
