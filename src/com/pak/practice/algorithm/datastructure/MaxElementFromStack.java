package com.pak.practice.algorithm.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class MaxElementFromStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        Stack<StackNode> stackNodeStack = new Stack<>();

        while( n > 0 ) {
            int choice = sc.nextInt();
            if( choice == 1 ) {
                int val = sc.nextInt();
                max = Math.max(val, max);
                stackNodeStack.add(new StackNode(val, max));
            } else if (choice == 2) {
                if( !stackNodeStack.empty() )
                    stackNodeStack.pop();
                if( stackNodeStack.empty() )
                    max = Integer.MIN_VALUE;
                else
                    max = stackNodeStack.peek().curMax;
            } else if (choice == 3 )
                if (!stackNodeStack.empty())
                    System.out.println(stackNodeStack.peek().curMax);
                else { n--; }
        }
        sc.close();
    }

    private static class StackNode {
        int value;
        int curMax;

        public StackNode(int value, int curMax) {
            this.value = value;
            this.curMax = curMax;
        }

        public String toString() {
            return value + " [" + curMax + "]";
        }
    }
}
