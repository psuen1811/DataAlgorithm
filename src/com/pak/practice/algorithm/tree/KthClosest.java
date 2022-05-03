package com.pak.practice.algorithm.tree;

import java.util.*;

public class KthClosest {

    List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, h = arr.length - k, m;
        while (l < h) {
            m = l + (h - 1) / 2;
            if( x - arr[m] > arr[m+k] - x ) l = m + 1;
            else h = m;
        }
        List<Integer> intList = new ArrayList<>(k);
        for (int i = l; i < k + l; i++)
        {
            intList.add(arr[i]);
        }
        return intList;
/*
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> {
            if (Math.abs(b - x) == Math.abs(a - x)) {
                return b - a;
            }
            return Math.abs(b - x) - Math.abs(a - x);
        });
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<Integer>(maxHeap);
        Collections.sort(result);
        return result;
    }

     */
    }

    public static void main(String[] args) {
        KthClosest kthClosest = new KthClosest();
        int[] arr = {1,2,3,4,5};
        System.out.println(kthClosest.findClosestElements(arr, 3, 4));
    }
}
