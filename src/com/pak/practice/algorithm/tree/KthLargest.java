package com.pak.practice.algorithm.tree;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for( int i : nums )
            pq.offer(i);
        if( pq.size() > k ) pq.poll();
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {4,5,8,2}; // 8,5,4,2 -> 8,5,4 -> 8,5,5 -> 10,8,5 -> 10,9,8 -> 10,9,8
        int key = 3;
        KthLargest kthLargest = new KthLargest(key, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
