package com.pak.practice.algorithm.linkedlist;

import java.util.HashSet;

public class DetectCycle {
    Node head;

    static class Node {
        final int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    boolean hasCycle() {
        HashSet<Node> s = new HashSet<>();
        while (head != null) {
            if (s.contains(head))
                return true;
            s.add(head);
            head = head.next;
        }
        return false;
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        int size = 10;
        DetectCycle dc = new DetectCycle();
        for (int i = 0; i < size; i++)
            dc.push(i);

        dc.head.next.next.next.next.next = dc.head;

        if (dc.hasCycle())
            System.out.println("True");
        else
            System.out.println("False");
    }
}
