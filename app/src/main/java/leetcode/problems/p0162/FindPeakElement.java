package leetcode.problems.p0162;

class FindPeakElement {
    int solve(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement peakElement = new FindPeakElement();
        var answer = peakElement.solve(new int[] { 1, 2 });

        System.out.println(answer);
    }
}
