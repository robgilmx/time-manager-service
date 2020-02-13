package com.ksquareinc.timemanagerservice.repository;

import com.ksquareinc.timemanagerservice.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
