package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/25.
 */
public class _221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] d = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1') {
                d[i][0] = 1;
                max = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1') {
                d[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0') d[i][j] = 0;
                else {
                    d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
                    max = Math.max(max, d[i][j]);
                }
            }
        }
        return max * max;
    }


    public int maximalSquare1(char[][] matrix) {

        int m = matrix.length;
        int n = (m > 0) ? matrix[0].length : 0;
        int[] dp = new int[n];
        int counter = 0, nextMax, curMax = 0;

        for (int i = 0; i < m; i++) {
            nextMax = curMax + 1;
            counter = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    dp[j] += 1;
                else {
                    dp[j] = 0;
                    counter = 0;
                }

                if (dp[j] >= nextMax && counter < nextMax)
                    counter++;
                else
                    counter = 0;

                if (counter >= nextMax) {
                    curMax = counter;
                    counter = 0;
                }
            }
        }
        return curMax * curMax;
    }


    public int maximalSquare2(char[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0)
            return 0;

        int max = 0, n = a.length, m = a[0].length;

        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) } + 1
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        // return the area
        return max * max;
    }
}
