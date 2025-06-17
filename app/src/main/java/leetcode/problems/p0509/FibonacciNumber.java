package leetcode.problems.p0509;

import java.util.Arrays;

public class FibonacciNumber {
    int fibNaive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibNaive(n-1) + fibNaive(n-2);
    }

    int fibMemoization(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];

        memo[n] = fibMemoization(n-1, memo) + fibMemoization(n-2, memo);

        return memo[n];
    }

    int fibIterative(int n) {
        if (n <= 1) return n;

        int prev = 0, current = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibMemoization(n, memo);
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();

//        var result = fibonacciNumber.fibNaive(7);
//        var result = fibonacciNumber.fib(7);
        var result = fibonacciNumber.fibIterative(6);

        System.out.println(result);
    }
}
