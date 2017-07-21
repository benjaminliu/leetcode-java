package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ben on 2017/7/20.
 */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int len = nums.length;
        int rep1 = -1;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                rep1 = i - 1;
                break;
            }
        }
        if (rep1 == -1) {
            Arrays.sort(nums);
            return;
        }
        int rep2 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i > rep1; i--) {
            if (min > nums[i] && nums[i] > nums[rep1]) {
                min = nums[i];
                rep2 = i;
            }
        }
        nums[rep2] = nums[rep1];
        nums[rep1] = min;

        Arrays.sort(nums, rep1 + 1, len);
    }
}
