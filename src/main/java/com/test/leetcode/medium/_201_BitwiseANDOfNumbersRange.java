package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/18.
 */
public class _201_BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int bit = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            bit++;
        }
        return m << bit;
    }

    public int rangeBitwiseAnd1(int m, int n) {
        int count = 0;
        if (m == n) {
            return m;
        }
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            count++;
    }
        return m << count;
    }
}
