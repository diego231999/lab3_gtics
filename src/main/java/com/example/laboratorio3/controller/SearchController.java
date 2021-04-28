package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.DepartmentRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    HistoryRepository historyRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping("/reporte1")
    public String reporteEmpleadosMayorSalario1500(Model model){
        model.addAttribute("listaEmpleadosMayorSalario",historyRepository.findAll());
        return "/Search/reporteEmpleados";
    }

    @GetMapping(value={"/reporte2"})
    public String departamentoXPaísYciudad(Model model){
        model.addAttribute("listadepartamentoxPaísYciudad", employeesRepository.listaDepartamentoXPaisYCiudad());
        return "Search/reporteDepartment";
    }
    @GetMapping(value={"/reporte3"})
    public String reporteGerentesXexp(Model model){
        model.addAttribute("listareportesGerentes", employeesRepository.listaGerentesXexperiencia());
        return "Search/reporteGerentesXexp";
    }
}
