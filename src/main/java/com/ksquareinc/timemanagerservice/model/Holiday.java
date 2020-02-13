package com.ksquareinc.timemanagerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "holidays")
public class Holiday implements Serializable {
 private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "working_day")
    private Boolean workingDay;
    @Column(name = "local_date")
    private LocalDate localDate;
    @ManyToOne
    @JsonIgnoreProperties("holidays")
    private Office office;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(Boolean workingDay) {
        this.workingDay = workingDay;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
