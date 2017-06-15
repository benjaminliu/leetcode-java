package com.test.leetcode.easy;

/**
 * Created by ben on 2017/6/15.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        return climb(n, dp);
    }

    private int climb(int n, int[] dp) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (dp[n] > 0) {
            return dp[n];
        }

        int n1 = climb(n - 1, dp);
        int n2 = climb(n - 2, dp);
        dp[n] = n1 + n2;
        return dp[n];
    }

    public int climbStairs1(int n) {
        if (n == 1 || n == 0) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
