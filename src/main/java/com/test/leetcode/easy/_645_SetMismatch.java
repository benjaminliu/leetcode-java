package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/31.
 */
public class _645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) return res;
        int len = nums.length;
        int[] ns = new int[len];
        int sum = 0;
        for (int n : nums) {
            if (ns[n - 1] == 1) {
                res[0] = n;
            }
            ns[n - 1] = 1;
            sum += n;
        }
        res[1] = res[0] - sum + (len + 1) * len / 2;
        return res;
    }
}
