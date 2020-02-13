package com.ksquareinc.timemanagerservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "leave_types")
public class LeaveType {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "using_vacation_days")
    private Boolean usingVacationDays;

    @Column(name = "allowing_docs")
    private Boolean allowingDocs;

    @Column(name = "requiring_docs")
    private Boolean requiringDocs;

    @Column(name = "visible_for_all")
    private Boolean visibleForAll;

    @Column(name = "work_from_distance")
    private Boolean employeeWorking;

    @Column(name = "needs_approval")
    private Boolean needsApproval;

    @OneToMany(mappedBy = "leaveType")
    private List<TimeOff> timeOffs = new ArrayList<>();

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

    public Boolean getUsingVacationDays() {
        return usingVacationDays;
    }

    public void setUsingVacationDays(Boolean usingVacationDays) {
        this.usingVacationDays = usingVacationDays;
    }

    public Boolean getAllowingDocs() {
        return allowingDocs;
    }

    public void setAllowingDocs(Boolean allowingDocs) {
        this.allowingDocs = allowingDocs;
    }

    public Boolean getVisibleForAll() {
        return visibleForAll;
    }

    public void setVisibleForAll(Boolean visibleForAll) {
        this.visibleForAll = visibleForAll;
    }

    public Boolean getEmployeeWorking() {
        return employeeWorking;
    }

    public void setEmployeeWorking(Boolean employeeWorking) {
        this.employeeWorking = employeeWorking;
    }

    public Boolean getNeedsApproval() {
        return needsApproval;
    }

    public void setNeedsApproval(Boolean needsApproval) {
        this.needsApproval = needsApproval;
    }

    public List<TimeOff> getTimeOffs() {
        return timeOffs;
    }

    public void setTimeOffs(List<TimeOff> timeOffs) {
        this.timeOffs = timeOffs;
    }

    public Boolean getRequiringDocs() {
        return requiringDocs;
    }

    public void setRequiringDocs(Boolean requiringDocs) {
        this.requiringDocs = requiringDocs;
    }
}

