package com.ksquareinc.timemanagerservice.service;

import com.ksquareinc.timemanagerservice.model.Holiday;
import com.ksquareinc.timemanagerservice.model.Office;
import com.ksquareinc.timemanagerservice.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    OfficeService officeService;

    public List<Holiday> findAll(Holiday holiday){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return holidayRepository.findAll(Example.of(holiday, exampleMatcher));
    }

    public Optional<Holiday> findOne(long id){
        return holidayRepository.findById(id);
    }

    public void delete(Holiday holiday){
            holidayRepository.delete(holiday);
    }

    public Holiday save(Holiday holiday){
        officeService.save(holiday.getOffice());
        return holidayRepository.save(holiday);
    }
}
