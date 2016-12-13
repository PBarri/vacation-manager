package com.pbarri.vm.api.services;

import com.pbarri.vm.api.model.TVmUser;
import com.pbarri.vm.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pablo on 13/12/16.
 */
@Service
public class UserService extends BaseService<TVmUser, Long> implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public JpaRepository<TVmUser, Long> getRepository() {
        return repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByIdentifier(username);
    }
}
