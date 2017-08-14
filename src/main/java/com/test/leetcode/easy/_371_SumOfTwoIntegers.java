package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/27.
 */
public class _371_SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b);
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public int getSum1(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
            System.out.println("a=" + a + ", b=" + b + ", carray=" + carry);
        }
        return a;
    }
}
