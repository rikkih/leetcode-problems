package leetcode.problems.p0704;

public class Main {
    public static void main(String[] args) {
        BinarySearch BinarySearch = new BinarySearch();

        var answer = BinarySearch.solve(new int[] { 2, 4, 6, 7, 8, 11, 14 }, 4);

        System.out.println("Answer: " + answer);
    }
}
