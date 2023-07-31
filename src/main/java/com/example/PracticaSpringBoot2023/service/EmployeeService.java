package com.example.PracticaSpringBoot2023.service;

import com.example.PracticaSpringBoot2023.dto.EmployeeFormDto;
import com.example.PracticaSpringBoot2023.dto.EmployeeOverviewDto;
import com.example.PracticaSpringBoot2023.mapper.EmployeeMapper;
import com.example.PracticaSpringBoot2023.model.Employee;
import com.example.PracticaSpringBoot2023.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    public List<EmployeeOverviewDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.getEmployeeDtoList(employeeList);
    }

    public void saveEmployee(EmployeeFormDto employeeDto) {
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
