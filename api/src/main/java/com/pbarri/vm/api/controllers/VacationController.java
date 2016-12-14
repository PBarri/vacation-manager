package com.pbarri.vm.api.controllers;

import com.pbarri.vm.api.services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pablo on 13/12/16.
 */
@RestController
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    public VacationController() {
    }

}
