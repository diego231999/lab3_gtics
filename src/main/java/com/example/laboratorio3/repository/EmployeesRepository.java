package com.example.laboratorio3.repository;


import com.example.laboratorio3.dto.DepartamentoXPaísYciudad;
import com.example.laboratorio3.dto.GerentesXexperiencia;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    List<Employees> findByFirstNameContaining(String employeeFirstName);
    List<Employees> findByLastNameContaining(String employeeLastName);

    @Query(value = "select c.country_name, l.city, count(e.employee_id) \n" +
            "     from countries c\n" +
            "     inner join locations l on (c.country_id=l.country_id)\n" +
            "     inner join departments d on (d.location_id=l.location_id)\n" +
            "     inner join employees e on (e.department_id=d.department_id)\n" +
            "     group by d.department_id;", nativeQuery = true)
    List<DepartamentoXPaísYciudad> listaDepartamentoXPaisYCiudad();


    //NO HABIA EMPLEADOS TRABAJANDO MAS DE 5 AÑOS, ENTONCES IMPRIME LOS QUE TIENEN MAS DE 1
    @Query(value = "select concat(j.first_name,' ',j.last_name) as 'Nombres',\n" +
            "\t\tfloor((DATEDIFF(h.end_date,h.start_date))/365) as `Años trabajando`\n" +
            "from employees e, employees j, job_history h\n" +
            "where e.manager_id = j.employee_id and j.employee_id = h.employee_id and floor((DATEDIFF(h.end_date,h.start_date))/365) > 0\n" +
            "group by j.employee_id;", nativeQuery = true)
    List<GerentesXexperiencia> listaGerentesXexperiencia();
}
