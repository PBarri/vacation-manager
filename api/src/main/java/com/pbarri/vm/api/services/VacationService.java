package com.pbarri.vm.api.services;

import com.pbarri.vm.api.model.TVmVacation;
import com.pbarri.vm.api.repositories.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by pablo on 13/12/16.
 */
@Service
public class VacationService extends BaseService<TVmVacation, Long> {

    @Autowired
    private VacationRepository repository;

    @Override
    public JpaRepository<TVmVacation, Long> getRepository() {
        return repository;
    }
}
