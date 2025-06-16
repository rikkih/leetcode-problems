package leetcode.problems.p0239;

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximumDequeue {

    int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque();

        int[] maximums = new int[n - k + 1];
        int resultIndexTracker = 0;

        for (int i = 0; i < n; i++) {
            // Remove back value while they are smaller than current.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            // Remove front if it's out of the window.
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // Add current index
            deque.offerLast(i);

            // Add max to result once the first window is complete
            if (i >= k - 1) {
                maximums[resultIndexTracker++] = deque.peekFirst();
            }

        }
        return maximums;

    }

    public static void main(String[] args) {
        SlidingWindowMaximumDequeue windowMaximumQueue = new SlidingWindowMaximumDequeue();

        int[] nums = new int[]{ 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        var result = windowMaximumQueue.maxSlidingWindow(nums, k);

        System.out.println(result);
    }
}
