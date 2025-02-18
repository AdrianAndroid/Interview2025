package LeetCode.动态规划;

public class 爬楼梯 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // Initialize the first two steps
        int first = 1;
        int second = 2;
        int result = 0;
        // Iterate from the 3rd step to the n-th step
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        爬楼梯 solution = new 爬楼梯();
        int n = 10;
        System.out.println(solution.climbStairs(n)); // Output: 3
    }
}
