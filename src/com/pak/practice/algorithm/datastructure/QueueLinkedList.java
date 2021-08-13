package com.pak.practice.algorithm.datastructure;

public class QueueLinkedList {
    Node front, rear;

    static class Node {
        final int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    boolean isEmpty() {
        return rear == null;
    }

    public QueueLinkedList() {
        this.front = this.rear = null;
    }

    void enqueue(int key) {
        Node newNode = new Node(key);
        if (isEmpty()) {
            rear = front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    void dequeue() {
        if (front != null) {
            front = front.next;

            if (front == null)
                rear = null;
        }
    }

    static void printList(Node front) {
        while (front != null) {
            System.out.print(front.key + " ");
            front = front.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        queueLinkedList.enqueue(50);
        queueLinkedList.enqueue(40);
        queueLinkedList.enqueue(30);
        queueLinkedList.enqueue(20);
        queueLinkedList.enqueue(10);
        queueLinkedList.dequeue();
        queueLinkedList.dequeue();
        printList(queueLinkedList.front);

    }
}
