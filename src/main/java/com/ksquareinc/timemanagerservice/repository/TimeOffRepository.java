package com.ksquareinc.timemanagerservice.repository;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.model.TimeOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TimeOffRepository extends JpaRepository<TimeOff, Long> {

}
