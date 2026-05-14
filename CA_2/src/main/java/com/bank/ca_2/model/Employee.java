package com.bank.ca_2.model;

import com.bank.ca_2.enums.DepartmentTypeEnum;
import com.bank.ca_2.enums.ManagerTypeEnum;

/**
 * Represents an employee record in the system.
 * 
 * Stores:
 * - Personal information
 * - Company information
 * - Manager type
 * - Department
 * 
 * @author Gustavo
 */
public class Employee {

    /**
     * Employee full name.
     */
    private final String fullName;

    /**
     * Employee email address.
     */
    private final String email;

    /**
     * Employee salary.
     */
    private final double salary;

    /**
     * Employee company name.
     */
    private final String company;

    /**
     * Employee job title.
     */
    private final String jobTitle;

    /**
     * Employee manager type.
     */
    private final ManagerTypeEnum managerType;

    /**
     * Employee department.
     */
    private final DepartmentTypeEnum department;

    /**
     * Employee constructor.
     * 
     * @param fullName employee full name
     * @param email employee email
     * @param salary employee salary
     * @param company employee company
     * @param jobTitle employee job title
     * @param managerType employee manager type
     * @param department employee department
     */
    public Employee(String fullName,
                    String email,
                    double salary,
                    String company,
                    String jobTitle,
                    ManagerTypeEnum managerType,
                    DepartmentTypeEnum department) {

        this.fullName = fullName;
        this.email = email;
        this.salary = salary;
        this.company = company;
        this.jobTitle = jobTitle;
        this.managerType = managerType;
        this.department = department;
    }

    /**
     * Returns employee full name.
     * 
     * @return full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns employee email.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns employee salary.
     * 
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns employee company.
     * 
     * @return company name
     */
    public String getCompany() {
        return company;
    }

    /**
     * Returns employee job title.
     * 
     * @return job title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Returns employee manager type.
     * 
     * @return manager type
     */
    public ManagerTypeEnum getManagerType() {
        return managerType;
    }

    /**
     * Returns employee department.
     * 
     * @return department
     */
    public DepartmentTypeEnum getDepartment() {
        return department;
    }

    /**
     * Returns formatted employee information.
     * 
     * @return formatted employee string
     */
    @Override
    public String toString() {

        return """
            Employee {
              Full Name = %s
              Email = %s
              Salary = %.2f
              Company = %s
              Job Title = %s
              Manager Type = %s
              Department = %s
            }
            """.formatted(
                fullName,
                email,
                salary,
                company,
                jobTitle,
                managerType,
                department);
    }
}