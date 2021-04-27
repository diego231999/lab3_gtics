package com.example.laboratorio3.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private
    Departaments departament;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Jobs job;

    private LocalDateTime hireDate;

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public Departaments getDepartament() {
        return departament;
    }

    public void setDepartament(Departaments departament) {
        this.departament = departament;
    }


    //COMPLETAR relacion con otras tablas
}
