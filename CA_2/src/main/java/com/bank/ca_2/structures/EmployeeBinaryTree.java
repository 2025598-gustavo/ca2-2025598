package com.bank.ca_2.structures;

import com.bank.ca_2.model.Employee;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Gustavo
 */
public class EmployeeBinaryTree {

    private EmployeeNode root;

    public EmployeeNode getRoot() {
        return root;
    }

    // Level order insertion
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

    // Level order traversal
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        ArrayList<EmployeeNode> queue = new ArrayList<>();
        queue.add(root);
        int level = 0;

        System.out.println("\n===== EMPLOYEE HIERARCHY =====\n");

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("Level " + level + ":");

            for (int i = 0; i < size; i++) {
                EmployeeNode current = queue.remove(0);
                Employee e = current.getEmployee();
                System.out.printf("  [%s] - %s - %s%n", e.getFullName(), 
                        e.getManagerType(), e.getDepartment());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null){
                    queue.add(current.getRight());
                }
            }
            level++; //increase lever after displays every node in the line
        }
    }

    public int countNodes(EmployeeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

    public int getHeight(EmployeeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
