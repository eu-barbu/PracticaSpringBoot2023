package com.example.PracticaSpringBoot2023.controller;

import com.example.PracticaSpringBoot2023.model.Department;
import com.example.PracticaSpringBoot2023.reposiyoty.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(value = "/departmentOverview")
    public String departmentOverview(Model model) {
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("departmentList", departmentList);

        return "departmentOverview";
    }

}
