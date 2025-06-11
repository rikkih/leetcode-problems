package leetcode.problems.p0215;

import java.util.PriorityQueue;

/**
 * There problem asks for you to not sort the list. If so, that would be an O(n logn)
 * solution. Using Quicksort or MergeSort.
 *
 * Instead, a more intelligent way to approach this problem is to keep track of a min
 * heap.
 *
 * For each element in the list, we add it to the min heap.
 *
 * If the heap grows larger than size K, we can just poll the heap, removing the
 * smallest element.
 *
 * If we ensure the heap never gets past size K, we will end up with the root node of
 * the min heap being the Kth largest element.
 *
 * This works because every element after the root node is larger than this node, as
 * required by the definition of a min heap. In other words, this is the kth largest value.
 */
class KthLargestElementInArray {

    int solve(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;

        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();

        var result = kthLargestElementInArray.solve(nums, k);
        System.out.println(result);
    }
}
