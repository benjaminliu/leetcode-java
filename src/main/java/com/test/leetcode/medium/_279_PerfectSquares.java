package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ben on 2017/10/30.
 */
public class _279_PerfectSquares {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        //n = 1 + 1 + 1 + ... + 1
        for (int i = 1; i <= n; i++) nums[i] = i;

        for (int i = 2; i <= n; i++) {
            for (int j = 1, k = 1; k <= i; j++, k = j * j) {
                nums[i] = Math.min(nums[i], nums[i - k] + 1);
            }
        }
        return nums[n];
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
