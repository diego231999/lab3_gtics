package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<JobHistory, Integer> {
    /* @Query(value = "select e.first_name, e.last_name, h.start_date, h.end_date, j.job_title\n" +
            "from employees e\n" +
            "inner join job_history h on (e.employee_id = h.employee_id)\n" +
            "inner join jobs j on (j.job_id = h.job_id)\n" +
            "where e.salary > 15000\n" +
            "order by e.salary ASC;", nativeQuery = true)
    List<JobHistory> reporteEmpleadosMayor15000Salario(); */
}
