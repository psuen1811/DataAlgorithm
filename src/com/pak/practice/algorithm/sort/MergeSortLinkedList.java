package com.pak.practice.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
MergeSort(headRef)
1) If the head is NULL or there is only one element in the Linked List
    then return.
2) Else divide the linked list into two halves.
      FrontBackSplit(head, &a, &b); // a and b are two halves
3) Sort the two halves a and b.
        MergeSort(a);
        MergeSort(b);
        4) Merge the sorted a and b (using SortedMerge() discussed here)
        and update the head pointer using headRef.
        *headRef = SortedMerge(a, b);

Space: O(logN)
Avg Time: O(NlogN)

 */
public class MergeSortLinkedList {
    Node head;

    static class Node {
        final int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node mergeSort(Node left, Node right) {
        Node result;
        if( left == null )
            return right;
        if( right == null )
            return left;

        // Pick either left or right and recur
        if( left.val <= right.val ) {
            result = left;
            result.next = mergeSort(left.next, right);
        } else {
            result = right;
            result.next = mergeSort(left, right.next);
        }

        return result;
    }

    Node mergeSort(Node head) {
        if( head == null || head.next == null )
            return head;

        // Get the middle of the list
        Node middle = getMiddle(head);
        // Set next of middle
        Node nextOfMiddle = middle.next;

        // Set the next of middle node to null
        middle.next = null;

        // Apply merge sort on left list
        Node left = mergeSort(head);
        // Apply merge sort of right list
        Node right = mergeSort(nextOfMiddle);

        // Merge left and right list
        return mergeSort(left, right);
    }

    // Utility function to get the middle of the linked list
    Node getMiddle(Node head) {
        Node slow = head, fast = head;
        if( head == null )
            return null;
        while ( fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    static void printList(Node headRef) {
        while (headRef.next != null) {
            System.out.print(headRef.val + " ");
            headRef = headRef.next;
        }
    }

    public static void main(String[] args) {

        MergeSortLinkedList li = new MergeSortLinkedList();
        /*
         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            list.add(i);
        Collections.shuffle(list);

        for (int i : list) {
            li.push(i);
        }

        System.out.println("Given Array");
        printList(li.head);

        // Apply merge Sort
        long startTime = System.nanoTime();
        li.head = li.mergeSort(li.head);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("\nSorted Linked List");
        printList(li.head);
        System.out.println("\nTime: " + duration);
    }
}