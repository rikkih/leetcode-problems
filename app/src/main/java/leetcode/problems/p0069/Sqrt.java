package leetcode.problems.p0069;

class Sqrt {
    int solve(int x) {
        if (x < 2) {
            return x;
        }

        int left = 0;
        int right = x / 2;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid;

            if (midSquared == x) {
                return mid;
            } else if (midSquared <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();

        var answer = sqrt.solve(2147395599);

        System.out.println(answer);
    }
}
