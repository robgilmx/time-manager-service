package com.ksquareinc.timemanagerservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "leave_type")
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

    @Column(name = "visible_for_all")
    private Boolean visibleForAll;

    @Column(name = "work_from_distance")
    private Boolean employeeWorking;

    @Column(name = "needs_approval")
    private Boolean needsApproval;

    @OneToMany(mappedBy = "leaveType")
    private List<TimeOff> timeOffs = new ArrayList<>();

}

