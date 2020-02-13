package com.ksquareinc.timemanagerservice.repository;

import com.ksquareinc.timemanagerservice.model.Employee;
import com.ksquareinc.timemanagerservice.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
