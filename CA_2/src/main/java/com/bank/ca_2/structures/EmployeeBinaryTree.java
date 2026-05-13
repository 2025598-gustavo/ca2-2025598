package com.bank.ca_2.structures;

import com.bank.ca_2.model.Employee;

/**
 *
 * @author Gustavo
 */
public class EmployeeBinaryTree {

    private EmployeeNode root;

    public EmployeeNode getRoot() {
        return root;
    }

    // =========================================
    // LEVEL ORDER INSERTION
    // =========================================

    public void insert(Employee employee) {
        EmployeeNode newNode = new EmployeeNode(employee);

        // First node becomes root
        if (root == null) {
            root = newNode;
            return;
        }

        int totalNodes = countNodes(root);

        EmployeeQueue queue = new EmployeeQueue(totalNodes + 1);

        queue.enqueue(root);

        while (!queue.isEmpty()) {
            EmployeeNode current = queue.dequeue();

            // LEFT
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            } else {
                queue.enqueue(current.getLeft());
            }

            // RIGHT
            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            } else {
                queue.enqueue(current.getRight());
            }
        }
    }

    // =========================================
    // LEVEL ORDER TRAVERSAL
    // =========================================

    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        int totalNodes = countNodes(root);

        EmployeeQueue queue = new EmployeeQueue(totalNodes);

        queue.enqueue(root);

        System.out.println("\n===== EMPLOYEE HIERARCHY =====");

        while (!queue.isEmpty()) {
            EmployeeNode current = queue.dequeue();

            System.out.println(current.getEmployee());

            if (current.getLeft() != null) {
                queue.enqueue(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.enqueue(current.getRight());
            }
        }
    }

    // =========================================
    // COUNT NODES
    // =========================================

    public int countNodes(EmployeeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

    // =========================================
    // TREE HEIGHT
    // =========================================

    public int getHeight(EmployeeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }
}