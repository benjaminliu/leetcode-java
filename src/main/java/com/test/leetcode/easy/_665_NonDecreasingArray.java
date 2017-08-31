package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/31.
 */
public class _665_NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        boolean found = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (found) return false;
                else {
                    if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                    found = true;
                }
            }
        }
        return true;
    }

    public boolean checkPossibility1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }
}
