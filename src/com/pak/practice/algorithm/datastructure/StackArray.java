package com.pak.practice.algorithm.datastructure;

/*
Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.
Peek or Top: Returns top element of stack.
isEmpty: Returns true if stack is empty, else false.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StackArray {

    static final int MAX_NUM = 12;
    int top;
    final int[] arr = new int[MAX_NUM];

    boolean isEmpty() {
        return top < 0;
    }

    StackArray() {
        top = -1;
    }

    void push(int x) {
        if (top > MAX_NUM) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = x;
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            // return 0;
        } else {
            top--;
            // return arr[top--];
        }
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return arr[top];
        }
    }

    static void printList(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        StackArray stackArray = new StackArray();

        for (int x : list) {
            stackArray.push(x);
        }

        printList(stackArray.arr);

        System.out.println("\nPush 49, 28");
        stackArray.push(49);
        stackArray.push(28);
        printList(stackArray.arr);
        System.out.println("\nPop it");
        stackArray.pop();
        printList(stackArray.arr);
        System.out.println("\nReturn top");
        System.out.println(stackArray.peek());
        System.out.println("Pop x 3");
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        System.out.println(stackArray.peek());
    }

}
