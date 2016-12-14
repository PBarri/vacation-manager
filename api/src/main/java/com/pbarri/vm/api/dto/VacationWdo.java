package com.pbarri.vm.api.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.pbarri.vm.api.model.TVmVacation;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by pablo on 14/12/16.
 */
@JsonAutoDetect
public class VacationWdo implements Serializable {

    public VacationWdo() {

    }

    public VacationWdo(TVmVacation vacation) {
        startDate = vacation.getStartDate().format(DateTimeFormatter.ISO_DATE);
        endDate = vacation.getEndDate().format(DateTimeFormatter.ISO_DATE);
        year = vacation.getYear();
        approved = vacation.getApproved();
    }

    private String startDate;

    private String endDate;

    private Integer year;

    private Boolean approved;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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
}
