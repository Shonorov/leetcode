package com.company.challange;

import java.util.LinkedList;
import java.util.List;

/**
 * Min Stack
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3292/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *
 * Explanation:
 * Each node in the stack having a minimum value.
 *
 * Time complexity : O(1).
 * Space complexity : O(n * 2).
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top()); // 0
        System.out.println(minStack.getMin()); // -2
    }

    private List<int[]> stack;

    /** initialize your data structure here. */
    private MinStack() {
        stack = new LinkedList<>();
    }

    private void push(int x) {
        int[] element = {x, x};
        if (stack.size() > 0 && element[1] > stack.get(stack.size() - 1)[1] ) {
            element[1] = stack.get(stack.size() - 1)[1];
        }
        stack.add(element);
    }

    private void pop() {
        stack.remove(stack.get(stack.size() - 1));
    }

    private int top() {
        return stack.get(stack.size() - 1)[0];
    }

    private int getMin() {
        return stack.get(stack.size() - 1)[1];
    }
}
