package com.ksquareinc.timemanagerservice.controller;

import com.ksquareinc.timemanagerservice.model.Holiday;
import com.ksquareinc.timemanagerservice.model.Office;
import com.ksquareinc.timemanagerservice.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("api/holiday")
public class HolidayController {

    @Autowired
    HolidayService holidayService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(
            @RequestParam(required = false)
            Optional<Long> id,
            @RequestParam(required = false)
            Optional<String> name,
            @RequestParam(required = false)
            Optional<String> description,
            @RequestParam(required = false)
            Optional<Boolean> workingDay,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @RequestParam(required = false)
            Optional<LocalDate> localDate,
            @RequestParam(required = false)
            Optional<Office> office
            ){
        Holiday holiday = new Holiday();
        holiday.setId(id.orElse(null));
        holiday.setName(name.orElse(null));
        holiday.setDescription(description.orElse(null));
        holiday.setLocalDate(localDate.orElse(null));
        holiday.setWorkingDay(workingDay.orElse(null));
        holiday.setOffice(office.orElse(null));
        return ResponseEntity.ok(holidayService.findAll(holiday));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        return ResponseEntity.ok(holidayService.findOne(id));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Holiday holiday){
        holidayService.delete(holiday);
        return ResponseEntity.ok("Entity deleted");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Holiday holiday){
        return ResponseEntity.ok(holidayService.save(holiday));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Holiday holiday){
        return ResponseEntity.ok(holidayService.save(holiday));
    }


}
