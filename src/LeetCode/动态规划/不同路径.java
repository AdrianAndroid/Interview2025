package LeetCode.动态规划;

public class 不同路径 {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of paths to each cell
        int[][] dp = new int[m][n];

        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of paths to a cell is the sum of paths from the cell above and the cell to the left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the number of paths to the bottom - right corner
        return dp[m - 1][n - 1];
    }
}
