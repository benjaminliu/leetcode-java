package com.test.leetcode.medium;

/**
 * Created by ben on 2017/9/9.
 */
public class _75_SortColors {
    public void sortColors(int[] nums) {
        if (null == nums || nums.length == 0) return;

        int[] colors = new int[3];
        for (int n : nums) {
            colors[n] += 1;
        }
        int i = 0;
        int end = colors[0];
        for (; i < end; i++) {
            nums[i] = 0;
        }
        end += colors[1];
        for (; i < end; i++) {
            nums[i] = 1;
        }
        end += colors[2];
        for (; i < end; i++) {
            nums[i] = 2;
        }
    }
}
