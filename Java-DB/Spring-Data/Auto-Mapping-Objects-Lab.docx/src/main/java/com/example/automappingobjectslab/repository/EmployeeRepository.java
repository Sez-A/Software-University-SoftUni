package com.example.automappingobjectslab.repository;

import com.example.automappingobjectslab.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
