package com.bank.ca_2.structures;

/**
 *
 * @author Gustavo
 */
public class EmployeeQueue {
    private final EmployeeNode[] arr;

    private int front;
    private int rear;

    private final int capacity;

    public EmployeeQueue(int capacity) {

        this.capacity = capacity;

        arr = new EmployeeNode[capacity];

        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {

        return (rear + 1) % capacity == front;
    }

    public void enqueue(EmployeeNode node) {

        if (isFull()) {

            System.out.println("Queue is full!");
            return;
        }

        if (isEmpty()) {

            front = rear = 0;

        } else {

            rear = (rear + 1) % capacity;
        }

        arr[rear] = node;
    }

    public EmployeeNode dequeue() {

        if (isEmpty()) {
            return null;
        }

        EmployeeNode temp = arr[front];

        // Last element removed
        if (front == rear) {

            front = rear = -1;

        } else {

            front = (front + 1) % capacity;
        }

        return temp;
    }
}