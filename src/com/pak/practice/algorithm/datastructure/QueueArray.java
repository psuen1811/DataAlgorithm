package com.pak.practice.algorithm.datastructure;

/*
Enqueue: Adds an item to the queue. If the queue is full, then it is said to be an Overflow condition.
Dequeue: Removes an item from the queue. The items are popped in the same order in which they are pushed. If the queue is empty, then it is said to be an Underflow condition.
Front: Get the front item from queue.
Rear: Get the last item from queue.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QueueArray {
    final int[] arr;
    int front, rear, size;
    final int capacity;

    QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = size = 0;
        rear = this.capacity - 1;
    }

    void dequeue() {
        if (!isEmpty()) {
            front = (front + 1) % capacity;
            size--;
        } else {
            System.out.println("Empty Queue");
        }
    }

    // Method to add an item to the queue.
    // It changes rear and size
    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else {
            rear = (rear + 1) % capacity;
            arr[rear] = x;
            size++;
            System.out.println(x + " enqueued to queue");
        }
    }

    int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return arr[front];
    }

    int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return arr[rear];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    static void printList(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arraySize = 10;
        QueueArray queueArray = new QueueArray(arraySize);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arraySize; i++)
            list.add(i);
        Collections.shuffle(list);

        for (int i : list)
            queueArray.enqueue(i);
        printList(queueArray.arr);
        System.out.println("Dequeue x 3");
        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.dequeue();
        System.out.println("Front:");
        System.out.println(queueArray.front());
        System.out.println("End:");
        System.out.println(queueArray.rear());
    }
}
