package com.bank.ca2.model;

import com.bank.ca2.enums.DepartmentTypeEnum;
import com.bank.ca2.enums.ManagerTypeEnum;

/**
 *
 * @author Gustavo
 */
public class Employee {

    private final String fullName;
    private final String email;
    private final double salary;
    private final String company;
    private final String jobTitle;

    private final ManagerTypeEnum managerType;
    private final DepartmentTypeEnum department;

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

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public ManagerTypeEnum getManagerType() {
        return managerType;
    }

    public DepartmentTypeEnum getDepartment() {
        return department;
    }

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