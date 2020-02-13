package com.ksquareinc.timemanagerservice.service;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.model.LeaveType;
import com.ksquareinc.timemanagerservice.model.TimeOff;
import com.ksquareinc.timemanagerservice.repository.TimeOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeOffService {

    @Autowired
    TimeOffRepository timeOffRepository;

    @Autowired
    EmployeeService employeeService;

    public List<TimeOff> findAll(TimeOff example){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return timeOffRepository.findAll(Example.of(example, exampleMatcher));
    }

    public Optional<TimeOff> findOne(long id){
        return timeOffRepository.findById(id);
    }

    public void delete(TimeOff timeOff){
            timeOffRepository.delete(timeOff);
    }

    public TimeOff save(TimeOff timeOff){
        employeeService.save(timeOff.getEmployee());
        return timeOffRepository.save(timeOff);
    }
}
