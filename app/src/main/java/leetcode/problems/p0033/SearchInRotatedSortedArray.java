package leetcode.problems.p0033;

class SearchInRotatedSortedArray {
    int solve(int[] nums, int target) {
        int pivot = findPivot(nums);
        int n = nums.length - 1;

        if (target > nums[n]) {
            // Pivot has right sorted array from [pivot,...,n]
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            // Pivot has left sorted array from [0,...,pivot-1]
            return binarySearch(nums, target, pivot, n);
        }
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        var answer = search.solve(new int[] { 1, 3 }, 3);

        System.out.println(answer);
    }
}
