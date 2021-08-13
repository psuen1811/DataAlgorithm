package com.pak.practice.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSortArrayList {

    int partition(ArrayList<Integer> arrayList, int l, int h) {
        int pivot = arrayList.get(h);

        int low = l - 1;
        for (int j = l; j < h; j++) {
            if (arrayList.get(j) < pivot)
                Collections.swap(arrayList, ++low, j);
        }
        Collections.swap(arrayList, low + 1, h);
        return low + 1; 
    }

    void quickSort(ArrayList<Integer> arrayList, int l, int h) {
        if (l < h) {
            int pi = partition(arrayList, l, h);
            quickSort(arrayList, l, pi - 1);
            quickSort(arrayList, pi + 1, h);
        }
    }

    static void printList(ArrayList<Integer> arrayList) {
        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        QuickSortArrayList q = new QuickSortArrayList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            arrayList.add(i);
        Collections.shuffle(arrayList);
        printList(arrayList);

        q.quickSort(arrayList, 0, arrayList.size() - 1);
        printList(arrayList);

    }
}
