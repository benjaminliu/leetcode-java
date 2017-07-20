package com.test.leetcode.easy;

/**
 * Created by ben on 2017/7/18.
 */
public class _26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lastNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[lastNum]) {
                nums[++lastNum] = nums[i];
            }
        }
        return lastNum + 1;
    }
}
