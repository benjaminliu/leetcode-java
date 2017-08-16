package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/16.
 */
public class _342_PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    public boolean isPowerOfFour1(int num) {
        if (num <= 0)
            return false;

        while (num % 4 == 0)
            num = num / 4;

        return num == 1;
    }
}
