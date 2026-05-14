package com.bank.ca_2.structures;

/**
 * Custom queue implementation used for Binary Tree level-order operations.
 * 
 * This queue stores EmployeeNode objects and is implemented using a circular 
 * array.
 * 
 * The queue is mainly used for:
 * - Level-order insertion
 * - Level-order traversal
 * 
 * @author Gustavo
 */
public class EmployeeQueue {
    private final EmployeeNode[] arr;
    // Index of the front element
    private int front;
    // Index of the rear element
    private int rear;
    // Maximum queue capacity
    private final int capacity;

    /**
     * Constructor used to initialize queue size.
     * 
     * @param capacity maximum queue size
     */
    public EmployeeQueue(int capacity) {

        this.capacity = capacity;

        // Create queue array
        arr = new EmployeeNode[capacity];

        // Queue initially empty
        front = -1;
        rear = -1;
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if queue is empty
     */
    public boolean isEmpty() {

        return front == -1;
    }

    /**
     * Checks if the queue is full.
     * 
     * Uses circular queue logic.
     * 
     * @return true if queue is full
     */
    public boolean isFull() {

        return (rear + 1) % capacity == front;
    }

    /**
     * Adds a new node to the queue.
     * 
     * @param node node to insert
     */
    public void enqueue(EmployeeNode node) {

        // Prevent insertion if queue is full
        if (isFull()) {

            System.out.println("Queue is full!");
            return;
        }

        // First element insertion
        if (isEmpty()) {

            front = rear = 0;

        } else {

            // Circular increment
            rear = (rear + 1) % capacity;
        }

        // Insert node
        arr[rear] = node;
    }

    /**
     * Removes and returns the front node
     * from the queue.
     * 
     * @return removed node or null if empty
     */
    public EmployeeNode dequeue() {

        // Queue empty validation
        if (isEmpty()) {
            return null;
        }

        // Store front element
        EmployeeNode temp = arr[front];

        // Last element removed
        if (front == rear) {

            front = rear = -1;

        } else {

            // Circular increment
            front = (front + 1) % capacity;
        }

        return temp;
    }
}