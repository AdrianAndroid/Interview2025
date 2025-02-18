package LeetCode.动态规划;

public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create a 2D array to store the minimum path sum to each cell
        int[][] dp = new int[m][n];

        // Initialize the first cell
        dp[0][0] = grid[0][0];

        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Initialize the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The minimum path sum to a cell is the minimum of the path sum from the cell above and the cell to the left, plus the value of the current cell
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Return the minimum path sum to the bottom - right corner
        return dp[m - 1][n - 1];
    }
}
