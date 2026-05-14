package com.bank.ca_2.structures;

import com.bank.ca_2.model.Employee;

/**
 * Node class used in the Employee Binary Tree.
 * 
 * Each node stores:
 * - One employee object
 * - Reference to the left child
 * - Reference to the right child
 * 
 * This structure is used to create the employee hierarchy tree for the 
 * organisation.
 * 
 * @author Gustavo
 */
public class EmployeeNode {

    private final Employee employee;
    private EmployeeNode left;
    private EmployeeNode right;

    /**
     * Constructor used to create a new tree node.
     * 
     * @param employee employee object stored in the node
     */
    public EmployeeNode(Employee employee) {

        this.employee = employee;
    }

    /**
     * Returns the employee stored in the node.
     * 
     * @return employee object
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Returns the left child node.
     * 
     * @return left node
     */
    public EmployeeNode getLeft() {
        return left;
    }

    /**
     * Sets the left child node.
     * 
     * @param left left node reference
     */
    public void setLeft(EmployeeNode left) {
        this.left = left;
    }

    /**
     * Returns the right child node.
     * 
     * @return right node
     */
    public EmployeeNode getRight() {
        return right;
    }

    /**
     * Sets the right child node.
     * 
     * @param right right node reference
     */
    public void setRight(EmployeeNode right) {
        this.right = right;
    }
}