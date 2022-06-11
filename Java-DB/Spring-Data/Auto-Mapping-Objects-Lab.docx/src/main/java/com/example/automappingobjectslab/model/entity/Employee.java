package com.example.automappingobjectslab.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Date birthday;
    private String address;
    private Boolean isOnHoliday;
    private Employee manager;
    private List<Employee> subordinates;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @ManyToOne
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee managerId) {
        this.manager = managerId;
    }

    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    @Column(name = "is_on_holiday")
    public Boolean getOnHoliday() {
        return isOnHoliday;
    }

    public void setOnHoliday(Boolean onHoliday) {
        isOnHoliday = onHoliday;
    }
}
