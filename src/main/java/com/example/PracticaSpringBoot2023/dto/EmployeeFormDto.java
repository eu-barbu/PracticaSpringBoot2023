package com.example.PracticaSpringBoot2023.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeFormDto {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;

}
