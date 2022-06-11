package com.example.automappingobjectslab.service.impl;

import com.example.automappingobjectslab.model.dto.EmployeeDto;
import com.example.automappingobjectslab.model.dto.ManagerDto;
import com.example.automappingobjectslab.model.entity.Employee;
import com.example.automappingobjectslab.repository.EmployeeRepository;
import com.example.automappingobjectslab.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = this.employeeRepository.findById(1L).orElse(null);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public ManagerDto findAllManagers(Long id) {
        ModelMapper mapper = new ModelMapper();

        Employee employee = this.employeeRepository.findById(id).orElse(null);
        return mapper.map(employee, ManagerDto.class);
    }
}
