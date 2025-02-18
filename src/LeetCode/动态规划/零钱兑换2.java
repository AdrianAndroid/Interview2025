package LeetCode.动态规划;

public class 零钱兑换2 {
    public int change(int amount, int[] coins) {
        // Create a dp array to store the number of combinations for each amount
        int[] dp = new int[amount + 1];
        // Initialize dp[0] to 1, as there is one way to make up amount 0 (using no coins)
        dp[0] = 1;

        // Iterate through each coin denomination
        for (int coin : coins) {
            // Update the dp array for each amount from coin to the target amount
            for (int i = coin; i <= amount; i++) {
                // The number of combinations to make up amount i is the sum of the original number of combinations
                // and the number of combinations to make up amount i - coin
                dp[i] += dp[i - coin];
            }
        }

        // Return the number of combinations to make up the target amount
        return dp[amount];
    }
}
