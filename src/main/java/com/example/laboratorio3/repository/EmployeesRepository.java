package com.example.laboratorio3.repository;


import com.example.laboratorio3.dto.DepartamentoXPaísYciudad;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    //Primer Reporte
    @Query(value="select e.first_name, e.last_name, j.job_title from employees e, jobs j where e.job_id=j.job_id and e.salary>15000;", nativeQuery = true)
    List<String> listaReportesEmployee();

    //Segundo Reporte
    @Query(value="select e.first_name, e.last_name2, j.job_title from employees e, jobs j where e.job_id=j.job_id and e.salary>15000;", nativeQuery = true)
    List<DepartamentoXPaísYciudad> listadepartamento();

    @Query(value = "select e.first_name, e.last_name, j.job_title, d.department_name, e.hire_date from employees e, jobs j, departments d where e.department_id = d.department_id and e.job_id = j.job_id order by e.first_name ASC;", nativeQuery = true)
    List<Employees> historialEmployees();

    List<Employees>  findByEmployeeFirstNameO (String text);

}
