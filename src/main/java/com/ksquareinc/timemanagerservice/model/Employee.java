package com.ksquareinc.timemanagerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @ManyToOne
    @JsonIgnoreProperties("employees")
    private VacationRights vacationRights;

    @OneToMany(mappedBy = "employee")
    private List<TimeOff> timeOffs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public VacationRights getVacationRights() {
        return vacationRights;
    }

    public void setVacationRights(VacationRights vacationRights) {
        this.vacationRights = vacationRights;
    }

    public List<TimeOff> getTimeOffs() {
        return timeOffs;
    }

    public void setTimeOffs(List<TimeOff> timeOffs) {
        this.timeOffs = timeOffs;
    }
}
