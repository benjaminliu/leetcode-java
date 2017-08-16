package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/16.
 */
public class _303_RangeSumQuery_Immutable {
    int[] nums;

    public _303_RangeSumQuery_Immutable(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return nums[j];

        return nums[j] - nums[i - 1];
    }
}
