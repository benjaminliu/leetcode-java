package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/20.
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }
        int result = 0;
        for (int i : nums) {
            result += i - min;
        }
        return result;
    }

    public int minMoves1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums) {
            min = Math.min(min, i);
            sum += i;
        }
        sum = sum - min * nums.length;
        return sum;
    }
}
