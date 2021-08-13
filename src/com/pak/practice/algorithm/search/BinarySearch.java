package com.pak.practice.algorithm.search;

/*
We basically ignore half of the elements just after one comparison.

Compare x with the middle element.
If x matches with middle element, we return the mid index.
Else If x is greater than the mid element, then x can only lie in right half subArray after the mid element. So we recur for right half.
Else (x is smaller) recur for the left half.
 */
public class BinarySearch {

    int binarySearch(int[] arr, int l, int r, int x) {
        if (r <= l) {
            return -1;
        }

        int middle = (l + r) / 2;
        if (arr[middle] == x) {
            return middle;
        } else if (x > arr[middle]) {
            return binarySearch(arr, middle + 1, r, x);
        } else return binarySearch(arr, l, middle - 1, x);
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;

        int n = arr.length;
        BinarySearch binarySearch = new BinarySearch();
        long startTime = System.nanoTime();
        int index = binarySearch.binarySearch(arr, 0, n - 1, 498);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        if (index == -1)
            System.out.println("Not Found!");
        else
            System.out.println("Found at: " + index + ". It took: " + duration + " seconds.");
    }
}
