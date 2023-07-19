package com.example.PracticaSpringBoot2023.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeOverviewDto {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private String departmentName;
    private String departmentCode;

}
