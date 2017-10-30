package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/15.
 */
public class _263_UglyNumber {
    public int nthUglyNumber(int n) {
        if (n <= 0) return -1;
        int[] uglyNumber = new int[n];
        int u2 = 0, u3 = 0, u5 = 0;
        uglyNumber[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNumber[i] = Math.min(uglyNumber[u2] * 2, Math.min(uglyNumber[u3] * 3, uglyNumber[u5] * 5));

            if (uglyNumber[i] == uglyNumber[u2] * 2) {
                u2++;
            }
            if (uglyNumber[i] == uglyNumber[u3] * 3) {
                u3++;
            }
            if (uglyNumber[i] == uglyNumber[u5] * 5) {
                u5++;
            }
        }
        return uglyNumber[n - 1];
    }
}
