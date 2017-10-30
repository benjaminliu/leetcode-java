package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/17.
 */
public class _152_MaximumProductSubarray {

    //Negative * Negative = positive,
    //So we need to store the min value(maybe Negative), in case it * another Negative
    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        if (nums.length < 2) return nums[0];

        int global = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = max * nums[i];
            int b = min * nums[i];

            max = Math.max(nums[i], Math.max(a, b));
            min = Math.min(nums[i], Math.min(a, b));
            global = Math.max(max, global);
        }
        return global;
    }
}
