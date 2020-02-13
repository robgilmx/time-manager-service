package com.ksquareinc.timemanagerservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "vacation_rights")
public class VacationRights implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "plan_name", nullable = false)
    private String planName;

    @Column(name = "limiting_vacations")
    private Boolean limitingVacations = true;

    @Column(name = "limiting_accrued")
    private Boolean limitingAccrued = true;

    @NotNull
    @Min(value = 0)
    @Max(value = 366)
    @Column(name = "vacation_days", nullable = false)
    private Integer vacationDays;

    @NotNull
    @Min(value = 0)
    @Max(value = 366)
    @Column(name = "accrued_days", nullable = false)
    private Integer accruedDays;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    @Column(name = "accrued_restart_month", nullable = false)
    private Integer accruedRestartMonth;

    @Column(name = "only_counting_workdays")
    private Boolean onlyCountingWorkdays = true;

    @Column(name = "transferring_accrued")
    private Boolean transferringAccrued = false;
    
    @OneToMany(mappedBy = "vacationRights")
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Boolean getLimitingVacations() {
        return limitingVacations;
    }

    public void setLimitingVacations(Boolean limitingVacations) {
        this.limitingVacations = limitingVacations;
    }

    public Boolean getLimitingAccrued() {
        return limitingAccrued;
    }

    public void setLimitingAccrued(Boolean limitingAccrued) {
        this.limitingAccrued = limitingAccrued;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public Integer getAccruedDays() {
        return accruedDays;
    }

    public void setAccruedDays(Integer accruedDays) {
        this.accruedDays = accruedDays;
    }

    public Integer getAccruedRestartMonth() {
        return accruedRestartMonth;
    }

    public void setAccruedRestartMonth(Integer accruedRestartMonth) {
        this.accruedRestartMonth = accruedRestartMonth;
    }

    public Boolean getOnlyCountingWorkdays() {
        return onlyCountingWorkdays;
    }

    public void setOnlyCountingWorkdays(Boolean onlyCountingWorkdays) {
        this.onlyCountingWorkdays = onlyCountingWorkdays;
    }

    public Boolean getTransferringAccrued() {
        return transferringAccrued;
    }

    public void setTransferringAccrued(Boolean transferringAccrued) {
        this.transferringAccrued = transferringAccrued;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
