package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Departaments;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.Jobs;
import com.example.laboratorio3.repository.DepartamentsRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartamentsRepository departamentsRepository;

    @Autowired
    JobsRepository jobsRepository;

    @GetMapping("/list")
    public String listaEmployee( Model model ){
        List<Employees> employeesList = employeesRepository.findAll();
        model.addAttribute("employeesList", employeesList);
        return "employee/lista";
    }

    @GetMapping("/new")
    public String nuevoEmployeeForm(@ModelAttribute("employee") Employees employees, Model model) {
        List<Departaments> departaments = departamentsRepository.findAll();
        List<Jobs> jobs = jobsRepository.findAll();

        model.addAttribute("departaments", departaments);
        model.addAttribute("jobs", jobs);
        return "employee/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoTransportista(@ModelAttribute("employee") Employees employee, Model model, RedirectAttributes attr,
                                            @RequestParam("job_id") String jobId,
                                            @RequestParam("department_id") String departmentId
                                                ) {

            Optional<Jobs> job = jobsRepository.findById(jobId);
            employee.setJob(job.get());

            Optional<Departaments> departament;
            departament = departamentsRepository.findById(Integer.parseInt(departmentId));
            employee.setDepartament(departament.get());

            employeesRepository.save(employee);

            attr.addFlashAttribute("msg", "Employee creado exitosamente");
            return "redirect:/employee/list";


    }

    @GetMapping("/delete")
    public String borrarEmployee(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if (optionalEmployees.isPresent()) {
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Employee borrado exitosamente");
        }
        return "redirect:/employee/list";

    }

    @GetMapping("/edit")
    public String editarEmployee(Model model,
                                      @RequestParam("id") int id,
                                      @ModelAttribute("employee") Employees employees) {

        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if (optionalEmployees.isPresent()) {
            employees = optionalEmployees.get();
            model.addAttribute("employee", employees);
            return "employee/editFrm";
        } else {
            return "redirect:/employee/list";
        }
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

    @PostMapping("/BuscarEmployee")
    public String buscarEmployee(@RequestParam("searchField") String searchField,
                                 Model model) {

        List<Employees> employeesListByFirstName = employeesRepository.findAllByFirstName(searchField);
        List<Employees> employeesListByLastName = employeesRepository.findAllByLastName(searchField);

        List<Employees> employeesList = new ArrayList<Employees>();
        employeesList.addAll(employeesListByFirstName);
        employeesList.addAll(employeesListByLastName);

        model.addAttribute("employeesList", employeesList);
        return "employee/lista";
    }

}
