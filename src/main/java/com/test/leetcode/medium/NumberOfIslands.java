package com.test.leetcode.medium;

/**
 * Created by ben on 2017/6/3.
 */
public class NumberOfIslands {

    private int count;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        count = 0;
        //boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0, m = grid.length; i < m; i++) {
            for (int j = 0, n = grid[0].length; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j]++;
        if (i > 0) {
            dfs(grid, i - 1, j, m, n);
        }
        if (i + 1 < m) {
            dfs(grid, i + 1, j, m, n);
        }
        if (j > 0) {
            dfs(grid, i, j - 1, m, n);
        }
        if (j + 1 < n) {
            dfs(grid, i, j + 1, m, n);
        }
    }
}
