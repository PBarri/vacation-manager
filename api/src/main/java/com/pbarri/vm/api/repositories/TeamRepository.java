package com.pbarri.vm.api.repositories;

import com.pbarri.vm.api.model.TVmTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pablo on 13/12/16.
 */
@Repository
public interface TeamRepository extends JpaRepository<TVmTeam, Long> {
}
