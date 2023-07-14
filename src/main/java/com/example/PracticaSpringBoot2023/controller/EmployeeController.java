package com.example.PracticaSpringBoot2023.controller;

import com.example.PracticaSpringBoot2023.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping(value = "/employeeOverview")
    public String index(Model model) {
        Employee e1 = new Employee(1, "George", "Popescu", 1500);
        Employee e2 = new Employee(2, "Maria", "Georgescu", 1750);

        List<Employee> employeeList = List.of(e1, e2);
        model.addAttribute("employeeList", employeeList);

        return "employeeOverview";
    }

    @GetMapping(value = "/employeeForm")
    public String getEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @PostMapping(value = "/submitEmployee")
    public String submitEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println(employee.toString());
        return null;
    }

}
