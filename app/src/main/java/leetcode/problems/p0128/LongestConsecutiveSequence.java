package leetcode.problems.p0128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();

        // O( n*log(n) )
        for (int num : nums) {
            if (seen.contains(num)) continue;
            minHeap.offer(num);
            seen.add(num);
        }

        int currentCount = 1;
        int globalCount = 1;
        int current = minHeap.poll();

        // O(n)
        while (!minHeap.isEmpty()) {
            int next = minHeap.poll();
            if (next - current == 1) {
                globalCount = Math.max(++currentCount, globalCount);
            } else {
                currentCount = 1;
            }
            current = next;
        }

        // O(n) + O(n*logn) = O(n*logn)
        return globalCount;
    }

    int longestConsecutive2(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 1;

        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int longest = 1;
                int current = num + 1;

                while (numSet.contains(current)) {
                    max = Math.max(++longest, max);
                    current += 1;
                }
            }
        }
        return max;
    }
}
