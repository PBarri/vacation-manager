package com.pbarri.km.api;

import com.pbarri.vm.api.ApiApplication;
import com.pbarri.vm.api.enums.EnumRoles;
import com.pbarri.vm.api.model.PVmRole;
import com.pbarri.vm.api.model.TVmTeam;
import com.pbarri.vm.api.model.TVmUser;
import com.pbarri.vm.api.model.TVmVacation;
import com.pbarri.vm.api.repositories.RoleRepository;
import com.pbarri.vm.api.services.TeamService;
import com.pbarri.vm.api.services.UserService;
import com.pbarri.vm.api.services.VacationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

/**
 * Created by pablo on 13/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class DataTests {

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private VacationService vacationService;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void servicesLoaded() {
        Assert.assertNotNull(userService);
        Assert.assertNotNull(teamService);
        Assert.assertNotNull(vacationService);
        Assert.assertNotNull(roleRepository);
    }

    @Test
    public void testRoles() {
        Collection<PVmRole> roles = roleRepository.findAll();
        Assert.assertTrue(roles.size() == 2);
    }

    @Test
    public void testNewUser(){
        TVmUser user = new TVmUser();

        user.setName("Tecnico");
        user.setSurname("1");
        user.setAttempts(0);
        user.setBirthday(LocalDate.of(1989, Month.JULY, 21));
        user.setCountry("Spain");
        user.setCity("Seville");
        user.setEmail("t1@organization.es");
        user.setExpiringDate(LocalDate.of(2020, Month.JANUARY, 1).atStartOfDay());
        user.setIdentifier("t1");
        user.setLocked(false);
        user.setPassword("password");
        user.setVacationDays(22);
        user.setRole(new PVmRole(EnumRoles.CROSSFIELD));

        userService.save(user);
    }

    @Test
    public void testNewTeam() {
        TVmTeam team = new TVmTeam();

        team.setName("Crossfield");

        teamService.save(team);
    }

    @Test
    public void addVacation() {
        TVmUser user = (TVmUser) userService.loadUserByUsername("t1");
        TVmVacation vacation = new TVmVacation();
        vacation.setApproved(false);
        vacation.setStartDate(LocalDate.of(2016, 12, 24));
        vacation.setEndDate(LocalDate.of(2016, 12, 25));
        vacation.setManaged(false);
        vacation.setYear(2016);

        user.addVacation(vacation);

        userService.save(user);
    }
}
