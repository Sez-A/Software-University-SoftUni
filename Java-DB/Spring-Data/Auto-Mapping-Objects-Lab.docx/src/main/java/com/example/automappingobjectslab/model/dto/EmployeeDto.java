package com.example.automappingobjectslab.model.dto;

import java.math.BigDecimal;

public class EmployeeDto extends BaseDto {

    private BigDecimal salary;


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
