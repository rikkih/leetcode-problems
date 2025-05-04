package leetcode.problems.p0035;

class SearchInsertPosition {
    int solve(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        var answer = searchInsertPosition.solve(new int[] { 1, 4, 8, 11 }, 9);

        System.out.println(answer);
    }
}
