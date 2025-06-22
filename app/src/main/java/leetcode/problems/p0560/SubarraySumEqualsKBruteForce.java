package leetcode.problems.p0560;

public class SubarraySumEqualsKBruteForce {

    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int window = 0; window < n; window++) {
            for (int i = 0; i < n - window; i++) {
                int sum = getSumBetween(nums, i, i + window);

                System.out.println("Window: " + window + ", i: " + i + ", Sum: " + sum);

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    int getSumBetween(int[] nums, int i, int j) {
        int sum = 0;
        for (int current = i; current <= j; current++) {
            sum += nums[current];
        }
        return sum;
    }

    public static void main(String[] args) {
        SubarraySumEqualsKBruteForce subarraySumEqualsKBruteForce = new SubarraySumEqualsKBruteForce();
        var result = subarraySumEqualsKBruteForce.subarraySum(new int[]{ 1, 2, 3 }, 3);

        System.out.println(result);
    }
}
