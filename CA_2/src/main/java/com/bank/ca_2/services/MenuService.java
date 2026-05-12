package com.bank.ca_2.services;

import com.bank.ca_2.algorithms.sorting.MergeSort;

import java.util.List;

public class MenuService {

    private EmployeeService employeeService;

    public MenuService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void handleSort() {

        List<String> names =
            employeeService.getEmployeeNames();

        // Recursive Merge Sort
        MergeSort.mergeSort(names, 0, names.size() - 1);

        System.out.println("\n===== FIRST 20 SORTED NAMES =====");

        for (int i = 0; i < Math.min(20, names.size()); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }
}