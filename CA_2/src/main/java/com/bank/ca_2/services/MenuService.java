package com.bank.ca_2.services;

import com.bank.ca_2.algorithms.searching.BinarySearch;
import com.bank.ca_2.algorithms.sorting.MergeSort;
import com.bank.ca_2.enums.DepartmentTypeEnum;
import com.bank.ca_2.enums.ManagerTypeEnum;
import com.bank.ca_2.model.Employee;
import com.bank.ca_2.structures.EmployeeBinaryTree;
import com.bank.ca_2.utils.InputValidator;

import java.util.List;
import java.util.Scanner;

/**
 * Service class responsible for handling all menu operations.
 * 
 * This class controls:
 * - Sorting employee names
 * - Searching employees
 * - Adding new employee records
 * - Building and displaying the employee binary tree
 * 
 * The class acts as the main interaction layer between
 * the user and the system business logic.
 * 
 * @author Gustavo
 */
public class MenuService {

    private final EmployeeService employeeService;
    private final Scanner sc;
    private final EmployeeBinaryTree tree;

    /**
     * Constructor used to initialize dependencies.
     * 
     * @param employeeService employee service instance
     * @param sc scanner for user input
     */
    public MenuService(EmployeeService employeeService, Scanner sc) {

        this.employeeService = employeeService;
        this.sc = sc;
        this.tree = new EmployeeBinaryTree();
    }

    /**
     * Handles the SORT menu option.
     * 
     * Retrieves all employee names and sorts them alphabetically using 
     * recursive Merge Sort.
     * 
     * Displays only the first 20 sorted names.
     */
    public void handleSort() {
        List<String> names = employeeService.getEmployeeNames();

        // Recursive Merge Sort
        MergeSort.mergeSort(names, 0, names.size() - 1);

        System.out.println("\n===== FIRST 20 SORTED NAMES =====");

        // Display first 20 names
        for (int i = 0; i < Math.min(20, names.size()); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }

    /**
     * Handles the SEARCH menu option.
     * 
     * Uses recursive Binary Search to locate an employee by full name from the 
     * sorted list.
     * 
     * Displays employee name, manager type,
     * and department if found.
     */
    public void handleSearch() {
        List<String> names = employeeService.getEmployeeNames();

        // Binary Search requires sorted data
        MergeSort.mergeSort(names, 0, names.size() - 1);

        System.out.println("\n====== SEARCH EMPLOYEE ======");
        System.out.println("Enter FULL employee name to search: ");

        String fullName = sc.nextLine().trim();

        // Recursive Binary Search
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

    /**
     * Handles the ADD RECORD menu option.
     * 
     * Allows the user to:
     * - Enter employee name
     * - Select manager type
     * - Select department
     * 
     * User input is validated using enums.
     * 
     * The employee is then added to memory.
     */
    public void handleAddRecord() {
        System.out.println("\nPlease input the Employee Name:");

        String name = sc.nextLine();
        ManagerTypeEnum manager = null;

        while (manager == null) {
            System.out.println("\nPlease select from the following Management "
                    + "Staff:");

            // Display manager options
            for (ManagerTypeEnum type : ManagerTypeEnum.values()) {
                System.out.println(type.getOption() + ". " + type.getLabel());
            }

            int choice = InputValidator.getValidInt(sc);
            manager = ManagerTypeEnum.getByValue(choice);

            // Validate manager option
            if (manager == null) {
                System.out.println("Invalid manager option.");
            }
        }

        
        // DEPARTMENT SELECTION
        DepartmentTypeEnum department = null;

        while (department == null) {

            System.out.println("\nPlease select the Department:");

            // Display department options
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

        // Add employee to system
        employeeService.addEmployee(employee);

        System.out.println("\n\"" + name + "\" has been added as \""
                + manager.getLabel() + "\" to \"" + department.getLabel()
                + "\" successfully!"
        );
    }

    /**
     * Handles the BINARY TREE menu option.
     * 
     * Inserts employees into the binary tree using level-order insertion.
     * 
     * Displays:
     * - Employee hierarchy
     * - Tree height
     * - Total node count
     */
    public void handleBinaryTree() {

        // Get all employees
        List<Employee> employees = employeeService.getAllEmployees();

        // Validate employee list
        if (employees.isEmpty()) {
            System.out.println("No employees loaded.");
            return;
        }

        // INSERT INTO TREE
        for (Employee employee : employees) {
            tree.insert(employee);
        }

        // DISPLAY TREE
        tree.levelOrderTraversal();

        // HEIGHT
        System.out.println("\nTree Height: " + tree.getHeight(tree.getRoot()));

        // TOTAL NODES
        System.out.println("Total Nodes: "+ tree.countNodes(tree.getRoot()));
    }
}