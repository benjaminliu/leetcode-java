package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/14.
 */
public class _190_ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    public int reverseBits1(int n) {
        long fact = (long) Math.pow(2, 31);
        System.out.println(Long.toBinaryString(fact));
        long sum = 0;
        while (n != 0) {
            sum += (n & 1) * fact;
            System.out.println(Long.toBinaryString(sum));
            n >>>= 1;
            fact >>= 1;
        }
        return (int) sum;
    }
}
