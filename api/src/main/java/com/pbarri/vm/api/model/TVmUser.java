package com.pbarri.vm.api.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by pablo on 13/12/16.
 */
@Entity
@Table(name = "T_VM_USERS")
public class TVmUser extends BaseEntity implements UserDetails {

    public TVmUser() {
        vacations = new ArrayList<>();
    }

    @Column(nullable = false, unique = true, length = 20)
    private String identifier;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String surname;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String country;

    private LocalDate birthday;

    @Column(unique = true)
    private String email;

    private String phone;

    @Column(name = "PHOTO_URL")
    private String photoUrl;

    @Transient
    private String avatar;

    @Column(nullable = false)
    private Boolean locked;

    @Column(nullable = false)
    private Integer attempts;

    @Column(name = "LAST_LOGIN")
    private LocalDateTime lastLoginDate;

    @Column(name = "EXPIRING_DATE")
    private LocalDateTime expiringDate;

    @Column(name = "VACATION_DAYS", nullable = false)
    private Integer vacationDays;

    @OneToOne
    @JoinColumn(referencedColumnName = "ID", nullable = false)
    private PVmRole role;

    @ManyToOne
    private TVmTeam team;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<TVmVacation> vacations;

    public void addVacation(TVmVacation vacation) {
        if (vacations.contains(vacation)) {
            vacations.add(vacation);
            vacation.setUser(this);
        }
    }

    public void removeVacation(TVmVacation vacation) {
        vacations.remove(vacation);
        vacation.setUser(null);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return identifier;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return expiringDate.isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getters and setters

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public LocalDateTime getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(LocalDateTime expiringDate) {
        this.expiringDate = expiringDate;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public PVmRole getRole() {
        return role;
    }

    public void setRole(PVmRole role) {
        this.role = role;
    }

    public TVmTeam getTeam() {
        return team;
    }

    public void setTeam(TVmTeam team) {
        this.team = team;
    }

    public Collection<TVmVacation> getVacations() {
        return vacations;
    }

    public void setVacations(Collection<TVmVacation> vacations) {
        this.vacations = vacations;
    }
}
