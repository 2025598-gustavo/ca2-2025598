package com.bank.ca_2;

import com.bank.ca_2.enums.MenuOptionEnum;
import com.bank.ca_2.model.Employee;
import com.bank.ca_2.services.EmployeeService;
import com.bank.ca_2.services.MenuService;
import com.bank.ca_2.utils.FileReaderUtil;
import com.bank.ca_2.utils.InputValidator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class CA_2 {

    static Scanner sc = new Scanner(System.in);
    static EmployeeService employeeService = new EmployeeService();
    static MenuService menuService = new MenuService(employeeService, sc);

    public static void main(String[] args) {
        
        loadEmployeesFromFile();

        while (true) {
            MenuOptionEnum option = null;

            while (option == null) {
                System.out.println("\n============================= "
                                 + "\n  Bank Organisation System "
                                 + "\n=============================");

                System.out.println("\n========= Main Menu =========");
                
                for (MenuOptionEnum opt : MenuOptionEnum.values()) {
                    System.out.println(opt.getOption() + ". " + opt.getLabel());
                }

                int choice = InputValidator.getValidInt(sc);
                option = MenuOptionEnum.getByValue(choice);

                if (option == null) {
                    System.out.println("Invalid choice! Please try again.");
                }
            }

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
    
    public static void loadEmployeesFromFile() {
        System.out.println("Please enter the filename to read:");
    
        String fileName = sc.nextLine();
        
        List<Employee> employees = FileReaderUtil.readFile(fileName);
        
        if (employees.isEmpty()) {
            System.out.println("No records loaded.");
        } else {
            employeeService.addAll(employees);

            System.out.println(
                    employees.size() + " employees loaded successfully."
            );
        }
    } 
}