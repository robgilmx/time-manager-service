package com.ksquareinc.timemanagerservice.controller;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.model.VacationRights;
import com.ksquareinc.timemanagerservice.service.VacationRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/vacation-rights")
public class VacationRightsController {
    @Autowired
    VacationRightsService vacationRightsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(
            @RequestParam(required = false)
            Optional<Long> id,
            @RequestParam(required = false)
            Optional<String> planName,
            @RequestParam(required = false)
            Optional<Boolean> limitingVacations,
            @RequestParam(required = false)
            Optional<Boolean> limitingAccrued,
            @RequestParam(required = false)
            Optional<Integer> vacationDays,
            @RequestParam(required = false)
            Optional<Integer> accruedDays,
            @RequestParam(required = false)
            Optional<Integer> accruedRestartMonth,
            @RequestParam(required = false)
            Optional<Boolean> onlyCountingWorkdays,
            @RequestParam(required = false)
            Optional<Boolean> transferringAccrued,
            @RequestParam(required = false)
            Optional<Employee> employee
            ){
        VacationRights vacationRights = new VacationRights();
        vacationRights.setId(id.orElse(null));
        vacationRights.setPlanName(planName.orElse(null));
        vacationRights.setLimitingVacations(limitingVacations.orElse(null));
        vacationRights.setLimitingAccrued(limitingAccrued.orElse(null));
        vacationRights.setVacationDays(vacationDays.orElse(null));
        vacationRights.setAccruedDays(accruedDays.orElse(null));
        vacationRights.setAccruedRestartMonth(accruedRestartMonth.orElse(null));
        vacationRights.setOnlyCountingWorkdays(onlyCountingWorkdays.orElse(null));
        vacationRights.setTransferringAccrued(transferringAccrued.orElse(null));
        return ResponseEntity.ok(vacationRightsService.findAll(vacationRights, employee));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        return ResponseEntity.ok(vacationRightsService.findOne(id));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody VacationRights vacationRights){
        vacationRightsService.delete(vacationRights);
        return ResponseEntity.ok("Entity deleted");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody VacationRights vacationRights){
        return ResponseEntity.ok(vacationRightsService.save(vacationRights));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody VacationRights vacationRights){
        return ResponseEntity.ok(vacationRightsService.save(vacationRights));
    }



}
