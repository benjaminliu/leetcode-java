package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ben on 2017/5/20.
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int avg = nums[ nums.length / 2];

        int moves = 0;
        for (int i : nums) {
            moves += Math.abs(avg - i);
        }
        return moves;
    }
}
