package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/23.
 */
public class _209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        int start = 0;
        int end = 0;
        int sum = nums[0];
        int len;
        int minLen = 0;
        while (end < nums.length || start <= end) {
            if (sum >= s) {
                len = end - start + 1;

                if (minLen == 0 || len < minLen)
                    minLen = len;

                sum -= nums[start];
                start++;
            } else {
                if (end < nums.length - 1) {
                    end++;
                    sum += nums[end];
                } else {
                    break;
                }
            }
        }
        return minLen;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
