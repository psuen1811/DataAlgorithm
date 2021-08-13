package com.pak.practice.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSortLinkedList {
    Node head;

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    void addNode(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    void quickSort(Node start, Node end) {
        if (start != end) {
            Node pi = partition(start, end);
            quickSort(start, pi);
            quickSort(pi.next, end);
        }
    }

    Node partition(Node start, Node end) {
        if (start == end || start == null || end == null)
            return start;
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.val;

        while (start != end) {
            if (start.val < pivot) {
                pivot_prev = curr;
                int temp = curr.val;
                curr.val = start.val;
                start.val = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        int temp = curr.val;
        curr.val = pivot;
        end.val = temp;

        return pivot_prev;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        QuickSortLinkedList q = new QuickSortLinkedList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
            arrayList.add(i);
        Collections.shuffle(arrayList);
        for (int x : arrayList)
            q.addNode(x);
        printList(q.head);
        Node temp = q.head;
        while (temp.next != null)
            temp = temp.next;

        long startTime = System.nanoTime();
        q.quickSort(q.head, temp);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println();
        printList(q.head);
        System.out.println("\nIt takes " + duration);
    }
}
