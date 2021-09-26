package com.leetcode;

import java.util.Stack;

public class MyQueue232 {

    /** Initialize your data structure here. */
    private Stack<Integer> stackNormal;
    private Stack<Integer> stackReversed;

    public MyQueue232() {
        stackNormal = new Stack<>();
        stackReversed = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stackNormal.isEmpty()) {
            int res = stackNormal.pop();
            stackReversed.push(res);
        }
        stackReversed.push(x);

        while (!stackReversed.isEmpty()) {
            int res = stackReversed.pop();
            stackNormal.push(res);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stackNormal.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stackNormal.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackNormal.isEmpty();
    }

    public static void main(String[] args) {
        //["MyQueue","push","push","peek","pop","empty"]
        //[[],[1],[2],[],[],[]]

        MyQueue232 queue = new MyQueue232();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
