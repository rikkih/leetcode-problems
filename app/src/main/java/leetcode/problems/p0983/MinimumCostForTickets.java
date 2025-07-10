package leetcode.problems.p0983;

class MinimumCostForTickets {
    int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length];
        return dfs(0, days, costs, cache);
    }

    int dfs(int index, int[] days, int[] costs, int[] cache) {
        if (index >= days.length) {
            return 0;
        }

        if (cache[index] > 0) {
            return cache[index];
        }

        int one = costs[0] + dfs(nextIndex(index, days, days[index] + 1), days, costs, cache);
        int seven = costs[1] + dfs(nextIndex(index, days, days[index] + 7), days, costs, cache);
        int thirty = costs[2] + dfs(nextIndex(index, days, days[index] + 30), days, costs, cache);

        cache[index] = Math.min(one, Math.min(seven, thirty));

        return cache[index];
    }

    int nextIndex(int index, int[] days, int ticketValidUntil) {
        while (index < days.length && days[index] < ticketValidUntil) {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] days = new int[]{ 1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{ 2, 7, 15 };

        MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
        int res = minimumCostForTickets.mincostTickets(days, costs);

        System.out.println(res);
    }
}
