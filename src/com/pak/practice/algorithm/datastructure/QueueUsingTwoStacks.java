package com.pak.practice.algorithm.datastructure;

import java.util.Stack;

public class QueueUsingTwoStacks {

    public static void main(String[] args){
        Stack<Object> stack1 = new Stack<>();
        Stack<Object> stack2 = new Stack<>();
        stack1.push('a');
        stack1.push('b');
        stack1.push('c');

        if(stack1.size() == 0){
                System.out.println("Empty");
            }
        while(stack1.size() > 0){
            Object p = stack1.pop();
            stack2.push(p);
        }
        System.out.println(stack2);
    }
}
