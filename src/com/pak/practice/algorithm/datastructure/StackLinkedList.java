package com.pak.practice.algorithm.datastructure;

/*
Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.
Peek or Top: Returns top element of stack.
isEmpty: Returns true if stack is empty, else false.
 */
public class StackLinkedList {

    Node head;

    static class Node {
        final int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Empty List");
        } else {
            head = head.next;
        }
    }

    int peek() {
        int peek = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("Empty List");
            return peek;
        } else {
            peek = head.val;
        }
        return peek;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        int[] arr = {10, 2, 3, 5, 60, 19};
        for (int x : arr) {
            stackLinkedList.push(x);
        }
        System.out.println("Pop it");
        stackLinkedList.pop();
        printList(stackLinkedList.head);
        System.out.println("Push 19");
        stackLinkedList.push(19);
        printList(stackLinkedList.head);
        System.out.println("Peek it");
        System.out.println(stackLinkedList.peek());
        System.out.println("Pop x 3");
        stackLinkedList.pop();
        stackLinkedList.pop();
        stackLinkedList.pop();
        printList(stackLinkedList.head);
    }
}
