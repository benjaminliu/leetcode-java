package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/15.
 */
public class _263_UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        if (num == 1 || num == 2 || num == 3 || num == 4) return true;

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        if (num == 1) return true;
        return false;
    }
}
