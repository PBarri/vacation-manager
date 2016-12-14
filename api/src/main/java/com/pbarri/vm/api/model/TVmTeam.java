package com.pbarri.vm.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by pablo on 13/12/16.
 */
@Entity
@Table(name = "T_VM_TEAMS")
public class TVmTeam extends BaseEntity {

    public TVmTeam() {
        users = new ArrayList<>();
        timestamp = LocalDateTime.now();
    }

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private Collection<TVmUser> users;

    // Helper

    public void addUser(TVmUser user) {
        if (!users.contains(user)) {
            users.add(user);
            user.setTeam(this);
        }
    }

    public void removeUser(TVmUser user) {
        users.remove(user);
        user.setTeam(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<TVmUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<TVmUser> users) {
        this.users = users;
    }
}
