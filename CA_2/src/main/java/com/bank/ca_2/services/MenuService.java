package com.bank.ca_2.services;

import com.bank.ca_2.algorithms.searching.BinarySearch;
import com.bank.ca_2.algorithms.sorting.MergeSort;
import com.bank.ca_2.model.Employee;

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

        System.out.println("\n===== SEARCH EMPLOYEE =====");
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

            System.out.println("\n===== EMPLOYEE FOUND =====");
            System.out.println("Name: " + emp.getFullName());
            System.out.println("Manager Type: " + emp.getManagerType());
            System.out.println("Department: " + emp.getDepartment());
        }
    }
}
