package leetcode.problems.p0347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKFrequentElements {
    int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = getFrequencies(nums);

        List<Integer> topKElements = getTopKEntries(frequencies, k);
        return topKElements.stream().mapToInt(Integer::intValue).toArray();
    }

    private <T> List<T> getTopKEntries(Map<T, Integer> frequencies, int k) {
        Queue<Map.Entry<T, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<T, Integer> entry : frequencies.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<T> topKElements = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topKElements.add(minHeap.poll().getKey());
        }

        return topKElements;
    }

    private Map<Integer, Integer> getFrequencies(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }
        return frequencies;
    }
}
