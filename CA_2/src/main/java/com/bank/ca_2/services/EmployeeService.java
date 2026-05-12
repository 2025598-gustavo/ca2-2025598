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

    public List<String> getEmployeeNames() {
        List<String> employeeNames = new ArrayList<>();

        for (Employee employee : employees) {
            employeeNames.add(employee.getFullName());
        }

        return employeeNames;
    }
    
    public Employee findByName(String targetName) {
        for (Employee employee : employees) {

            if (employee.getFullName().equalsIgnoreCase(targetName)) {
                return employee;
            }
        }

        return null;
    }

}