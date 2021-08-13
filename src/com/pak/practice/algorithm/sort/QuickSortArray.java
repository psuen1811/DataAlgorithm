package com.pak.practice.algorithm.sort;

// Quick Sort in its general form is an in-place sort so it doesn't require extra storage like Merge Sort (O(N)) for Array
// Time O(NlogN)
// Space O(logN)
// Worst Space O(N) quickSort
// Worst Space O(logN) quickSort2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class QuickSortArray {

    int partition(int[] arr, int low, int high) {

        // Pick the last element as pivot
        int pivot = arr[high];

        // Initial i to keep track on position
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // If smaller, swap, otherwise don't do anything
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // At the end, swap the last two element including the pivot
        swap(arr, i + 1, high);
        return i + 1;
    }

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // divide and conquer by partitioning the array
            int pi = partition(arr, low, high);

            // setting left side elements which are smaller than pivot
            quickSort(arr, low, pi - 1);
            // setting right side elements which are bigger than pivot
            quickSort(arr, pi + 1, high);
        }
    }

    static void printList(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
            list.add(i);
        Collections.shuffle(list);
        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list)
            arr[i++] = num;

        int n = arr.length;
        System.out.println("Given Array");
        printList(arr);

        QuickSortArray q = new QuickSortArray();
        long startTime = System.nanoTime();
        q.quickSort(arr, 0, n - 1);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("\nSorted Array  ");
        printList(arr);
        System.out.println("\nTime: " + duration);
    }
}

