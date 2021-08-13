package com.pak.practice.algorithm.linkedlist;

public class RemoveDuplicates {
    Node head;

    static class Node {
        final int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    void removeDuplicates() {
        Node prev = head;
        Node current = prev.next;
        while (prev.next != null) {
            if (prev.value == current.value) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = prev.next;
        }
        // return head;
    }

    static void printList(Node n) {
        while (n != null) {
            System.out.println(n.value + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates gn = new RemoveDuplicates();
        int[] arr = {1, 1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 6, 6, 7, 8};
        for (int i : arr)
            gn.push(i);
        //printList(gn.head);
        gn.removeDuplicates();
        printList(gn.head);
    }
}
