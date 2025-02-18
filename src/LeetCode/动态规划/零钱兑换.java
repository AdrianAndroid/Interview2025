package LeetCode.动态规划;

import java.util.Arrays;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        // Initialize the dp array with a value larger than the maximum possible number of coins
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // Base case: 0 coins are needed to make up an amount of 0
        dp[0] = 0;

        // Iterate through each amount from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin denomination
            for (int coin : coins) {
                if (coin <= i) {
                    // Update dp[i] if using the current coin results in a smaller number of coins
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still larger than the amount, it means it's impossible to make up the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
