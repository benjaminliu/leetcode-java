package com.test.leetcode.easy;

/**
 * Created by ben on 2017/7/18.
 */
public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else {
                if (count > 0) {
                    nums[i - count] = nums[i];
                }
            }
        }
        return nums.length - count;
    }
}
