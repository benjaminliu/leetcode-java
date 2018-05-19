package com.test.leetcode.medium;

/**
 * Created by ben on 2017/11/9.
 */
public class _304_RangeSumQuery2D_Immutable {

    private int[][] dp;

    public _304_RangeSumQuery2D_Immutable(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {

        } else {
            this.dp = new int[matrix.length + 1][matrix[0].length + 1];
            dp[1][1] = matrix[0][0];
            for (int i = 2; i <= matrix.length; i++) {
                dp[i][1] = dp[i - 1][1] + matrix[i - 1][0];
            }

            for (int i = 2; i <= matrix[0].length; i++) {
                dp[1][i] = dp[1][i - 1] + matrix[0][i - 1];
            }

            for (int i = 2; i <= matrix.length; i++) {
                for (int j = 2; j <= matrix[0].length; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (null == this.dp) return 0;
        if (row1 < 0 || row1 >= dp.length) return 0;
        if (row2 < 0 || row2 >= dp.length) return 0;
        if (col1 < 0 || col1 >= dp[0].length) return 0;
        if (col2 < 0 || col2 >= dp[0].length) return 0;

        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }

}
