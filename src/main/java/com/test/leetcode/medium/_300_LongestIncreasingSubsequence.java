package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ben on 2017/10/31.
 */
public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length, max = 0;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int size = 0;
        for (int num : nums) {
            int lo = 0;
            int hi = size - 1;
            if (hi < 0 || dp[hi] < num) {
                hi++;
                dp[hi] = num;
            } else {
                int index = Arrays.binarySearch(dp, lo, size, num);
                if (index < 0) {
                    index = -index - 1;
                }
                dp[index] = num;
            }
            size = hi + 1;
        }
        return size;
    }
}
