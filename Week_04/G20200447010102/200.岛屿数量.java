/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        int result = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islandMarking(grid, i, j);
                    ++result;
                }
            }
        }
        return result;
    }

    private void islandMarking(char[][] gird, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || gird[i][j] != '1') return;
        gird[i][j] = '0';
        islandMarking(gird, i + 1, j);
        islandMarking(gird, i - 1, j);
        islandMarking(gird, i, j + 1);
        islandMarking(gird, i, j - 1);
    }
}
// @lc code=end

