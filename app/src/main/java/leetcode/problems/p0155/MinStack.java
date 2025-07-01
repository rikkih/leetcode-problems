package leetcode.problems.p0155;

import java.util.Stack;

class MinStack {

    Stack<Integer> values;
    Stack<Integer> minimums;

    public MinStack() {
        values = new Stack<>();
        minimums = new Stack<>();
    }

    public void push(int val) {
        values.push(val);
        if (minimums.isEmpty() || val <= minimums.peek()) {
            minimums.push(val);
        }
    }

    public void pop() {
        if (values.peek().equals(minimums.peek())) {
            minimums.pop();
        }
        values.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}
