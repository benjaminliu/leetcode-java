package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/15.
 */
public class _231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;

        if (n == 1) return true;

        while ((n & 1) != 1) {
            n >>= 1;
        }
        if (n > 1) return false;
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
