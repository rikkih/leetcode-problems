package leetcode.problems.p1574;

class ShortestSubarrayToRemove {
    int solve(int[] arr) {
        int n = arr.length;

        // 1. Find the leftmost non-decreasing subarray.
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) {
            return 0;
        }

        // 2. Find the rightmost non-decreasing subarray.
        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // 3. Set the first possible solution to shortest sub array length.
        int shortestLength = Math.min(n - left - 1, right);

        // 4. Use Binary Search to try and merge [0,...,i] with [j,...,n-1] for each i.
        // The loop ends when l == r, and l is the first index where arr[l] >= arr[i],
        // or l == n if no such index exists.
        for (int i = 0; i <= left; i++) {

            int l = right, r = n;
            while (l < r) {
                int mid = (l + r) / 2;

                if (arr[i] <= arr[mid]) {
                    r = mid; // Potential candidate found — search left to find first such index
                } else {
                    l = mid + 1; // Too small, so search exclusive right hand side.
                }
            }

            // Check if the merge is the minimum
            // l came from binary search. If we didn't find a valid index, it "falls off the
            // end" and equals n.
            if (l < n) {
                shortestLength = Math.min(shortestLength, l - i - 1);
            }
        }
        return shortestLength;
    }

    public static void main(String[] args) {
        ShortestSubarrayToRemove shortest = new ShortestSubarrayToRemove();

        var answer = shortest.solve(new int[] { 1, 2, 3 });
        System.out.println(answer);
    }
}
