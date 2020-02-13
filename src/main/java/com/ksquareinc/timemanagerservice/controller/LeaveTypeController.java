package com.ksquareinc.timemanagerservice.controller;

import com.ksquareinc.timemanagerservice.model.LeaveType;
import com.ksquareinc.timemanagerservice.model.TimeOff;
import com.ksquareinc.timemanagerservice.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/leave-types")
public class LeaveTypeController {

    @Autowired
    LeaveTypeService leaveTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(
            @RequestParam(required = false)
            Optional<Long> id,
            @RequestParam(required = false)
            Optional<String> name,
            @RequestParam(required = false)
            Optional<Boolean> usingVacationDays,
            @RequestParam(required = false)
            Optional<Boolean> allowingDocs,
            @RequestParam(required = false)
            Optional<Boolean> visibleForAll,
            @RequestParam(required = false)
            Optional<Boolean> employeeWorking,
            @RequestParam(required = false)
            Optional<Boolean> needsApproval,
            @RequestParam(required = false)
            Optional<TimeOff> timeOff
            ){
        LeaveType leaveType = new LeaveType();
        leaveType.setId(id.orElse(null));
        leaveType.setName(name.orElse(null));
        leaveType.setUsingVacationDays(usingVacationDays.orElse(null));
        leaveType.setAllowingDocs(allowingDocs.orElse(null));
        leaveType.setVisibleForAll(visibleForAll.orElse(null));
        leaveType.setEmployeeWorking(employeeWorking.orElse(null));
        leaveType.setNeedsApproval(needsApproval.orElse(null));
        return ResponseEntity.ok(leaveTypeService.findAll(leaveType, timeOff));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        return ResponseEntity.ok(leaveTypeService.findOne(id));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody LeaveType leaveType){
        leaveTypeService.delete(leaveType);
        return ResponseEntity.ok("Entity deleted");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody LeaveType leaveType){
        return ResponseEntity.ok(leaveTypeService.save(leaveType));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LeaveType leaveType){
        return ResponseEntity.ok(leaveTypeService.save(leaveType));
    }


}
