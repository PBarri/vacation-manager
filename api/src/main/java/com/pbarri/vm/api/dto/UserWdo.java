package com.pbarri.vm.api.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.pbarri.vm.api.model.TVmTeam;
import com.pbarri.vm.api.model.TVmUser;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pablo on 14/12/16.
 */
@JsonAutoDetect
public class UserWdo implements Serializable {

    public UserWdo() {
    }

    public UserWdo(TVmUser user) {
        name = String.join(" ", user.getName(), user.getSurname());
        vacationDays = user.getVacationDays();
        vacationDaysLeft = user.getVacationsLeft();

        if (user.getTeam() != null) {
            teamName = user.getTeam().getName();
        }

        vacations = new ArrayList<>();

        if (user.getVacations() != null && !user.getVacations().isEmpty()) {
            user.getVacations().forEach(v -> vacations.add(new VacationWdo(v)));
        }
    }

    private String name;

    private Integer vacationDays;

    private Integer vacationDaysLeft;

    private String teamName;

    private Collection<VacationWdo> vacations;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public Integer getVacationDaysLeft() {
        return vacationDaysLeft;
    }

    public void setVacationDaysLeft(Integer vacationDaysLeft) {
        this.vacationDaysLeft = vacationDaysLeft;
    }

    public Collection<VacationWdo> getVacations() {
        return vacations;
    }

    public void setVacations(Collection<VacationWdo> vacations) {
        this.vacations = vacations;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
