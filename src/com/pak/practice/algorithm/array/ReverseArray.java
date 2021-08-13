package com.pak.practice.algorithm.array;

import java.util.Arrays;

public class ReverseArray {
    private int[] arr;
    private int index;

    public ReverseArray(int size) {
        arr = new int[size];
        this.index = 0;
    }

    void push(int value) {
        arr[index++] = value;
    }

    void reserveArray() {
        int n = arr.length;
        int[] arr2 = new int[n];
        int j = n;
        for (int k : arr) {
            arr2[j - 1] = k;
            j--;
        }
        arr = arr2;
    }

    void printList() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arraySize = 10;
        ReverseArray r = new ReverseArray(arraySize);
        for (int i = 0; i < arraySize; i++)
            r.push(i);
        r.reserveArray();
        r.printList();
    }

}
