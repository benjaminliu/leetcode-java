package com.test.leetcode.medium;

/**
 * Created by ben on 2017/9/29.
 */
public class _137_SingleNumber_II {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if (sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }

    public int singleNumber1(int[] nums) {
        int one = 0, two = 0;

        for (int x : nums) {
            one = (one ^ x) & (~two);
            two = (two ^ x) & (~one);
        }

        return one;
    }
}
