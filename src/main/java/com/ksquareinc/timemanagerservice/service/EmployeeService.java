package com.ksquareinc.timemanagerservice.service;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findOne(long id){
        return employeeRepository.findById(id);
    }

    public void delete(Employee Employee){
            employeeRepository.delete(Employee);
    }
    public Employee save(Employee Employee){
        return employeeRepository.save(Employee);
    }
}
