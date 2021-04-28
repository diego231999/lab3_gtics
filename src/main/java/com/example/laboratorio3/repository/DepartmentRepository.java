package com.example.laboratorio3.repository;

import com.example.laboratorio3.dto.DepartamentoXPaísYciudad;
import com.example.laboratorio3.dto.GerentesXexperiencia;
import com.example.laboratorio3.entity.Departaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Departaments, Integer> {
    //Tercer Reporte
    @Query(value="select e.first_name, e.last_name2, j.job_title from employees e, jobs j where e.job_id=j.job_id and e.salary>15000;", nativeQuery = true)
    List<GerentesXexperiencia> gerentesxExp();
}
