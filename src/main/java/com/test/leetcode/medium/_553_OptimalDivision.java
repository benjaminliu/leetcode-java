package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/18.
 */
public class _553_OptimalDivision {

    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        int length = nums.length - 1;
        for (int i = 1; i < length; i++) {
            sb.append(nums[i]);
            sb.append("/");
        }
        sb.append(nums[length]);
        sb.append(")");

        return sb.toString();
    }
}
