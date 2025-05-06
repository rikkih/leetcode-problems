package leetcode.problems.p0852;

class PeakIndexInMountainArray {
    int solve(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray peak = new PeakIndexInMountainArray();

        var answer = peak.solve(new int[] { 3, 5, 3, 2, 0 });
        System.err.println(answer);
    }
}
