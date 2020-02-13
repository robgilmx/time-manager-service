package com.ksquareinc.timemanagerservice.controller;

import com.ksquareinc.timemanagerservice.model.Office;
import com.ksquareinc.timemanagerservice.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(officeService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        return ResponseEntity.ok(officeService.findOne(id));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Office office){
        officeService.delete(office);
        return ResponseEntity.ok("Entity deleted");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Office office){
        return ResponseEntity.ok(officeService.save(office));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Office office){
        return ResponseEntity.ok(officeService.save(office));
    }
    
}
