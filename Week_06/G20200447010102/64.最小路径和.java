/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m -1; j >= 0; j--) {
                if (i == n - 1 && j != m - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                else if (i != n - 1 && j == m - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                else if (i != n - 1 && j != m - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

