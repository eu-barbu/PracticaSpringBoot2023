package com.example.PracticaSpringBoot2023.controller;

import com.example.PracticaSpringBoot2023.dto.EmployeeOverviewDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/sayHello")
    @ResponseBody
    public String printHello() {
        return "Hello World!";
    }

    @GetMapping(value = "/register")
    @ResponseBody
    public String printParams(@RequestParam String name, @RequestParam String firstname) {
        return "Hello, " + firstname + " " + name;
    }

    @GetMapping(value = "/store/{location}/products")
    @ResponseBody
    public String printPathVariables(@PathVariable String location) {
        return "Showing products for: " + location;
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<EmployeeOverviewDto> listEmployees() {
        EmployeeOverviewDto e1 = new EmployeeOverviewDto(1, "George", "Popescu", 1500, "ABC1234", "Accounting");
        EmployeeOverviewDto e2 = new EmployeeOverviewDto(2, "Maria", "Georgescu", 1750, "XYZ1234", "Logistics");
        return List.of(e1, e2); //same as defining a new ArrayList and adding elements to it.
    }

    @GetMapping(value = "/index")
    public String index(Model model) {
        String text = "Hello from controller";
        model.addAttribute("greetings", text);

        model.addAttribute("someText", "Hello World");

        List<String> carList = List.of("Dacia", "Ford", "Suzuki", "BMW");
        model.addAttribute("carList", carList);

        return "index";
    }

}
