package leetcode.problems.p1574;

class ShortestSubarrayToRemove {
    int solve(int[] arr) {
        if (arr.length < 2) {
            return arr[0];
        }

        int shortestLength = 0;
        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while (leftPointer < arr.length - 1 && arr[leftPointer] <= arr[leftPointer + 1]) {
            leftPointer++;
        }

        while (rightPointer > 0 && arr[rightPointer] >= arr[rightPointer - 1]) {
            rightPointer--;
        }

        if (leftPointer >= rightPointer) {
            return shortestLength;
        }

        int left = 0;
        int right = leftPointer;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= arr[rightPointer]) {
                shortestLength = (rightPointer - 1) - mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return shortestLength;
    }

    public static void main(String[] args) {
        ShortestSubarrayToRemove shortest = new ShortestSubarrayToRemove();

        var answer = shortest.solve(new int[] { 5, 4, 3, 2, 1 });
        System.out.println(answer);
    }
}
