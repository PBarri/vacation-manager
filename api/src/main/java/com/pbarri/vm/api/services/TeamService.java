package com.pbarri.vm.api.services;

import com.pbarri.vm.api.model.TVmTeam;
import com.pbarri.vm.api.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by pablo on 13/12/16.
 */
@Service
public class TeamService extends BaseService<TVmTeam, Long> {

    @Autowired
    private TeamRepository repository;

    @Override
    public JpaRepository<TVmTeam, Long> getRepository() {
        return repository;
    }
}
