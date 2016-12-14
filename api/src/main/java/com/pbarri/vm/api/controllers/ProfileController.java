package com.pbarri.vm.api.controllers;

import com.pbarri.vm.api.dto.UserWdo;
import com.pbarri.vm.api.model.TVmUser;
import com.pbarri.vm.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 13/12/16.
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    public ProfileController() {
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public List<UserWdo> getUsers() {
        List<UserWdo> result = new ArrayList<>();
        List<TVmUser> users = userService.findAll();

        if (users != null && !users.isEmpty()) {
            users.forEach(u -> result.add(new UserWdo(u)));
        }

        return result;
    }

    @RequestMapping(value = "/userData", method = RequestMethod.POST)
    public UserWdo getUserData(@RequestBody String identifier) {

        UserWdo result = null;

        if (StringUtils.hasText(identifier)) {
            TVmUser user = (TVmUser) userService.loadUserByUsername(identifier);
            result = new UserWdo(user);
        }

        return result;
    }
}
