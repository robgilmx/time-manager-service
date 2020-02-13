package com.ksquareinc.timemanagerservice.controller;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        return ResponseEntity.ok(employeeService.findOne(id));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Employee employee){
        employeeService.delete(employee);
        return ResponseEntity.ok("Entity deleted");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

}
