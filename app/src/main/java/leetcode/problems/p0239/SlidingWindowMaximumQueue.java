package leetcode.problems.p0239;

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximumQueue {

    int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque deque = new ArrayDeque();

        int[] maximums = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            // Remove indices out of the current window

            // Remove smaller values from the back

            // Add current index

            // Add max to result once the first window is complete

        }
        return new int[] {0};

    }

    public static void main(String[] args) {
        SlidingWindowMaximumQueue windowMaximumQueue = new SlidingWindowMaximumQueue();


    }
}
