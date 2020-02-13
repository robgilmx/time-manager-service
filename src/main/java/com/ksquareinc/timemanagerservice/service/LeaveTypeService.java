package com.ksquareinc.timemanagerservice.service;

import com.ksquareinc.timemanagerservice.model.LeaveType;
import com.ksquareinc.timemanagerservice.model.TimeOff;
import com.ksquareinc.timemanagerservice.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveTypeService {

    @Autowired
    LeaveTypeRepository leaveTypeRepository;

    public List<LeaveType> findAll(LeaveType example, Optional<TimeOff> timeOff){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        List<LeaveType> leaveTypes =  leaveTypeRepository.findAll(Example.of(example, exampleMatcher));
        timeOff.ifPresent(value -> leaveTypes.retainAll(leaveTypeRepository.findAllByTimeOffsContaining(value)));
        return leaveTypes;
    }

    public Optional<LeaveType> findOne(long id){
        return leaveTypeRepository.findById(id);
    }

    public void delete(LeaveType LeaveType){
            leaveTypeRepository.delete(LeaveType);
    }
    public LeaveType save(LeaveType LeaveType){
        return leaveTypeRepository.save(LeaveType);
    }
}
