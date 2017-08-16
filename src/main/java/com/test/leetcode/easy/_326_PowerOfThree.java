package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/16.
 */
public class _326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n > 0 && 1162261467 % n == 0);
    }
}
