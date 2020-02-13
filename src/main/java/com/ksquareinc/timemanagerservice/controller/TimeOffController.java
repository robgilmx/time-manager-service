package com.ksquareinc.timemanagerservice.controller;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.model.File;
import com.ksquareinc.timemanagerservice.model.LeaveType;
import com.ksquareinc.timemanagerservice.model.TimeOff;
import com.ksquareinc.timemanagerservice.model.responses.Wrapper;
import com.ksquareinc.timemanagerservice.service.TimeOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping("api/timeoff")
public class TimeOffController {
    @Autowired
    TimeOffService timeOffService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(
            @RequestParam(required = false)
            Optional<Long> id,
            @RequestParam(required = false)
            Optional<Boolean> reviewed,
            @RequestParam(required = false)
            Optional<Boolean> approved,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(required = false)
            Optional<LocalDate> date,
            @RequestParam(required = false)
            Optional<Integer> durationHours,
            @RequestParam(required = false)
            Optional<String> reason,
            @RequestParam(required = false)
            Optional<String> description,
            @RequestParam(required = false)
            Optional<LeaveType> leaveType,
            @RequestParam(required = false)
            Optional<Employee> employee
            ){
        TimeOff timeOff = new TimeOff();
        timeOff.setId(id.orElse(null));
        timeOff.setReviewed(reviewed.orElse(null));
        timeOff.setApproved(approved.orElse(null));
        timeOff.setDate(date.orElse(null));
        timeOff.setDurationHours(durationHours.orElse(null));
        timeOff.setReason(reason.orElse(null));
        timeOff.setDescription(description.orElse(null));
        timeOff.setLeaveType(leaveType.orElse(null));
        timeOff.setEmployee(employee.orElse(null));

        Wrapper<TimeOff> response = new Wrapper<>();
        response.setContent(timeOffService.findAll(timeOff));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        return ResponseEntity.ok(timeOffService.findOne(id));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody TimeOff timeOff){
        timeOffService.delete(timeOff);
        if (timeOffService.findOne(timeOff.getId()).isPresent()){
            return ResponseEntity.status(503).body("Entity couldn't be not deleted");
        }
        return ResponseEntity.ok("Entity deleted");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody TimeOff timeOff){
        return ResponseEntity.ok(timeOffService.save(timeOff));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody TimeOff timeOff){
        return ResponseEntity.ok(timeOffService.save(timeOff));
    }


}
