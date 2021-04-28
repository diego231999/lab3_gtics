package com.example.laboratorio3.entity;

import org.hibernate.annotations.Cache;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_history")
public class JobHistory {

    @Id
    @Column(nullable = false, name = "job_history_id")
    private int jobHistoryId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employees;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departaments departaments;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Departaments getDepartaments() {
        return departaments;
    }

    public void setDepartaments(Departaments departaments) {
        this.departaments = departaments;
    }

    public int getJobHistoryId() {
        return jobHistoryId;
    }

    public void setJobHistoryId(int jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
