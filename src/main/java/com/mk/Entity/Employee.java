package com.mk.Entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    @Column(name="first_name")
    private String firtst_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;
    @Column(name="position")
    private String position;

    @ManyToOne
    private Department department;

    public Employee(String firtst_name, String last_name, String email, String position) {
        this.firtst_name = firtst_name;
        this.last_name = last_name;
        this.email = email;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirtst_name() {
        return firtst_name;
    }

    public void setFirtst_name(String firtst_name) {
        this.firtst_name = firtst_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
