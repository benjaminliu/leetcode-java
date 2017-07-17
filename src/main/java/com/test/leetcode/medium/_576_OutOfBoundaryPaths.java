package com.test.leetcode.medium;

/**
 * Created by ben on 2017/7/17.
 */
public class _576_OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int x, int y) {
        int M = 1000000000 + 7;
        int dp[][] = new int[m][n];
        dp[x][y] = 1;
        int count = 0;
        for (int moves = 1; moves <= N; moves++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1)
                        count = (count + dp[i][j]) % M;
                    if (j == n - 1)
                        count = (count + dp[i][j]) % M;
                    if (i == 0)
                        count = (count + dp[i][j]) % M;
                    if (j == 0)
                        count = (count + dp[i][j]) % M;
                    temp[i][j] = (((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M + ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M) % M;
                }
            }
            dp = temp;
        }
        return count;
    }


    private final static int constant = 1000000007;
    private final static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findPaths1(int m, int n, int N, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) return 0;
        int[][] dp = new int[m * n][N];
        for (int x = 0; x < m * n; x++) {
            for (int y = 0; y < N; y++) {
                dp[x][y] = -1;
            }
        }
        return dfs(m, n, N, i, j, dp, 0);
    }

    private int dfs(int m, int n, int N, int i, int j, int[][] dp, int ans) {
        //if outside boundary, count++
        if (i < 0 || i == m || j < 0 || j == n) return 1;
        // Calculate the min to boundary to do pruning
        if (N == 0) return 0;

        // if not visited before
        int row = i * n + j;
        if (dp[row][N - 1] == -1) {
            for (int[] dir : dirs) {
                ans = (dfs(m, n, N - 1, i + dir[0], j + dir[1], dp, 0) + ans) % constant;
            }
            dp[row][N - 1] = ans;
        }

        return dp[row][N - 1];
    }
}
