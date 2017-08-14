package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/14.
 */
public class _191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
    public int hammingWeight2(int n) {
        int distance = 0;
        while (n != 0) {
            distance += 1;
            n &= (n - 1);
        }
        return distance;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while(n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
