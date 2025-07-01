package leetcode.problems.p0232;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> empty;
    private Stack<Integer> queue;

    public ImplementQueueUsingStacks() {
        empty = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int x) {
        while (!queue.isEmpty()) {
            empty.push(queue.pop());
        }

        empty.push(x);

        while (!empty.isEmpty()) {
            queue.push(empty.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
