package com.pak.practice.algorithm.datastructure;

import java.util.Stack;

public class BalancedBrackets {

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for( char c : s.toCharArray() ) {
            switch(c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if( stack.empty() || (stack.peek() != '{') )
                        return "NO";
                    stack.pop();
                    break;
                case ']':
                    if( stack.empty() || (stack.peek() != '[') )
                        return "NO";
                    stack.pop();
                    break;
                case ')':
                    if( stack.empty() || (stack.peek() != '(') )
                        return "NO";
                    stack.pop();
                    break;
            }
        }
        return stack.empty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        String[] input = {"{[()]}", "{[(])}", "{{[[(())]]}}"};
        for( String s : input )
            System.out.println(isBalanced(s));
    }
}
