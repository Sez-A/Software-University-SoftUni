package com.example.automappingobjectslab;

import com.example.automappingobjectslab.model.dto.EmployeeDto;
import com.example.automappingobjectslab.model.dto.ManagerDto;
import com.example.automappingobjectslab.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    private final EmployeeService employeeService;

    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

//        EmployeeDto dto = employeeService.findById(1L);
//        System.out.println(dto.getFirstName() + " " + dto.getLastName());

        ManagerDto dto = this.employeeService.findAllManagers(1L);
        System.out.println(dto.getFirstName() + " " +
                dto.getLastName() + " | " + "Employees: " + dto.getSubordinates().size());
        dto.getSubordinates()
                .forEach(e -> System.out.printf("\t - %s %s %.2f%n"
                        , e.getFirstName()
                        , e.getLastName()
                        , e.getSalary()));
    }
}
