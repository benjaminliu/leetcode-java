package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/24.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int colomn = grid[0].length;
        boolean needBreak = false;
        int perimeter = 0;
        boolean[][] visited = new boolean[row][colomn];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colomn; j++) {
                if (grid[i][j] == 1) {
                    perimeter = dfs(grid, i, j, row, colomn, visited);
                    needBreak = true;
                    break;
                }

            }
            if (needBreak) {
                break;
            }
        }
        return perimeter;
    }

    private int dfs(int[][] grid, int i, int j, int row, int colomn, boolean[][] visited) {
        if (i < 0 || i >= row || j < 0 || j >= colomn || grid[i][j] == 0) {
            return 0;
        }
        if (visited[i][j]) {
            return -1;
        }
        visited[i][j] = true;
        int p = 4;
        int up = dfs(grid, i - 1, j, row, colomn, visited);
        if (up > 0) {
            p--;
        }
        int down = dfs(grid, i + 1, j, row, colomn, visited);
        if (down > 0) {
            p--;
        }
        int left = dfs(grid, i, j - 1, row, colomn, visited);
        if (left > 0) {
            p--;
        }
        int right = dfs(grid, i, j + 1, row, colomn, visited);
        if (right > 0) {
            p--;
        }
        return up + down + left + right + p;
    }

    public int islandPerimeter2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        int duplicate = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;

                    if (i != 0) {
                        if (grid[i - 1][j] == 1) {
                            duplicate++;
                        }
                    }
                    if (i != grid.length - 1) {
                        if (grid[i + 1][j] == 1) {
                            duplicate++;
                        }
                    }
                    if (j != 0) {
                        if (grid[i][j - 1] == 1) {
                            duplicate++;
                        }
                    }
                    if (j != grid[0].length - 1) {
                        if (grid[i][j + 1] == 1) {
                            duplicate++;
                        }
                    }
                }
            }
        }
        return count - duplicate;
    }

}
