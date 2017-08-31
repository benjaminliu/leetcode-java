package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/31.
 */
public class _643_MaximumAverageSubarray_I {
    public double findMaxAverage(int[] nums, int k) {
        if (null == nums || nums.length == 0) return 0;
        if (k == 0) return 0;

        if (nums.length <= k) {
            double sum = 0;
            for (int i : nums) sum += i;
            return sum / nums.length;
        }

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            if (sum > maxSum) maxSum = sum;
        }

        return maxSum / k;
    }
}
