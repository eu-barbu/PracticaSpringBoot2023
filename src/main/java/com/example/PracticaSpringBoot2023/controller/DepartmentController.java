package com.example.PracticaSpringBoot2023.controller;

import com.example.PracticaSpringBoot2023.model.Department;
import com.example.PracticaSpringBoot2023.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(value = "/departmentOverview")
    public String departmentOverview(Model model, Authentication authentication) {
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("departmentList", departmentList);

        addUserToModel(model, authentication);
        return "departmentOverview";
    }

}
