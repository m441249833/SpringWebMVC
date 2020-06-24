package com.mk.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.UUID;

public class User {

    private String id;

    @NotBlank(message = "First name can not be empty.")
    private String first_name;
    @NotBlank(message = "Last name can not be empty.")
    private String last_name;
    @NotBlank(message = "Please select a gender")
    private String gender;
    @NotNull(message = "Please enter your date of birth")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date_of_birth;
    @Email(message = "Invalid email.")
    private String email;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String first_name, String last_name, String gender, Date date_of_birth, String email) {
        this.id = UUID.randomUUID().toString();
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth=" + date_of_birth.toString() +
                ", email='" + email + '\'' +
                '}';
    }
}
