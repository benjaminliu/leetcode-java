package com.test.leetcode.easy;

/**
 * Created by ben on 2017/7/9.
 */
public class _7ReverseInteger {
    public int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x *= flag;
        }

        long result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result * flag;
    }
}
