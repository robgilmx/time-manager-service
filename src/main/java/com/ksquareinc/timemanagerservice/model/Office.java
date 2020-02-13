package com.ksquareinc.timemanagerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offices")
public class Office implements Serializable {

    @Id
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "office")
    private List<Holiday> holidays = new ArrayList<>();


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
}
