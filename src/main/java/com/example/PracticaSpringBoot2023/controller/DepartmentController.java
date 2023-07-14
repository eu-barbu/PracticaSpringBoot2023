package com.example.PracticaSpringBoot2023.controller;

import com.example.PracticaSpringBoot2023.model.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @GetMapping(value = "/departmentOverview")
    public String departmentOverview(Model model) {
        Department d1 = new Department(1, "AB1234", "Accounting");
        Department d2 = new Department(2, "XZ5678", "Logistics");

        List<Department> departmentList = List.of(d1, d2);
        model.addAttribute("departmentList", departmentList);

        return "departmentOverview";
    }

}
