package com.example.PracticaSpringBoot2023.repository;

import com.example.PracticaSpringBoot2023.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
