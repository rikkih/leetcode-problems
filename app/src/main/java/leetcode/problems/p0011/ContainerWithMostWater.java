package leetcode.problems.p0011;

/**
 * The intuition behind this is to use a two pointer approach. Each pointer
 * starts at one end of the heights array. For each iteration, update the
 * greatest height with the height of the current box defined by the current
 * pointer values. Whichever height is the lowest, we move that pointer across.
 * To see why, imagine that heights[right] < heights[left]. This means that for
 * every left < right where heights[left] > heights[right], this is the greatest
 * area for this right since the width is the greatest here.
 */
class ContainerWithMostWater {
    int solve(int[] height) {
        int greatestArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int lowestHeight = Math.min(height[left], height[right]);
            int currentArea = lowestHeight * (right - left);
            greatestArea = Math.max(greatestArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return greatestArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        var answer = containerWithMostWater.solve(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(answer);
    }
}
