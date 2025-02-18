package LeetCode.动态规划;

public class 打家劫舍II {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // Case 1: Rob houses from the first to the second - last house
        int result1 = robRange(nums, 0, n - 2);
        // Case 2: Rob houses from the second to the last house
        int result2 = robRange(nums, 1, n - 1);

        // Return the maximum of the two results
        return Math.max(result1, result2);
    }

    private int robRange(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[n - 1];
    }
}
