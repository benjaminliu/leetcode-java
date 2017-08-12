package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/22.
 */
public class _238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int length = nums.length;
        int[] left = new int[length - 1];
        int[] right = new int[length - 1];
        int leftProd = 1;
        int rightProd = 1;
        for (int i = 0, len = length - 1; i < len; i++) {
            left[i] = leftProd = leftProd * nums[i];
            right[i] = rightProd = rightProd * nums[length - i - 1];
        }

        int[] res = new int[length];
        res[0] = right[length - 1 - 1];
        res[length - 1] = left[length - 1 - 1];
        for (int i = 1, len = length - 1; i < len; i++) {
            res[i] = left[i - 1] * right[len - 1 - i];
        }
        return res;
    }
}
