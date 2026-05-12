package com.bank.ca_2.utils;

import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class InputValidator {
    
    /**
     * Reads a valid integer from user input.
     * Keeps asking until a valid number is entered.
     * @param sc
     * @return 
     */
    public static int getValidInt(Scanner sc) {
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear invalid input
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            return choice;
        }
    }
}