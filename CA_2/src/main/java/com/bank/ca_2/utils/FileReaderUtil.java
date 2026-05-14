package com.bank.ca_2.utils;

import com.bank.ca_2.enums.DepartmentTypeEnum;
import com.bank.ca_2.enums.ManagerTypeEnum;
import com.bank.ca_2.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class FileReaderUtil {

    public static List<Employee> readFile(String fileName) {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                // Skip CSV header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                // Validate minimum CSV columns
                if (parts.length < 9) {
                    continue;
                }

                String firstName = parts[0].trim();
                String lastName = parts[1].trim();

                String email = parts[3].trim();

                double salary = Double.parseDouble(parts[4].trim());

                String departmentValue = parts[5].trim();
                String managerValue = parts[6].trim();

                String jobTitle = parts[7].trim();
                String company = parts[8].trim();

                String fullName = firstName + " " + lastName;

                ManagerTypeEnum manager = ManagerTypeEnum.fromString(managerValue);

                DepartmentTypeEnum department = DepartmentTypeEnum.fromString(
                        departmentValue);

                Employee employee = new Employee(
                        fullName,
                        email,
                        salary,
                        company,
                        jobTitle,
                        manager,
                        department
                );  

                employees.add(employee);
            }

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: " + e.getMessage()
            );
        }

        return employees;
    }
}