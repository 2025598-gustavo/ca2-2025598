package com.bank.ca_2.services;

import com.bank.ca_2.model.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for managing employee records.
 *
 * This class handles: 
 * 
 * - Adding employees 
 * - Storing employee data 
 * - Returning employee lists 
 * - Retrieving employee names 
 * - Searching employees by full name
 *
 * @author Gustavo
 */
public class EmployeeService {

    // List used to store all employee records
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Adds a single employee to the employee list.
     *
     * @param employee employee object to be added
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Adds multiple employees to the employee list.
     *
     * Used when loading employee data from the file.
     *
     * @param list list of employees
     */
    public void addAll(List<Employee> list) {
        employees.addAll(list);
    }

    /**
     * Returns all employees currently stored in memory.
     *
     * @return list of employees
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * Extracts and returns only employee full names.
     *
     * This list is used for sorting and searching operations.
     *
     * @return list containing employee full names
     */
    public List<String> getEmployeeNames() {
        List<String> employeeNames = new ArrayList<>();

        // Loop through all employees
        for (Employee employee : employees) {
            employeeNames.add(employee.getFullName());
        }

        return employeeNames;
    }

    /**
     * Searches for an employee by full name.
     *
     * The comparison ignores upper/lower case differences.
     *
     * @param targetName employee name to search
     * @return matching employee object or null if not found
     */
    public Employee findByName(String targetName) {

        // Iterate through all employees
        for (Employee employee : employees) {
            // Check if names match
            if (employee.getFullName().equalsIgnoreCase(targetName)) {
                return employee;
            }
        }
        return null;
    }
}
