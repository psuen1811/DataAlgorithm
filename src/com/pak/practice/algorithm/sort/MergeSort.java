package com.pak.practice.algorithm.sort;

// O(N) Space
// O(NlogN) Time
// Good for Linked List, not for Array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {

    void merge(int[] arr, int l, int m, int r) {

        // Find sizes of two subArrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp array
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        /*
        for(int i = 0; i < n1; i++)
            L[i] = arr[i + l];
        for(int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
         */

        // Merge the temp arrays

        // Initial indexes of first and second subArrays
        int i = 0, j = 0;

        // Initial index of merged subArrays
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining element of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void printList(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            list.add(i);
        Collections.shuffle(list);
        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list)
            arr[i++] = num;

        System.out.println("Given Array");
        printList(arr);

        MergeSort m = new MergeSort();
        long startTime = System.nanoTime();
        m.mergeSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("\nSorted Array");
        printList(arr);
        System.out.println("Time: " + duration);
    }
}
