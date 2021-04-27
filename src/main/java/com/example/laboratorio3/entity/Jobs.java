package com.example.laboratorio3.entity;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class Jobs{

    @Id
    @Column(nullable = false)
    private String jobId;
    private String jobTittle;
    private int minSalary;
    private int maxSalary;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTittle() {
        return jobTittle;
    }

    public void setJobTittle(String jobTittle) {
        this.jobTittle = jobTittle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
}
