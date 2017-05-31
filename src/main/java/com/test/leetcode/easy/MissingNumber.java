package com.test.leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by ben on 2017/5/31.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0, lenght = nums.length; i < lenght; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    // A number XOR itself will become 0, any number XOR with 0 will stay unchanged.
    // So if every number from 1...n XOR with itself except the missing number,
    // the result will be the missing number.
    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int sum1 = 0, sum2;

        for (int i : nums) {
            sum1 = sum1 + i;
        }

        sum2 = (nums.length * (nums.length + 1)) / 2;

        return sum2 - sum1;
    }
}
