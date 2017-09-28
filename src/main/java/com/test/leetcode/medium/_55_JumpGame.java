package com.test.leetcode.medium;

/**
 * Created by ben on 2017/9/1.
 */
public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        if (null == nums || nums.length == 0) return true;
        if (nums.length == 1 && nums[0] == 0) return true;

        int len = nums.length;
        int step = 0;
        for (int i = 0; i < len - 1; i++) {
            step = Math.max(nums[i], step);
            if (step == 0) return false;
            step--;
        }
        return true;
    }
}
