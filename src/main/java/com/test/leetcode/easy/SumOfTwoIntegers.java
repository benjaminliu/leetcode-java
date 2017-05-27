package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/27.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b);
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
