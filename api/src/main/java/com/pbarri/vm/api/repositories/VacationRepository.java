package com.pbarri.vm.api.repositories;

import com.pbarri.vm.api.model.TVmVacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pablo on 13/12/16.
 */
@Repository
public interface VacationRepository extends JpaRepository<TVmVacation, Long> {
}
