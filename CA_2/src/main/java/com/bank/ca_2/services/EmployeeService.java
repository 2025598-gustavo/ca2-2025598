package com.bank.ca_2.services;

import com.bank.ca_2.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addAll(List<Employee> list) {
        employees.addAll(list);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}