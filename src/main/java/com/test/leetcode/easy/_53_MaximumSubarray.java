package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/13.
 */
public class _53_MaximumSubarray {


    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        int len = nums.length;
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < len; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = nums[i];
            } else {
                maxEndingHere += nums[i];
            }
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                temp[i] = nums[i];
            } else {
                if (temp[i - 1] >= 0) {
                    temp[i] = temp[i - 1] + nums[i];
                } else {
                    temp[i] = nums[i];
                }
            }
        }
        int max = temp[0];
        for (int i = 0; i < len; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }
}
