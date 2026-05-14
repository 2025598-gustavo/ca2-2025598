package com.bank.ca_2.algorithms.sorting;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public class MergeSort {

    /**
     * Recursive merge sort method.
     *
     * @param names list of names
     * @param left left index
     * @param right right index
     */
    public static void mergeSort(List<String> names, int left, int right) {

        // Base case
        if (left < right) {

            // Find middle index
            int mid = (left + right) / 2;

            // Sort left half
            mergeSort(names, left, mid);

            // Sort right half
            mergeSort(names, mid + 1, right);

            // Merge sorted halves
            merge(names, left, mid, right);
        }
    }

    /**
     * Merges two sorted halves.
     *
     * @param names list of names
     * @param left left index
     * @param mid middle index
     * @param right right index
     */
    public static void merge(List<String> names, int left, int mid, int right) {

        // Calculate sizes
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        // Copy data to left array
        for (int i = 0; i < n1; i++) {
            leftArray[i] = names.get(left + i);
        }

        // Copy data to right array
        for (int j = 0; j < n2; j++) {
            rightArray[j] = names.get(mid + 1 + j);
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge arrays alphabetically
        while (i < n1 && j < n2) {
            if (leftArray[i].compareToIgnoreCase(rightArray[j]) <= 0) {
                names.set(k, leftArray[i]);
                i++;
            } else {
                names.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        // Remaining elements from left array
        while (i < n1) {
            names.set(k, leftArray[i]);
            i++;
            k++;
        }

        // Remaining elements from right array
        while (j < n2) {
            names.set(k, rightArray[j]);
            j++;
            k++;
        }
    }
}