package leetcode.problems.p0739;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {

    record TemperatureIndex(int temp, int index) {}

    int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<TemperatureIndex> stack = new ArrayDeque<>();

        for (int index = 0; index < n; index++) {
            while (!stack.isEmpty() && stack.peek().temp() < temperatures[index]) {
                TemperatureIndex previous = stack.pop();
                answer[previous.index()] = index - previous.index();
            }
            stack.push(new TemperatureIndex(temperatures[index], index));
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{ 73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();

        var res = dailyTemperatures.dailyTemperatures(temperatures);

        System.out.println(res);
    }
}
