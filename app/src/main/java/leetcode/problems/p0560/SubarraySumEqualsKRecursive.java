package leetcode.problems.p0560;

class SubarraySumEqualsKRecursive {

    private class Counter {
        private int value;

        int getValue() {
            return value;
        }

        void increment() {
            value++;
        }
    }

    int subarraySum(int[] nums, int k) {
        Counter counter = new Counter();
        for (int i = 0; i < nums.length; i++) {
            recursive(i, 0, counter, nums, k);
        }
        return counter.getValue();
    }

    private void recursive(int index, int currentSum, Counter counter, int[] nums, int k) {
        if (index >= nums.length) return;

        currentSum += nums[index];
        if (currentSum == k) counter.increment();

        recursive(index + 1, currentSum, counter, nums, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1, 2, 3 };
        int k = 3;

        SubarraySumEqualsKRecursive subarraySumEqualsK = new SubarraySumEqualsKRecursive();
        var result = subarraySumEqualsK.subarraySum(nums, k);

        System.out.println(result);
    }
}
