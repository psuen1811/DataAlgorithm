package com.pak.practice.algorithm.linkedlist;

public class ReverseLinkedListIteratively {
    Node head;

    static class Node {
        final int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    void reverseLinkedList() {
        Node current = head, prev = null, next;
        while( current != null ) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedListIteratively rl = new ReverseLinkedListIteratively();
        int[] arr = {10, 20, 30, 40, 60, 80, 100};
        for (int i : arr)
            rl.push(i);
        printList(rl.head);
        rl.reverseLinkedList();
        printList(rl.head);
    }
}
