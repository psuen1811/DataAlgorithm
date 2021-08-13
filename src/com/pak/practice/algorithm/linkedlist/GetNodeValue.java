package com.pak.practice.algorithm.linkedlist;

public class GetNodeValue {
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

    int getNodeValue(int positionTail) {
        Node temp = head, front = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (size <= positionTail)
            return temp.value;
        else {
            for (int i = 0; i < (size - 1 - positionTail); i++)
                front = front.next;
        }
        return front.value;
    }

    static void printList(Node n) {
        while (n != null) {
            System.out.println(n.value + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        int tailPos = 3;
        GetNodeValue gn = new GetNodeValue();
        for (int i = 0; i < 10; i++)
            gn.push(i);
        int value = gn.getNodeValue(tailPos);
        printList(gn.head);
        System.out.println(value);
    }
}
