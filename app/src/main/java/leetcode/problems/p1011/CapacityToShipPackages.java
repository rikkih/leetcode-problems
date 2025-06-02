package leetcode.problems.p1011;

import java.util.Arrays;

/**
 * This problem wants us to find the least weight capacity of the ship that will
 * result in the conveyor belt being shipped within `days` days.
 *
 * In order for the ship to be able to ship every item in weights, it must be
 * able to ship at least the weight of the item with the largest weight. That
 * is, the ship must have weight capacity of at least max(weights).
 *
 * If the ship were to deliver all items in just one day, the ship would need to
 * ship all items in weights in the same day. That is, the maximum capacity for
 * a ship in this problem is always sum(weights).
 *
 * This means that we have a bounded solution range for any input we are given.
 *
 * Our solution must be in the range [max(weights), sum(weights)].
 *
 * Given the weights and the number of days to ship all items, we can conduct
 * binary search on the bounded range to find the minimum capicity of the ship
 * that could deliver the items in weights in `days` days.
 *
 * That is, we need a function that can tell us whether a ship with capacity C
 * could ship the items in weights W within D days.
 *
 * In terms of our binary search, our initial left value is max(weights), whilst
 * our initial right value is sum(weights).
 *
 * For each iteration in our binary search, we iterate over weights each time.
 * Thus the time complexity for this solution is O(n * log(R)), where R is the
 * search space [max(weights), sum(weights)].
 */
class CapacityToShipPackages {

    static int solve(int[] weights, int days) {
        int left = Arrays.stream(weights).max().orElseThrow();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShipCapacityIn(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    static boolean canShipCapacityIn(int[] weights, int days, int capacity) {
        int totalDays = 1;
        int totalWeight = 0;

        for (int weight : weights) {
            totalWeight += weight;

            if (totalWeight > capacity) {
                totalDays += 1;
                totalWeight = weight;
            }

            if (totalDays > days) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] weights = new int[] { 1, 2, 3, 1, 1 };
        int days = 4;

        int capacity = solve(weights, days);
        System.out.println(capacity);
    }
}
