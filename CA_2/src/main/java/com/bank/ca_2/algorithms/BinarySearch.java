package com.bank.ca_2.algorithms.searching;

import java.util.List;

/**
 *
 * @author Gustavo
 */
public class BinarySearch {

    /**
     * Recursive binary search method.
     *
     * @param list sorted list
     * @param left left index
     * @param right right index
     * @param target name to search
     * @return index if found, otherwise -1
     */
    public static int binarySearch(List<String> list, int left, int right,
                                   String target) {

        // Base case: element not found
        if (left > right) {
            return -1;
        }

        // Find middle index
        int mid = left + (right - left) / 2;

        // Check if middle element is target
        if (list.get(mid).equalsIgnoreCase(target)) {
            return mid;
        }

        // Search left half
        if (target.compareToIgnoreCase(list.get(mid)) < 0) {
            return binarySearch(
                    list,
                    left,
                    mid - 1,
                    target
            );
        }

        // Search right half
        return binarySearch(
                list,
                mid + 1,
                right,
                target
        );
    }
}