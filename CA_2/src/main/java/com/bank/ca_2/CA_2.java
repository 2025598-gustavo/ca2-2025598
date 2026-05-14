package com.bank.ca_2;

import com.bank.ca_2.enums.MenuOptionEnum;
import com.bank.ca_2.model.Employee;
import com.bank.ca_2.services.EmployeeService;
import com.bank.ca_2.services.MenuService;
import com.bank.ca_2.utils.FileReaderUtil;
import com.bank.ca_2.utils.InputValidator;

import java.util.List;
import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Gustavo
 */
public class CA_2 {

    static Scanner sc = new Scanner(System.in);
    static EmployeeService employeeService = new EmployeeService();
    static MenuService menuService = new MenuService(employeeService, sc);

    /**
     * Application entry point.
     * 
     * Steps:
     * 1. Load employee records from file
     * 2. Display menu continuously
     * 3. Execute selected menu option
     * 4. Exit when user selects EXIT
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Load employees before starting the system
        loadEmployeesFromFile();

        while (true) {
            // Stores selected menu option
            MenuOptionEnum option = null;

            /**
             * Keeps asking until a valid menu option is selected.
             */
            while (option == null) {
                System.out.println("\n============================= "
                        + "\n  Bank Organisation System "
                        + "\n=============================");

                System.out.println("\n========= Main Menu =========");

                /**
                 * Dynamically display all menu options
                 * from MenuOptionEnum.
                 */
                for (MenuOptionEnum opt : MenuOptionEnum.values()) {
                    System.out.println(opt.getOption() + ". " + opt.getLabel());
                }

                // Read validated integer input
                int choice = InputValidator.getValidInt(sc);

                // Convert integer choice into enum option
                option = MenuOptionEnum.getByValue(choice);

                // Invalid option handling
                if (option == null) {
                    System.out.println("Invalid choice! Please try again.");
                }
            }

            /**
             * Execute selected menu functionality.
             */
            switch (option) {
                case SORT -> {
                    menuService.handleSort();
                }
                case SEARCH -> {
                    menuService.handleSearch();
                }
                case ADD_RECORD -> {
                    menuService.handleAddRecord();
                }
                case BINARY_TREE -> {
                    menuService.handleBinaryTree();
                }
                case EXIT -> {
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }
            }
        }
    }

    /**
     * Loads employee records from a user-provided file.
     * 
     * Validation:
     * - File must exist
     * - File must contain records
     * 
     * The loaded employees are stored in EmployeeService.
     */
    public static void loadEmployeesFromFile() {
        while (true) {
            // Ask user for filename
            System.out.println("Please enter the filename to read:");

            String fileName = sc.nextLine();

            // Create file object for validation
            File file = new File(fileName);

            /**
             * Check if file exists before reading.
             */
            if (!file.exists()) {
                System.out.println("File not found. Please try again.");
                continue;
            }

            // Read employees from file
            List<Employee> employees = FileReaderUtil.readFile(fileName);

            if (employees.isEmpty()) {
                System.out.println("No records loaded.");
            } else {
                // Store all employees in memory
                employeeService.addAll(employees);
                System.out.println(employees.size() + " employees loaded successfully.");
                break;
            }
        }
    }
}