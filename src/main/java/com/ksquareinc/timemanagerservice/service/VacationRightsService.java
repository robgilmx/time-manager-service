package com.ksquareinc.timemanagerservice.service;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.model.LeaveType;
import com.ksquareinc.timemanagerservice.model.TimeOff;
import com.ksquareinc.timemanagerservice.model.VacationRights;
import com.ksquareinc.timemanagerservice.repository.VacationRightsRepository;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationRightsService {

    @Autowired
    VacationRightsRepository vacationRightsRepository;

    public List<VacationRights> findAll(VacationRights example, Optional<Employee> employee){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        List<VacationRights> vacationRights =  vacationRightsRepository.findAll(Example.of(example, exampleMatcher));
        employee.ifPresent(value -> vacationRights.retainAll(vacationRightsRepository.findAllByEmployeesContaining(value)));
        return vacationRights;
    }
    public Optional<VacationRights> findOne(long id){
        return vacationRightsRepository.findById(id);
    }

    public void delete(VacationRights vacationRights){
        if (vacationRights.getEmployees() == null || vacationRights.getEmployees().isEmpty()){
            vacationRightsRepository.delete(vacationRights);
        }
        Logger.logMsg(Logger.ERROR, "Couldn't delete Vacation Rights: " + vacationRights.getId() + " because employees depend of it.");
    }

    public VacationRights save(VacationRights vacationRights){
        return vacationRightsRepository.save(vacationRights);
    }
}
