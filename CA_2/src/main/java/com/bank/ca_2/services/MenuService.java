package com.bank.ca_2.services;

import com.bank.ca_2.algorithms.searching.BinarySearch;
import com.bank.ca_2.algorithms.sorting.MergeSort;
import com.bank.ca_2.enums.DepartmentTypeEnum;
import com.bank.ca_2.enums.ManagerTypeEnum;
import com.bank.ca_2.model.Employee;
import com.bank.ca_2.utils.InputValidator;

import java.util.List;
import java.util.Scanner;

public class MenuService {

    private final EmployeeService employeeService;
    private final Scanner sc;

    public MenuService(EmployeeService employeeService, Scanner sc) {
        this.employeeService = employeeService;
        this.sc = sc;
    }

    public void handleSort() {
        List<String> names = employeeService.getEmployeeNames();

        // Recursive Merge Sort
        MergeSort.mergeSort(names, 0, names.size() - 1);

        System.out.println("\n===== FIRST 20 SORTED NAMES =====");

        for (int i = 0; i < Math.min(20, names.size()); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }

    public void handleSearch() {
        List<String> names = employeeService.getEmployeeNames();

        // Binary Search requires sorted list
        MergeSort.mergeSort(names, 0, names.size() - 1);

        System.out.println("\n====== SEARCH EMPLOYEE ======");
        System.out.println("Enter FULL employee name to search: ");

        String fullName = sc.nextLine().trim();

        int result = BinarySearch.binarySearch(
                names,
                0,
                names.size() - 1,
                fullName
        );

        if (result == -1) {
            System.out.println("Employee not found.");

        } else {
            Employee emp = employeeService.findByName(fullName);

            System.out.println("\n====== EMPLOYEE FOUND =======");
            System.out.println("Name: " + emp.getFullName());
            System.out.println("Manager Type: " + emp.getManagerType());
            System.out.println("Department: " + emp.getDepartment());
        }
    }
    
     public void handleAddRecord() {
        System.out.println("\nPlease input the Employee Name:" );

        String name = sc.nextLine();

        ManagerTypeEnum manager = null;

        while (manager == null) {

            System.out.println("\nPlease select from the following Management "
                    + "Staff:");

            for (ManagerTypeEnum type : ManagerTypeEnum.values()) {
                System.out.println(type.getOption() + ". " + type.getLabel());
            }

            int choice = InputValidator.getValidInt(sc);
            manager = ManagerTypeEnum.getByValue(choice);

            if (manager == null) {
                System.out.println("Invalid manager option.");
            }
        }
        
        DepartmentTypeEnum department = null;

        while (department == null) {

            System.out.println("\nPlease select the Department:");

            for (DepartmentTypeEnum dept : DepartmentTypeEnum.values()) {
                System.out.println(dept.getOption() + ". " + dept.getLabel());
            }

            int choice = InputValidator.getValidInt(sc);
            department = DepartmentTypeEnum.getByValue(choice);

            if (department == null) {
                System.out.println("Invalid department option.");
            }
        }

        Employee employee = new Employee(
                                    name,
                                    "not_provided@email.com", // e-mail
                                    0.0, // Salary
                                    "Bank Organisation", // Bank organization
                                    "Not Assigned", // Job title
                                    manager,
                                    department
                                );

        employeeService.addEmployee(employee);

        System.out.println("\n\"" + name + "\" has been added as \""
                + manager.getLabel()+ "\" to \"" + department.getLabel()
                + "\" successfully!"
        );
    }
}
