package com.ksquareinc.timemanagerservice.repository;

import com.ksquareinc.timemanagerservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
