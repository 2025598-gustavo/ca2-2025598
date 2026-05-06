package com.bank.ca2;

import com.bank.ca2.enums.MenuOptionEnum;
import com.bank.ca2.utils.InputValidator;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class CA2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

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
                    // Implementation SORT
                }
                case SEARCH -> {
                    // Implementation SEARCH
                }
                case ADD_RECORD -> {
                    // Implementation ADD_RECORD
                }
                case BINARY_TREE -> {
                    // Implementation BINARY_TREE
                }
                case EXIT -> {
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }
            }
        }
    }
}