package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.DepartmentRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//COMPLETAR
@RequestMapping("/search")
public class SearchController {

    //COMPLETAR
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }


    @GetMapping(value={"/reporte1"})
    public String departamentoXPaísYciudad(Model model){
        model.addAttribute("listadepartamentoxPaísYciudad", employeesRepository.listadepartamento());
        return "Search/reporteDepartment";
    }
    @GetMapping(value={"/reporte2"})
    public String reporteGerentesXexp(Model model){
        model.addAttribute("listareportesGerentes", departmentRepository.gerentesxExp());
        return "Search/reporteGerentesXexp";
    }
}
