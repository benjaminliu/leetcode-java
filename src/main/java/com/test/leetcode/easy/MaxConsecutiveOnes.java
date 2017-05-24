package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/24.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (int n : nums) {
            if (n == 1) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }
        if (max < count) {
            max = count;
        }
        return max;
    }
}
