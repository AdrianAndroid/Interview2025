package LeetCode.动态规划;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // Create a dp array to store the maximum amount of money that can be robbed from the first i houses
        int[] dp = new int[n];
        // Initialize the first two elements of the dp array
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            // The maximum amount of money that can be robbed from the first i houses is the maximum of:
            // 1. The maximum amount of money that can be robbed from the first i - 1 houses
            // 2. The maximum amount of money that can be robbed from the first i - 2 houses plus the money in the i - th house
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // Return the maximum amount of money that can be robbed from all the houses
        return dp[n - 1];
    }
}
