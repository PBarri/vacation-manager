package com.pbarri.vm.api.model;

import com.pbarri.vm.api.enums.EnumRoles;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by pablo on 13/12/16.
 */
@Entity
@Table(name = "P_VM_ROLES")
public class PVmRole extends BaseParametricsEntity implements GrantedAuthority {

    public PVmRole() {}

    public PVmRole(EnumRoles role) {
        this.id = role.getId();
        this.code = role.getCode();
        this.description = role.getDescription();
    }


    @Override
    public String getAuthority() {
        return this.code;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof EnumRoles) ? id.equals(((EnumRoles) obj).getId()) : super.equals(obj);
    }
}
