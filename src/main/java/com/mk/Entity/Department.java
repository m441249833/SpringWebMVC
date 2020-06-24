package com.mk.Entity;


import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
