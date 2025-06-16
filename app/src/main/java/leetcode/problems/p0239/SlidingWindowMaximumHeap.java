package leetcode.problems.p0239;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximumHeap {

    record Pair(int index, int value) {
    }

    /**
     * For each iteration, we can check if we're at window size. If we are, peek
     * the heap root element, add it to the list of maximums.
     *
     * nums = { 1, 3, -1, -3, 5, 3, 6, 7 }
     * k = 3
     *
     * result = { 3, 3, 5, 5, 6, 7 }
     * @param nums
     * @param k
     * @return
     */
    int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Pair> comparator = Comparator.comparing(Pair::value).reversed();
        PriorityQueue<Pair> maxHeap = new PriorityQueue(comparator);

        int n = nums.length;
        int[] maximums = new int[n - k + 1];

        for (int i = 0; i < n; i ++) {
            // Add to heap.
            maxHeap.offer(new Pair(i, nums[i]));

            // We can just remove the top elements whose index falls outside the window.
            // We don't actually care about anything else.
            while (maxHeap.peek().index <= i - k) {
                maxHeap.poll();
            }

            // Start adding to maximums when the window is of sufficient length
            if (i >= k - 1) {
                maximums[i - k + 1] = maxHeap.peek().value;
            }
        }

        return maximums;
    }

    public static void main(String[] args) {
        SlidingWindowMaximumHeap slidingWindowMaximumHeap = new SlidingWindowMaximumHeap();

        var result = slidingWindowMaximumHeap.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);

        System.out.println(result);
    }
}
