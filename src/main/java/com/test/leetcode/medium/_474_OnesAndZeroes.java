package com.test.leetcode.medium;

/**
 * Created by ben on 2017/8/12.
 */
public class _474_OnesAndZeroes {
    //类似 0,1 背包问题
    public int findMaxForm(String[] strs, int m, int n) {
        if (null == strs || strs.length == 0) return 0;

        if (m == 0 && n == 0) return 0;

        int count0, count1;

        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            count0 = 0;
            count1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') count0++;
                else count1++;
            }

            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
