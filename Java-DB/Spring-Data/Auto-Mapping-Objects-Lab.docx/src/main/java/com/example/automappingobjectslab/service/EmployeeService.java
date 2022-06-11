package com.example.automappingobjectslab.service;

import com.example.automappingobjectslab.model.dto.EmployeeDto;
import com.example.automappingobjectslab.model.dto.ManagerDto;

public interface EmployeeService {
    EmployeeDto findById(Long id);

    ManagerDto findAllManagers(Long id);
}
