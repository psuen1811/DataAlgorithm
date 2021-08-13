package com.pak.practice.algorithm.linkedlist;

import java.util.Stack;

public class ReversePrint {
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

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
    }

    @SuppressWarnings("unchecked")
    void reversePrint() {
        Node temp = head;
        @SuppressWarnings("rawtypes") Stack<Integer> stack = new Stack();
        while (temp != null) {
            stack.push(temp.value);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().toString() + " ");
        }
    }

    public static void main(String[] args) {
        int size = 10;
        ReversePrint rp = new ReversePrint();
        for (int i = 0; i < size; i++) {
            rp.push(i);
        }
        printList(rp.head);
        System.out.println();
        rp.reversePrint();

        /*
        int j = 1230;
        int k = 0;
        while (j > 0) {
            k = 10 * k + j % 10;
            j = j / 10;
        }
        System.out.println(k);

         */
    }
}
