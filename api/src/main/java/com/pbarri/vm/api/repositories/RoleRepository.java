package com.pbarri.vm.api.repositories;

import com.pbarri.vm.api.model.PVmRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pablo on 13/12/16.
 */
@Repository
public interface RoleRepository extends JpaRepository<PVmRole, Long> {
}
