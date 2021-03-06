package com.ksquareinc.timemanagerservice.repository;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.model.VacationRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRightsRepository extends JpaRepository<VacationRights, Long> {

    List<VacationRights> findAllByEmployeesContaining(Employee employee);
}
