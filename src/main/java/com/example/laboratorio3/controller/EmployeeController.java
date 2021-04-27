package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/list")
    public String listaEmployee( Model model ){
        List<Employees> employeesList = employeesRepository.findAll();
        for(Employees employee : employeesList){
            System.out.println(employee.getDepartament().getLocation().getCity());
        }

        model.addAttribute("employeesList", employeesList.get(0));
        return "employee/lista";
    }

//    public String nuevoEmployeeForm( ) {
//        //COMPLETAR
//        return "";
//    }
//
//
//    public String guardarEmployee() {
//        //COMPLETAR
//        return "";
//    }
//
//
//    public String editarEmployee() {
//        //COMPLETAR
//        return "";
//    }
//
//
//    public String borrarEmpleado() {
//
//       //COMPLETAR
//        return "";
//    }

    //COMPLETAR

}
