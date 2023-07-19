package com.example.PracticaSpringBoot2023.mapper;

import com.example.PracticaSpringBoot2023.dto.EmployeeFormDto;
import com.example.PracticaSpringBoot2023.dto.EmployeeOverviewDto;
import com.example.PracticaSpringBoot2023.model.Department;
import com.example.PracticaSpringBoot2023.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public List<EmployeeOverviewDto> getEmployeeDtoList(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    public EmployeeOverviewDto mapToEmployeeDto(Employee employee) {
        return EmployeeOverviewDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .salary(employee.getSalary())
                .departmentCode(employee.getDepartmentCode())
                .departmentName(employee.getDepartmentName())
                .build();
    }

    public Employee mapToEmployee(EmployeeFormDto employeeDto) {
        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .salary(employeeDto.getSalary())
                .department(Department.builder().id(employeeDto.getDepartmentId()).build())
                .build();
        return employee;
    }
}
