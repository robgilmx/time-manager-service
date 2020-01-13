package com.ksquareinc.timemanagerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "time_off")
public class TimeOff {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "reviewed")
    private Boolean reviewed;

    @Column(name = "approved")
    private Boolean approved;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "duration_hours", nullable = false)
    private Integer durationHours;

    @NotNull
    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonIgnoreProperties("timeOffs")
    private LeaveType leaveType;


}
