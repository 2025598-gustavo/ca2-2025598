package com.bank.ca_2.structures;

import com.bank.ca_2.model.Employee;

/**
 *
 * @author Gustavo
 */
public class EmployeeNode {

    private final Employee employee;

    private EmployeeNode left;
    private EmployeeNode right;

    public EmployeeNode(Employee employee) {

        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNode getLeft() {
        return left;
    }

    public void setLeft(EmployeeNode left) {
        this.left = left;
    }

    public EmployeeNode getRight() {
        return right;
    }

    public void setRight(EmployeeNode right) {
        this.right = right;
    }
}