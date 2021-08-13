package com.pak.practice.algorithm.linkedlist;

public class CompareLinkedLists {
    Node head;

    static class Node {
        final int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    static boolean compareLists(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        while (a != null && b != null && a.value == b.value) {
            a = a.next;
            b = b.next;
        }

        // if the list are different in size
        if (a != null && b != null) {
            return (a.value > b.value ? false : false);
        }
        return (a == null && b == null);
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        CompareLinkedLists cl = new CompareLinkedLists();
        CompareLinkedLists cl2 = new CompareLinkedLists();
        for (int i = 0; i < 10; i++) {
            cl.push(i);
            cl2.push(i);
        }
        if (compareLists(cl.head, cl2.head))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
