package com.pak.practice.algorithm.linkedlist;

public class DeleteNode {
    Node head;

    static class Node {
        final int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    void deleteNodeByValue(int value) {
        Node temp = head, prevNode = null;
        if (temp != null && temp.value == value)
            head = temp.next;
        else {
            while (temp != null && temp.value != value) {
                prevNode = temp;
                temp = temp.next;
            }
            if (temp != null)
                prevNode.next = temp.next;
        }
    }

    void deleteNodeByPos(int position) {
        Node temp = head, prevNode = null;
        if (position == 0) {
            head = temp.next;
        } else {
            while (position != 0) {
                prevNode = temp;
                temp = temp.next;
                position--;
            }
            prevNode.next = temp.next;
        }
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    static void printList(Node node) {
        while (node.next != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int position = 3;
        int deleteNode = 8;
        DeleteNode d = new DeleteNode();
        for (int i = 0; i < 10; i++) {
            d.push(i);
        }
        printList(d.head);
        d.deleteNodeByPos(position);
        printList(d.head);
        d.deleteNodeByValue(deleteNode);
        printList(d.head);
    }
}
