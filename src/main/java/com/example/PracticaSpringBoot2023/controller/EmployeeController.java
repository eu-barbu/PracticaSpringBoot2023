package com.example.PracticaSpringBoot2023.controller;

import com.example.PracticaSpringBoot2023.dto.EmployeeFormDto;
import com.example.PracticaSpringBoot2023.dto.EmployeeOverviewDto;
import com.example.PracticaSpringBoot2023.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employeeOverview")
    public String index(Model model) {
        List<EmployeeOverviewDto> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employeeList);

        return "employeeOverview";
    }

    @GetMapping(value = "/employeeForm")
    public String getEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeFormDto());
        return "employeeForm";
    }

    @PostMapping(value = "/submitEmployee")
    public String submitEmployee(@ModelAttribute("employee") EmployeeFormDto employee, Model model) {
        employee.setDepartmentId(1);
        employeeService.saveEmployee(employee);
        return "redirect:/employeeOverview";
    }

    @GetMapping(value = "/deleteEmployee")
    public String submitEmployee(@RequestParam("id") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employeeOverview";
    }

}
