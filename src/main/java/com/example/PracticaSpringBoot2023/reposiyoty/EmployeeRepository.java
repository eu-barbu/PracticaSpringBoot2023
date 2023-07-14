package com.example.PracticaSpringBoot2023.reposiyoty;

import com.example.PracticaSpringBoot2023.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
