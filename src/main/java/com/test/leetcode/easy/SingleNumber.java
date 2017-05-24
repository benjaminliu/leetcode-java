package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/24.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int i = nums[0];
        for (int j = 1, length = nums.length; j < length; j++) {
            i ^= nums[j];
        }
        return i;
    }
}
