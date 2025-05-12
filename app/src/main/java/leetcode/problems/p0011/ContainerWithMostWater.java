package leetcode.problems.p0011;

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
