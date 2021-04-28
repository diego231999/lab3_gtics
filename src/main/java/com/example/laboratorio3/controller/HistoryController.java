package com.example.laboratorio3.controller;


import com.example.laboratorio3.entity.Departaments;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.DepartamentsRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.HistoryRepository;
import com.example.laboratorio3.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Controller
@RequestMapping("/historial")
public class HistoryController {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartamentsRepository departamentsRepository;

    @Autowired
    JobsRepository jobsRepository;


    @GetMapping("/listar")
    public String historialEmpleados(Model model){
        model.addAttribute("historialEmpleados", historyRepository.findAll());
        return "/historial/lista";
    }

    @PostMapping("/buscar")
    public String buscarEmpleados(@RequestParam("searchName") String txt, Model model){

        List<Employees> employeesListF = employeesRepository.findByFirstNameContaining(txt);
        List<Employees> employeesListL = employeesRepository.findByLastNameContaining(txt);

        model.addAttribute("historialEmpleados",employeesListF);
        return "/historial/lista";
    }

}
